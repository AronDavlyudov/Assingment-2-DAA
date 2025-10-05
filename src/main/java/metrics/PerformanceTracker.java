package metrics;

public class PerformanceTracker {
    public int comparisons = 0;
    public int swaps = 0; // Not used in Kadane's algorithm but useful for sorting algorithms
    public int arrayAccesses = 0;
    public int memoryAllocations = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Comparisons: %d, Array Accesses: %d, Memory Allocations: %d",
                comparisons, arrayAccesses, memoryAllocations
        );
    }
}