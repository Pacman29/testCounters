package com.pacman29.testsber.services;

import com.pacman29.testsber.exceptions.CounterAlreadyExistsException;
import com.pacman29.testsber.exceptions.CounterNotFoundException;
import com.pacman29.testsber.models.Counter;
import com.pacman29.testsber.models.CounterValue;
import com.pacman29.testsber.repositories.ICounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CounterService implements ICounterService {

    private final ICounterRepository counterRepository;

    @Autowired
    public CounterService(ICounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public Integer getSummary(){
        Collection<Counter> counters = counterRepository.getCounters();
        return counters.stream().map(Counter::getValue).reduce(0, Integer::sum);
    }

    @Override
    public Counter getCounterByName(String counterName) throws CounterNotFoundException {
        Counter counter = counterRepository.findCounterByName(counterName);
        if(counter == null) {
            throw new CounterNotFoundException(counterName);
        }
        return counter;
    }

    @Override
    public ArrayList<Counter> getCounters() {
        return new ArrayList<>(counterRepository.getCounters());
    }

    @Override
    public boolean createCounter(Counter counter)  throws CounterAlreadyExistsException {
        boolean res;
        Counter presentCounter = counterRepository.addCounter(counter);
        if(presentCounter != null) {
            throw new CounterAlreadyExistsException(counter.getName());
        }
        res = true;
        return res;
    }

    @Override
    public boolean updateCounter(String counterName, CounterValue counter) throws CounterNotFoundException {
        boolean res;
        Counter presentCounter = counterRepository.updateCounter(counterName, counter);
        if(presentCounter == null) {
            throw new CounterNotFoundException(counterName);
        }
        res = true;
        return res;
    }

    @Override
    public boolean deleteCounter(String counterName) throws CounterNotFoundException {
        boolean res;
        Counter presentCounter = counterRepository.deleteCounterByName(counterName);
        if(presentCounter == null) {
            throw new CounterNotFoundException(counterName);
        }
        res = true;
        return res;
    }


}
