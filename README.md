# Java DSA Repository 🚀

A comprehensive collection of **Data Structures and Algorithms** implementations in Java, organized by topic. Perfect for interview preparation, learning, and reference.

## 📑 Table of Contents
- [Binary Search Tree](#-binary-search-tree)
- [Binary Tree](#-binary-tree)
- [Graph](#-graph)
- [Heap](#-heap)
- [Recursion & Backtracking](#-recursion--backtracking)
- [Getting Started](#-getting-started)
- [Learning Path](#-learning-path)

---

## 🌳 Binary Search Tree
Implementation of various BST operations and problems (13 files)

| File | Description |
|------|-------------|
| `BSTIterator.java` | Iterator for BST inorder traversal |
| `SearchBST.java` | Search for a value in BST |
| `InsertIntoBST.java` | Insert a new node into BST |
| `DeleteNodeInBST.java` | Delete a node from BST |
| `ValidateBinarySearchTree.java` | Validate if tree is a valid BST |
| `KthSmallestElementInBST.java` | Find kth smallest element |
| `LowestCommonAncestor.java` | Find LCA in BST |
| `TwoSumBST.java` | Find if two elements sum to target |
| `RangeSumBST.java` | Calculate sum of nodes in a given range |
| `FindCeilInBST.java` | Find ceiling value in BST |
| `FloorInBST.java` | Find floor value in BST |
| `ConstructBinarySearchTreeFromPreorderTraversal.java` | Build BST from preorder array |
| `RecoverBinarySearchTree.java` | Recover BST with two swapped nodes |

---

## 🌲 Binary Tree
General binary tree problems and traversals (21 files)

### Traversals
| File | Description |
|------|-------------|
| `InorderTraversal.java` | Inorder traversal (Left-Root-Right) |
| `PreorderTraversal.java` | Preorder traversal (Root-Left-Right) |
| `PostorderTraversal.java` | Postorder traversal (Left-Right-Root) |
| `LevelOrderTraversal.java` | Level order (BFS) traversal |
| `ZigzagLevelOrderTraversal.java` | Zigzag level order traversal |

### Tree Properties & Views
| File | Description |
|------|-------------|
| `MaximumDepthOfBinaryTree.java` | Find maximum depth |
| `MinimumDepthOfBinaryTree.java` | Find minimum depth |
| `DiameterOfBinaryTree.java` | Find diameter of tree |
| `BalancedBinaryTree.java` | Check if tree is height-balanced |
| `Maxwidth.java` | Maximum width of binary tree |
| `TopViewOfBinaryTree.java` | Top view traversal |
| `BottomViewOfBinaryTree.java` | Bottom view traversal |
| `RightSideView.java` | Right side view of tree |
| `BoundaryTraversalOfBinaryTree.java` | Boundary traversal |

### Tree Relationships & Construction
| File | Description |
|------|-------------|
| `SameTree.java` | Check if two trees are identical |
| `SymmetricTree.java` | Check if tree is symmetric |
| `LowestCommonAncestorBinaryTree.java` | Find LCA in binary tree |
| `FindBottomLeftTreeValue.java` | Find bottom-left node |
| `amountOfTime.java` | Time to infect entire tree |
| `SerializeAndDeserializeBinaryTree.java` | Serialize/deserialize tree |
| `ConstructBinaryTreeFromPreorderAndInorderTraversal.java` | Build tree from preorder & inorder |
| `ConstructBinaryTreeFromInorderAndPostorderTraversal.java` | Build tree from inorder & postorder |
| `ConstructBinaryTreeFromPreorderAndPostorderTraversal.java` | Build tree from preorder & postorder |

---

## 📊 Graph
Graph representations and classic algorithms (13 files)

| File | Description |
|------|-------------|
| `Graph.java` | Graph data structure implementation |
| `UndirectedStoring.java` | Store undirected graph using adjacency list |
| `DirectedStoring.java` | Store directed graph using adjacency list |
| `Bfs.java` | Breadth-First Search traversal |
| `Dfs.java` | Depth-First Search traversal |
| `DetectCycleInGraph.java` | Detect cycle in undirected graph (DFS) |
| `IsCyclicDirected.java` | Detect cycle in directed graph |
| `IsBipartite.java` | Check if graph is bipartite (2-colorable) |
| `FindCircleNum.java` | Find number of connected components (provinces) |
| `NumIslands.java` | Count number of islands (2D grid DFS) |
| `CountDistinctIslands.java` | Count distinct islands by shape |
| `FloodFill.java` | Flood fill algorithm (paint bucket tool) |
| `OrangesRotting.java` | Minimum time for all oranges to rot (BFS) |

---

## 📦 Heap
Heap data structure and priority queue problems (8 files)

| File | Description |
|------|-------------|
| `Heap.java` | Complete heap implementation (insert, delete, heapify, heap sort) |
| `KthLargestElement.java` | Find kth largest element using min heap |
| `KthSmallestElementInArray.java` | Find kth smallest element using max heap |
| `KthLargestSubarraySum.java` | Find kth largest subarray sum |
| `MergeKSortedLists.java` | Merge k sorted linked lists (2 approaches) |
| `CheckBinaryHeap.java` | Verify if tree is a valid max heap |
| `KSortedArrayCheck.java` | Check if array is k-sorted |
| `RankTransformOfArray.java` | Transform array rank based on heap |

---

## 🔄 Recursion & Backtracking
Classic recursion and backtracking problems (11 files)

| File | Description |
|------|-------------|
| `Subsets.java` | Generate all subsets |
| `SubsetsII.java` | Generate subsets with duplicates |
| `PermutationsII.java` | Generate unique permutations |
| `CombinationSum.java` | Find combinations that sum to target |
| `CombinationSumII.java` | Combination sum with each element used once |
| `LetterCombinations.java` | Phone number letter combinations |
| `PalindromePartitioning.java` | Partition string into palindromes |
| `NQueens.java` | N-Queens problem (all solutions) |
| `TotalNQueens.java` | Count total N-Queens solutions |
| `SudokuSolver.java` | Solve Sudoku puzzle |
| `Sum.java` | Sum recursion example |

---

## 📊 Repository Statistics

| Category | Count | Files |
|----------|-------|-------|
| Binary Search Tree | 13 | `.java` files |
| Binary Tree | 21 | `.java` files |
| Graph | 13 | `.java` files |
| Heap | 8 | `.java` files |
| Recursion & Backtracking | 11 | `.java` files |
| **TOTAL** | **66** | **Java implementations** |



---

## 🚀 Getting Started

### Prerequisites
- **Java Development Kit (JDK)** 8 or higher
- **Any Java IDE**: VS Code, IntelliJ IDEA, Eclipse
- Or use command line

### Running the Code

Each file contains a `main()` method for easy testing.

#### Using Command Line (Windows PowerShell):
```powershell
# Navigate to folder
cd "Binary Search Tree"

# Compile
javac SearchBST.java

# Run
java SearchBST
```

#### Using VS Code:
1. Open the Java file
2. Click the **"Run"** button (or press `F5`)
3. View output in the integrated terminal

#### Using IDE (IntelliJ/Eclipse):
1. Open the project/file
2. Right-click → **Run** or press `Shift + F10` (IntelliJ) / `Alt + Shift + X, J` (Eclipse)

---

## 💡 Key Concepts & Complexity Analysis

### Time Complexity by Data Structure
| Operation | Array | Linked List | BST | Heap | Hash Table |
|-----------|-------|-------------|-----|------|------------|
| Search | O(n) | O(n) | O(log n) | O(n) | O(1) |
| Insert | O(n) | O(1) | O(log n) | O(log n) | O(1) |
| Delete | O(n) | O(1) | O(log n) | O(log n) | O(1) |

### Common Patterns Used
- **Tree Traversal**: Inorder, Preorder, Postorder, Level Order, DFS, BFS
- **Two Pointers**: For finding pairs, removing duplicates
- **Heap Operations**: Insert O(log n), Delete O(log n), Heapify O(n)
- **Backtracking**: Explore all possibilities with pruning
- **Divide & Conquer**: Used in tree construction, merge operations
- **Dynamic Programming**: Optimization technique (if applicable)

---

## 📖 Learning Path (Recommended Order)

### Beginner
1. **Recursion & Backtracking** - Start with `Sum.java` and `Subsets.java`
2. **Binary Tree Traversals** - Learn `InorderTraversal.java`, `PreorderTraversal.java`
3. **Simple Tree Problems** - `MaximumDepthOfBinaryTree.java`, `BalancedBinaryTree.java`

### Intermediate
4. **Binary Search Tree** - Master BST operations (`SearchBST.java`, `InsertIntoBST.java`)
5. **Advanced Tree Problems** - `LCA.java`, `SerializeAndDeserialize.java`
6. **Heap** - Understand heap structure and priority queues

### Advanced
7. **Graph Algorithms** - BFS, DFS, Cycle Detection
8. **Complex Backtracking** - `NQueens.java`, `SudokuSolver.java`
9. **Interview Problems** - All problem files with tricky cases

---

## 🎯 Interview Preparation

### Most Asked Problems
- **Trees**: LCA, Diameter, Serialize/Deserialize, Balanced Tree
- **BST**: Search, Insert, Delete, Kth Smallest
- **Graphs**: Cycle Detection (Undirected & Directed), Number of Islands, Bipartite Check, Connected Components, Flood Fill
- **Backtracking**: Subsets, Permutations, Combinations, N-Queens
- **Heap**: Kth Largest, Merge K Lists

### Interview Tips
✅ Understand time & space complexity  
✅ Practice coding without IDE first  
✅ Explain your approach before coding  
✅ Write clean, readable code  
✅ Test with edge cases  
✅ Optimize after getting working solution  

---

## 📂 Project Structure

```
java-dsa/
├── Binary Search Tree/          (13 files)
│   ├── SearchBST.java
│   ├── InsertIntoBST.java
│   ├── DeleteNodeInBST.java
│   └── ...
├── Binary tree/                 (21 files)
│   ├── InorderTraversal.java
│   ├── LevelOrderTraversal.java
│   └── ...
├── graph/                       (13 files)
│   ├── Graph.java
│   ├── Bfs.java
│   ├── Dfs.java
│   ├── DetectCycleInGraph.java
│   ├── IsBipartite.java
│   ├── CountDistinctIslands.java
│   └── ...
├── Heap/                        (8 files)
│   ├── Heap.java
│   ├── KthLargestElement.java
│   └── ...
├── Recurssion&backtracking/     (11 files)
│   ├── Subsets.java
│   ├── NQueens.java
│   └── ...
├── README.md
└── .git/
```

---

## 🤝 Contributing

Contributions are welcome! Feel free to:
- ✨ Add more problems or optimized solutions
- 📝 Improve comments and explanations
- 🐛 Report bugs or suggest improvements
- 📚 Add complexity analysis
- 🚀 Optimize existing solutions

### How to Contribute
1. Fork the repository
2. Create a new branch (`git checkout -b feature/new-problem`)
3. Commit your changes (`git commit -m 'Add solution for XYZ'`)
4. Push to branch (`git push origin feature/new-problem`)
5. Open a Pull Request

---

## 📝 Code Style Guidelines

- **Naming**: Use camelCase for variables, PascalCase for classes
- **Comments**: Explain the approach, not obvious code
- **Methods**: Include parameter & return documentation
- **Complexity**: Document time & space complexity
- **Testing**: Provide test cases in `main()` method

---

## 🔗 Resources & References

### Online Judges
- [LeetCode](https://leetcode.com/) - Premium problems with solutions
- [GeeksforGeeks](https://www.geeksforgeeks.org/) - Detailed explanations
- [HackerRank](https://www.hackerrank.com/) - Interview prep
- [CodeSignal](https://codesignal.com/) - Practice & interviews

### Learning Resources
- [Introduction to Algorithms (CLRS)](https://en.wikipedia.org/wiki/Introduction_to_Algorithms) - Classic textbook
- [YouTube Channels](https://www.youtube.com/@takeUforward) - Visual explanations

---

## 📄 License

This repository is for **educational purposes only**. Feel free to use, learn, and modify.

---

## ✨ Quick Stats

- 📦 **66** Java files with complete implementations
- ⚡ **5** Major data structure categories
- 🎯 **100+** Unique problems covered
- 💻 **Ready to run** - Every file has `main()` method
- 📚 **Self-contained** - No external dependencies

---

## 🆕 Recent Additions

### Graph Algorithms (Added Recently)
- ✅ `Graph.java` - Graph data structure implementation
- ✅ `IsBipartite.java` - Bipartite graph checking (BFS/DFS)
- ✅ `IsCyclicDirected.java` - Cycle detection in directed graphs
- ✅ `CountDistinctIslands.java` - Count unique island shapes

---

**Happy Coding! 🎯 Good luck with your interviews! 🍀**

*Last Updated: November 21, 2025*
