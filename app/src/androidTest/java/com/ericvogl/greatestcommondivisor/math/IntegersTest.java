package com.ericvogl.greatestcommondivisor.math;

import com.google.common.base.Optional;

import junit.framework.TestCase;

public class IntegersTest extends TestCase {
    public void testTryParse_withNull_returnsAbsent() {
        assertAbsent(Integers.tryParse(null));
    }

    public void testTryParse_withEmptyString_returnsAbsent() {
        assertAbsent(Integers.tryParse(""));
    }

    public void testTryParse_withNonInteger_returnsAbsent() {
        assertAbsent(Integers.tryParse("Chuck Norris"));
    }

    public void testTryParse_withInteger_returnsInteger() {
        assertOptionalEquals(1, Integers.tryParse("1"));
    }

    public void testTryParse_withNegativeInteger_returnsInteger() {
        assertOptionalEquals(-1, Integers.tryParse("-1"));
    }

    private static <T> void assertAbsent(Optional<T> optional) {
        assertFalse(optional.isPresent());
    }

    private static <T> void assertOptionalEquals(T expected, Optional<T> actual) {
        assertNotNull(expected);
        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }
}
