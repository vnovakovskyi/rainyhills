package com.test.rainyhills.service;

import org.springframework.stereotype.Service;

/**
 * This service is calculating how much water will remain on road pits after the rain.
 */
@Service
public class WaterValueCounterService {
    public int count(int[] surface) {
        if (surface == null) {
            throw new IllegalArgumentException("Surface array cannot be null!");
        }
        return countWaterValue(surface);
    }

    /**
     * This method is calculating water value.
     *
     * @param array an array of int, that describes profile of a surface
     * @return the result of algorithm work
     * <p>
     * Algorithm complexity is:
     * Time: O(n)
     * Memory: O(n)
     */
    private int countWaterValue(int[] array) {
        int[] leftToRightBiggest = new int[array.length];
        int[] rightToLeftBiggest = new int[array.length];
        int waterValue = 0;

        leftToRightBiggest[0] = array[0];
        for (int i = 1; i < array.length; ++i) {
            leftToRightBiggest[i] = Math.max(leftToRightBiggest[i - 1], array[i]);
        }

        rightToLeftBiggest[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; --i) {
            rightToLeftBiggest[i] = Math.max(rightToLeftBiggest[i + 1], array[i]);
        }

        for (int i = 0; i < array.length; ++i) {
            waterValue += Math.min(leftToRightBiggest[i], rightToLeftBiggest[i]) - array[i];
        }

        return waterValue;
    }
}
