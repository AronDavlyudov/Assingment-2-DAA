package cli;

import algorithms.KadaneAlgorithm;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int size = 1000;

        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }

        int[] input = generateRandomArray(size);
        PerformanceTracker tracker = new PerformanceTracker();

        long startTime = System.nanoTime();
        KadaneAlgorithm.Result result = KadaneAlgorithm.findMaxSubarray(input, tracker);
        long endTime = System.nanoTime();

        System.out.println(result);
        System.out.println(tracker);
        System.out.printf("Execution Time: %.4f ms%n", (endTime - startTime) / 1e6);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
        }
        return arr;
    }
}