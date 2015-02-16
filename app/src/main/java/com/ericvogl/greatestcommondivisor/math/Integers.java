package com.ericvogl.greatestcommondivisor.math;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

public class Integers {
    private Integers() {
    }

    public static Optional<Integer> tryParse(String s) {
        if (Strings.isNullOrEmpty(s)) {
            return Optional.absent();
        }
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.absent();
        }
    }
}
