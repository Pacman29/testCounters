package com.pacman29.testsber.services;

import com.pacman29.testsber.exceptions.CounterAlreadyExistsException;
import com.pacman29.testsber.exceptions.CounterNotFoundException;
import com.pacman29.testsber.models.Counter;
import com.pacman29.testsber.models.CounterValue;

import java.util.ArrayList;

public interface ICounterService {
    Integer getSummary();

    Counter getCounterByName(String name) throws CounterNotFoundException;

    ArrayList<Counter> getCounters();

    boolean createCounter(Counter counter) throws CounterAlreadyExistsException;

    boolean updateCounter(String counterName, CounterValue counter) throws CounterNotFoundException;

    boolean deleteCounter(String counterName) throws CounterNotFoundException;
}
