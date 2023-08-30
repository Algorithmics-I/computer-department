# Computer Department

Audie was hired at the computer department in her college, and her first task is to free up space
on each one of the computers. Her first approach was to sort the files and look for the ones
with similar names; however, she notices that sometimes two files can have quite different
names but have the same content. She realizes that reviewing file by file will be too much to
handle, so she thought of a great application idea. However, Audie is a freshman, and that is
why you should help her to write a program where:

- The user can specify the folder that will be scanned.

- The user should be able to filter the files: Should be possible to include or exclude certain
file types.

- It should be possible to identify the files that may be duplicated.

- The user should be able to get:

  - How many files were scanned, how many files are unique, and how many files are
  potentially duplicated.
  
  - List of all the duplicated files.

## Instructions

- You should work with at least 2 types of files. 

- In the problem says to find "potentially duplicated" files. However, you are free to find
files that are 100% duplicates. In the case, that you opt to find "potentially duplicated"
files, you must explain the case in which a file can be marked as a duplicate even though
it is not.

- Get the worst-case analysis of your implementation.

- Make an analysis of the data structures that you are using.

- Your code must be readable and do not include code that is not used. 

- Include unit tests 

- Be mindful when choosing which data structure, algorithm, or library.

## Deliverable

- Java code that solves the problem.

- Document or readme of the analysis.

## Analysis
  The implementation's objective is to find and list duplicate files in a given directory, based
  on generating MD5 hashes for file comparison. Below is a worst-case analysis and an evaluation
  of the data structures used:
# Worst-Case Analysis:

  Scenario: Consider a directory with a large number of files and subdirectories, with most of the 
  files being identical.
  In this case, the worst situation would be that all files are duplicates.
  The algorithm would have to iterate through all files and generate their MD5 hashes, resulting 
  in a considerable runtime as generating MD5 hashes is a computationally expensive operation.
# Used Data Structures:
  Map<String, List<String>> fileMap: This map stores an MD5 hash as the key and a list of file paths
  as the value. It's used to track duplicate files. If the same hash is encountered in the map, it
  means at least two files have the same content.
  Set<String> uniqueFiles: This set stores unique file paths, i.e., files with no duplicates.
  It's used to count the number of unique files.
  Set<String> duplicatedFiles: This set stores paths of duplicate files. If a file has the same hash
  as another, both are added to this set.
# Time complexity 
  the worst case is O(n * m)
  n = N files
  m = average size in bytes
# Data Structures Evaluation:

  Map<String, List<String>> fileMap:

  Pros: Allows for fast search for duplicates based on MD5 hash. Efficient for grouping duplicate files by content.
  Cons: Can consume more memory, especially in situations where there are many unique files with different contents.
  Set<String> uniqueFiles:

  Pros: Efficient for maintaining a list of unique files. Quick lookup and duplicate verification.
  Cons: Doesn't store information about actual duplicates, only paths of unique files.
  Set<String> duplicatedFiles:

  Pros: Efficient for storing paths of duplicate files. Facilitates enumeration and result presentation.
  Cons: Similar to uniqueFiles, doesn't store information about the relationship between duplicates.
