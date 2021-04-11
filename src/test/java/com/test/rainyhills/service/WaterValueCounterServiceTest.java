package com.test.rainyhills.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WaterValueCounterServiceTest {

    WaterValueCounterService service = new WaterValueCounterService();

    @Test
    void test_count_success() {
        int result = service.count(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, result);
    }

    @Test
    void test_count_success_with_single_element() {
        int result = service.count(new int[]{9});
        assertEquals(0, result);
    }

    @Test
    void test_count_failure() {
        int result = service.count(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertNotEquals(8, result);
    }

    @Test
    void test_count_with_null() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.count(null)
        );
    }
}
