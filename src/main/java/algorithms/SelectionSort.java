package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {
    private PerformanceTracker tracker;

    public SelectionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            swapped = false;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                    swapped = true;
                }
            }

            if (swapped) {
                tracker.incrementSwaps();
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            } else {
                break; // массив уже отсортирован
            }
        }
    }
}
