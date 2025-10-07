package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {3, 1, 2, 1, 3};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }
}
