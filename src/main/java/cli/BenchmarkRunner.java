package cli;

import algorithms.SelectionSort;
import algorithms.SelectionSortOptimized;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000, 100000};
        String[] cases = {"random", "sorted", "reversed", "nearly"};

        try (FileWriter writer = new FileWriter("docs/performance-plots/selectionsort_results.csv")) {
            writer.write("algorithm,case,n,time(ms),comparisons,swaps\n");

            for (String c : cases) {
                for (int n : sizes) {
                    int[] arr1 = generateArray(n, c);
                    int[] arr2 = arr1.clone(); // копия того же массива для честного сравнения

                    // --- Normal Selection Sort ---
                    PerformanceTracker tracker1 = new PerformanceTracker();
                    SelectionSort sorter1 = new SelectionSort(tracker1);

                    long start1 = System.currentTimeMillis();
                    sorter1.sort(arr1);
                    long end1 = System.currentTimeMillis();

                    writer.write("SelectionSort," + c + "," + n + "," + (end1 - start1) + "," +
                            tracker1.getComparisons() + "," + tracker1.getSwaps() + "\n");

                    // --- Optimized Selection Sort ---
                    PerformanceTracker tracker2 = new PerformanceTracker();
                    SelectionSortOptimized sorter2 = new SelectionSortOptimized(tracker2);

                    long start2 = System.currentTimeMillis();
                    sorter2.sort(arr2);
                    long end2 = System.currentTimeMillis();

                    writer.write("SelectionSortOptimized," + c + "," + n + "," + (end2 - start2) + "," +
                            tracker2.getComparisons() + "," + tracker2.getSwaps() + "\n");
                }
            }
        }
    }

    private static int[] generateArray(int n, String type) {
        int[] arr = new int[n];
        Random rand = new Random();

        switch (type) {
            case "random":
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n);
                break;
            case "sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;
            case "nearly":
                for (int i = 0; i < n; i++) arr[i] = i;
                for (int i = 0; i < n / 10; i++) {
                    int idx1 = rand.nextInt(n);
                    int idx2 = rand.nextInt(n);
                    int temp = arr[idx1];
                    arr[idx1] = arr[idx2];
                    arr[idx2] = temp;
                }
                break;
        }
        return arr;
    }
}
