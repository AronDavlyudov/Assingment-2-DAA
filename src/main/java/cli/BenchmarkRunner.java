package cli;

import algorithms.KadaneAlgorithm;
import metrics.PerformanceTracker;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};

        try (FileWriter writer = new FileWriter("results.csv")) {
            writer.write("InputSize,TimeMs,Comparisons,ArrayAccesses,MemoryAllocations\n");

            for (int size : sizes) {
                int[] input = generateRandomArray(size);
                PerformanceTracker tracker = new PerformanceTracker();

                long startTime = System.nanoTime();
                KadaneAlgorithm.Result result = KadaneAlgorithm.findMaxSubarray(input, tracker);
                long endTime = System.nanoTime();
                double timeMs = (endTime - startTime) / 1e6;

                writer.write(String.format("%d,%.4f,%d,%d,%d\n",
                        size, timeMs, tracker.comparisons, tracker.arrayAccesses, tracker.memoryAllocations));

                System.out.printf("Size: %d → Max Sum: %d (%.4f ms)\n", size, result.maxSum, timeMs);
            }

            System.out.println("Benchmark results saved to results.csv");

        } catch (IOException e) {
            System.err.println("Error writing results: " + e.getMessage());
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100; // [-100, 100]
        }
        return arr;
    }
}