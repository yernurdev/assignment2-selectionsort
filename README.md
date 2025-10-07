# Assignment 2 – Selection Sort

## 📌 Overview
This project is part of Assignment 2: Algorithmic Analysis and Peer Code Review**.  
It implements the Selection Sort algorithm in Java, enriched with performance tracking, unit testing, and benchmarking.  
The implementation includes an early termination optimization (stopping if the array is already sorted).

---

## 📂 Project Structure
```bash

assignment2-selectionsort/
├── src/
│ ├── main/java/
│ │ ├── algorithms/
│ │ │ └── SelectionSort.java
│ │ ├── metrics/
│ │ │ └── PerformanceTracker.java
│ │ └── cli/
│ │ └── BenchmarkRunner.java
│ └── test/java/
│ └── algorithms/
│ └── SelectionSortTest.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance-plots/
│ └── selectionsort_results.csv
├── README.md
└── pom.xml
```


---

## ⚙️ Features
- **Selection Sort** implementation (O(n²) worst/avg case, O(n) best case).
- **Early termination optimization** for nearly-sorted or sorted data.
- **Performance metrics tracking**:
    - Number of comparisons
    - Number of swaps
    - Execution time (ms)
- **Benchmark CLI** with input generators:
    - Random arrays
    - Sorted arrays
    - Reversed arrays
    - Nearly-sorted arrays
- **Unit tests** for correctness (empty array, single element, sorted, reversed, duplicates).

---

## 🚀 Usage

### Build
```bash
mvn clean install
```

### Run Benchmark
```bash
mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"
```

📈 Complexity Analysis

Time Complexity
Best Case (already sorted): Θ(n)
Average Case: Θ(n²)
Worst Case (reversed): Θ(n²)
Space Complexity: Θ(1), in-place algorithm
Optimization Impact:
With early termination, nearly-sorted and reversed inputs may complete faster than the classical Selection Sort.
This is why some benchmark results show fewer comparisons than the theoretical n²/2 bound.