# Java DSA Repository

A comprehensive collection of Data Structures and Algorithms implementations in Java, organized by topic.

##  Topics Covered

### 🌳 Binary Search Tree
Implementation of various BST operations and problems:

- **`BSTIterator.java`** - Iterator for BST inorder traversal
- **`ConstructBinarySearchTreeFromPreorderTraversal.java`** - Build BST from preorder array
- **`DeleteNodeInBST.java`** - Delete a node from BST
- **`FindCeilInBST.java`** - Find ceiling value in BST
- **`FloorInBST.java`** - Find floor value in BST
- **`InsertIntoBST.java`** - Insert a new node into BST
- **`KthSmallestElementInBST.java`** - Find kth smallest element
- **`LowestCommonAncestor.java`** - Find LCA in BST
- **`RangeSumBST.java`** - Calculate sum of nodes in a given range
- **`RecoverBinarySearchTree.java`** - Recover BST with two swapped nodes
- **`SearchBST.java`** - Search for a value in BST
- **`TwoSumBST.java`** - Find if two elements sum to target
- **`ValidateBinarySearchTree.java`** - Validate if tree is a valid BST

### 🌲 Binary Tree
General binary tree problems and traversals:

- **`amountOfTime.java`** - Time to infect entire tree
- **`BalancedBinaryTree.java`** - Check if tree is height-balanced
- **`BottomViewOfBinaryTree.java`** - Bottom view traversal
- **`BoundaryTraversalOfBinaryTree.java`** - Boundary traversal
- **`TopViewOfBinaryTree.java`** - Top view traversal
- **`DiameterOfBinaryTree.java`** - Find diameter of tree
- **`InorderTraversal.java`** - Inorder traversal (Left-Root-Right)
- **`PreorderTraversal.java`** - Preorder traversal (Root-Left-Right)
- **`PostorderTraversal.java`** - Postorder traversal (Left-Right-Root)
- **`LevelOrderTraversal.java`** - Level order (BFS) traversal
- **`ZigzagLevelOrderTraversal.java`** - Zigzag level order traversal
- **`MaximumDepthOfBinaryTree.java`** - Find maximum depth
- **`MinimumDepthOfBinaryTree.java`** - Find minimum depth
- **`Maxwidth.java`** - Maximum width of binary tree
- **`RightSideView.java`** - Right side view of tree
- **`SameTree.java`** - Check if two trees are identical
- **`SymmetricTree.java`** - Check if tree is symmetric
- **`LowestCommonAncestorBinaryTree.java`** - Find LCA in binary tree
- **`FindBottomLeftTreeValue.java`** - Find bottom-left node
- **`SerializeAndDeserializeBinaryTree.java`** - Serialize/deserialize tree
- **Tree Construction:**
  - `ConstructBinaryTreeFromPreorderAndInorderTraversal.java`
  - `ConstructBinaryTreeFromInorderAndPostorderTraversal.java`
  - `ConstructBinaryTreeFromPreorderAndPostorderTraversal.java`

### 📊 Heap
Heap data structure and priority queue problems:

- **`Heap.java`** - Complete heap implementation (insert, delete, heapify, heap sort)
- **`KthLargestElement.java`** - Find kth largest element using min heap
- **`KthSmallestElementInArray.java`** - Find kth smallest element using max heap
- **`KthLargestSubarraySum.java`** - Find kth largest subarray sum
- **`MergeKSortedLists.java`** - Merge k sorted linked lists (2 approaches)
- **`CheckBinaryHeap.java`** - Verify if tree is a valid max heap
- **`KSortedArrayCheck.java`** - Check if array is k-sorted

### 🔄 Recursion & Backtracking
Classic recursion and backtracking problems:

- **`LetterCombinations.java`** - Phone number letter combinations
- **`Subsets.java`** - Generate all subsets
- **`SubsetsII.java`** - Generate subsets with duplicates
- **`PermutationsII.java`** - Generate unique permutations
- **`CombinationSum.java`** - Find combinations that sum to target
- **`CombinationSumII.java`** - Combination sum with each element used once
- **`PalindromePartitioning.java`** - Partition string into palindromes
- **`NQueens.java`** - N-Queens problem (all solutions)
- **`TotalNQueens.java`** - Count total N-Queens solutions
- **`SudokuSolver.java`** - Solve Sudoku puzzle

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (VS Code, IntelliJ IDEA, Eclipse) or command line

### Running the Code

Each file contains a `main` method for testing. To run any file:

**Using Command Line:**
```bash
# Navigate to the folder
cd "Binary Search Tree"

# Compile
javac SearchBST.java

# Run
java SearchBST
```

**Using VS Code:**
1. Open the file
2. Click the "Run" button or press `F5`
3. View output in the integrated terminal

## 💡 Key Concepts

### Time & Space Complexity
Each implementation includes comments about time and space complexity where applicable.

### Common Patterns
- **Tree Traversal**: Inorder, Preorder, Postorder, Level Order
- **Two Pointers**: Used in BST problems like Two Sum
- **Heap Operations**: Insert O(log n), Delete O(log n), Heapify O(n)
- **Backtracking**: Explore all possibilities with pruning

## 📖 Learning Path

**Recommended Order:**
1. Start with **Binary Tree** traversals
2. Move to **Binary Search Tree** operations
3. Learn **Heap** data structure
4. Practice **Recursion & Backtracking** problems

## 🤝 Contributing

Feel free to:
- Add more problems
- Optimize existing solutions
- Add comments and explanations
- Report bugs or issues

## 📝 Notes

- All code is tested and runnable in VS Code
- Each file is self-contained with test cases
- Solutions follow standard Java naming conventions
- Comments explain the logic and approach

## 📄 License

This repository is for educational purposes.

---

**Happy Coding! 🎯**
