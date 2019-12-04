package com.pacman29.testsber.models;

public class CounterValue {

    private Integer value = null;

    public CounterValue() {}

    public CounterValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
