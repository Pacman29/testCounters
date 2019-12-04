package com.pacman29.testsber.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class Counter extends CounterValue {
    @NotEmpty(message = "Please provide a name")
    private String name;

    public Counter(@NotEmpty(message = "Please provide a name") String name, Integer value) {
        super(value);
        this.name = name;
    }
}
