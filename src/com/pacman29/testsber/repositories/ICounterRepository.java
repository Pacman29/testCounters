package com.pacman29.testsber.repositories;

import com.pacman29.testsber.models.Counter;
import com.pacman29.testsber.models.CounterValue;

import java.util.Collection;

public interface ICounterRepository {
    Counter findCounterByName(String name);

    Collection<Counter> getCounters();

    Counter addCounter(Counter counter);

    Counter updateCounter(String counterName, CounterValue counter);

    Counter deleteCounterByName(String name);
}
