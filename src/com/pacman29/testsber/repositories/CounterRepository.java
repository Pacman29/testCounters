package com.pacman29.testsber.repositories;

import com.pacman29.testsber.models.Counter;
import com.pacman29.testsber.models.CounterValue;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CounterRepository implements ICounterRepository {
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
