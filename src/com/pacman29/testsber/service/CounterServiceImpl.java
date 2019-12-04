package com.pacman29.testsber.service;

import com.pacman29.testsber.exception.CounterAlreadyExistsException;
import com.pacman29.testsber.exception.CounterNotFoundException;
import com.pacman29.testsber.model.Counter;
import com.pacman29.testsber.model.CounterValue;
import com.pacman29.testsber.model.Summary;
import com.pacman29.testsber.repositorie.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public Summary getSummary() {
        Collection<Counter> counters = counterRepository.getCounters();
        return new Summary(counters.stream().map(Counter::getValue).reduce(0, Integer::sum));
    }

    @Override
    public Counter getCounterByName(String counterName) throws CounterNotFoundException {
        Counter counter = counterRepository.findCounterByName(counterName);
        if (counter == null) {
            throw new CounterNotFoundException(counterName);
        }
        return counter;
    }

    @Override
    public List<Counter> getCounters() {
        return new ArrayList<>(counterRepository.getCounters());
    }

    @Override
    public Counter createCounter(Counter counter) throws CounterAlreadyExistsException {
        Counter existCounter = counterRepository.addCounter(counter);
        if (existCounter != null)
            throw new CounterAlreadyExistsException(counter.getName());
        return getCounterByName(counter.getName());
    }

    @Override
    public Counter updateCounter(String counterName, CounterValue counter) throws CounterNotFoundException {
        Counter changedCounter = counterRepository.updateCounter(counterName, counter);
        if (changedCounter == null)
            throw new CounterNotFoundException(counterName);
        return changedCounter;
    }

    @Override
    public Counter deleteCounter(String counterName) throws CounterNotFoundException {
        Counter deletedCounter = counterRepository.deleteCounterByName(counterName);
        if (deletedCounter == null)
            throw new CounterNotFoundException(counterName);
        return deletedCounter;
    }


}
