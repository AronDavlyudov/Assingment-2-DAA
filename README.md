Kadane's Algorithm - Maximum Subarray Sum (with Position Tracking)

This project is part of Assignment 2 for DAA (Design and Analysis of Algorithms) course. It includes a clean, testable, and performance-tracked implementation Kadane's Algorithm using Java and Maven.

Algorithm Description

Kadane's Algorithm efficiently finds the maximum sum subarray in a 1D integer array.

Time Complexity: O(n)\
Space Complexity: O(1)\
Tracks:
  Maximum sum
  Start and end indices of the subarray

Project Structure

assignment2-kadanes-algorithm/\
├── src/\
│ ├── main/\
│ │ ├── java/\
│ │ │ ├── algorithms/ # KadaneAlgorithm.java\
│ │ │ ├── metrics/ # PerformanceTracker.java\
│ │ │ └── cli/ # BenchmarkRunner.java\
│ └── test/\
│ └── java/\
│ └── algorithms/ # KadaneAlgorithmTest.java\
├── README.md\
├── pom.xml

Version: v1.0

Author
Aron Davlyudov
[Grafs of speed](img.png)