package com.pacman29.testsber.repositorie;

import com.pacman29.testsber.model.Counter;
import com.pacman29.testsber.model.CounterValue;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CounterRepositoryImpl implements CounterRepository {
    private final Map<String, Counter> storage = new ConcurrentHashMap<>();

    @Override
    public Counter findCounterByName(String name) {
        return storage.get(name);
    }

    @Override
    public Collection<Counter> getCounters() {
        return storage.values();
    }

    @Override
    public Counter addCounter(Counter counter) {
        return storage.putIfAbsent(counter.getName(), counter);
    }

    @Override
    public Counter updateCounter(String counterName, CounterValue counter) {
        return storage.computeIfPresent(counterName, (key, value) -> {
            value.setValue(counter.getValue());
            return value;
        });
    }

    @Override
    public Counter deleteCounterByName(String name) {
        return storage.remove(name);
    }

}
