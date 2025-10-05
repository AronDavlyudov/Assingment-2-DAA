package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KadaneAlgorithmTest {

    @Test
    public void testNormalCase() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        KadaneAlgorithm.Result result = KadaneAlgorithm.findMaxSubarray(arr, tracker);
        assertEquals(6, result.maxSum);
        assertEquals(3, result.start);
        assertEquals(6, result.end);
    }

    @Test
    public void testAllNegative() {
        int[] arr = {-8, -3, -6, -2, -5, -4};
        PerformanceTracker tracker = new PerformanceTracker();
        KadaneAlgorithm.Result result = KadaneAlgorithm.findMaxSubarray(arr, tracker);
        assertEquals(-2, result.maxSum);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {5};
        PerformanceTracker tracker = new PerformanceTracker();
        KadaneAlgorithm.Result result = KadaneAlgorithm.findMaxSubarray(arr, tracker);
        assertEquals(5, result.maxSum);
        assertEquals(0, result.start);
        assertEquals(0, result.end);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        assertThrows(IllegalArgumentException.class, () -> {
            KadaneAlgorithm.findMaxSubarray(arr, tracker);
        });
    }

    @Test
    public void testNullArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        assertThrows(IllegalArgumentException.class, () -> {
            KadaneAlgorithm.findMaxSubarray(null, tracker);
        });
    }
}