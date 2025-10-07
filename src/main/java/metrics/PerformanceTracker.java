package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons + ", Swaps: " + swaps;
    }
}
