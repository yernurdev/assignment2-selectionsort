package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000, 100000};
        String[] cases = {"random", "sorted", "reversed", "nearly"};

        try (FileWriter writer = new FileWriter("docs/performance-plots/selectionsort_results.csv")) {
            writer.write("case,n,time(ms),comparisons,swaps\n");

            for (String c : cases) {
                for (int n : sizes) {
                    int[] arr = generateArray(n, c);
                    PerformanceTracker tracker = new PerformanceTracker();
                    SelectionSort sorter = new SelectionSort(tracker);

                    long start = System.currentTimeMillis();
                    sorter.sort(arr);
                    long end = System.currentTimeMillis();

                    writer.write(c + "," + n + "," + (end - start) + "," +
                            tracker.getComparisons() + "," + tracker.getSwaps() + "\n");
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
                // небольшой "шум"
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
