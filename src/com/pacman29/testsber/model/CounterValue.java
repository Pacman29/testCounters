package com.pacman29.testsber.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CounterValue {
    private Integer value = null;
}
