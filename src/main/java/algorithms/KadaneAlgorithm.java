package algorithms;

import metrics.PerformanceTracker;

public class KadaneAlgorithm {

    public static class Result {
        public long maxSum;

        public Result(long maxSum) {
            this.maxSum = maxSum;
        }
    }

    public static Result findMaxSubarray(int[] arr, PerformanceTracker t) {
        if (arr == null || arr.length == 0) return new Result(0);
        if (t == null) t = new PerformanceTracker();

        t.start();

        long maxSum = arr[0];
        long currentSum = arr[0];
        t.addAccess(2); // accessing arr[0] twice

        for (int i = 1; i < arr.length; i++) {
            t.addAccess(1);
            t.addCompare();
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        t.stop();
        return new Result(maxSum);
    }

    public static Result findMaxSubarray(int[] arr) {
        return findMaxSubarray(arr, new PerformanceTracker());
    }
}