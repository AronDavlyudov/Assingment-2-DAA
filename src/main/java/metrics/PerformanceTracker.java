package metrics;

public class PerformanceTracker {

    public long comparisons = 0;
    public long swaps = 0; // For sorting algorithms
    public long arrayAccesses = 0;
    public long memoryAllocations = 0;

    private long startTimeNs;
    private long endTimeNs;

    public void start() {
        startTimeNs = System.nanoTime();
    }

    public void stop() {
        endTimeNs = System.nanoTime();
    }

    public long elapsedMillis() {
        return (endTimeNs - startTimeNs) / 1_000_000;
    }

    public void addCompare() {
        comparisons++;
    }

    public void addAccess(int count) {
        arrayAccesses += count;
    }

    public void addSwap() {
        swaps++;
    }

    public void addMemoryAllocation(int count) {
        memoryAllocations += count;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
        startTimeNs = 0;
        endTimeNs = 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Time: %d ms, Comparisons: %d, Accesses: %d, Allocations: %d",
                elapsedMillis(), comparisons, arrayAccesses, memoryAllocations
        );
    }
}