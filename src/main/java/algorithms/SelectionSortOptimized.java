package algorithms;

import metrics.PerformanceTracker;

public class SelectionSortOptimized {
    private PerformanceTracker tracker;

    public SelectionSortOptimized(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean foundSmaller = false;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    foundSmaller = true;
                }
            }

            if (foundSmaller) {
                swap(arr, i, minIndex);
                tracker.incrementSwaps();
            } else {
                break; // early termination if array is already sorted
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
