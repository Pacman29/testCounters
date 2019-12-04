package com.pacman29.testsber.exceptions;

public class CounterNotFoundException extends RuntimeException {
    public CounterNotFoundException(String counterName) {
        super(String.format("Counter with name: %s not found", counterName));
    }
}
