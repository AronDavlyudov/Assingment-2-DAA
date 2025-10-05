package algorithms;

import metrics.PerformanceTracker;

public class KadaneAlgorithm {

    public static class Result {
        public int maxSum;
        public int start;
        public int end;

        public Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("Max Sum: %d, Start Index: %d, End Index: %d", maxSum, start, end);
        }
    }

    public static Result findMaxSubarray(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0;
        int tempStart = 0;
        int end = 0;

        tracker.memoryAllocations += 5;

        for (int i = 1; i < arr.length; i++) {
            tracker.arrayAccesses += 2;
            tracker.comparisons++;

            if (currentSum < 0) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new Result(maxSum, start, end);
    }
}