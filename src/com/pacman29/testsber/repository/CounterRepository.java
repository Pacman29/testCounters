package com.pacman29.testsber.repository;

import com.pacman29.testsber.model.Counter;
import com.pacman29.testsber.model.CounterValue;

import java.util.Collection;

public interface CounterRepository {
    Counter findCounterByName(String name);

    Collection<Counter> getCounters();

    Counter addCounter(Counter counter);

    Counter updateCounter(String counterName, CounterValue counter);

    Counter deleteCounterByName(String name);
}
