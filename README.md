# Graph Search 
### CS431 Artificial Intelligence <br>Homework Assignment 1 <br>February, 2019

Implementation of different search algorithms to solve the 8-puzzle. <br>See *assignment.pdf* for full assignment description. 

I was given starter code and implemented the following sections.
1. In the **search** package:
- The solvePuzzle() method in the GraphSearch class. This method takes in the puzzle and returns a solution in the form of a String that contains directions (U, D, L, R) for solving the puzzle. The directions specify how the "blank tile" should be moved to achieve the goal state.
- There is a second method graphSearch() that you must also implement. It is this method that does the actual searching and, as such, should be called by the solvePuzzle() method.
- The GraphSearch algorithm requires a node data structure. I have provided an interface (Node.java) that your node class must implement. This interface contains all necessary methods for a node (but you are welcome to add additional private methods to your node class as needed).
2. In the **util** packageg:
- A queue that implements the OrderedCollection interface
- A stack that implements the OrderedCollection interface
3. In the **heuristics** package:
- A class (that implements the Heuristic interface) that computes the manhattan distance between the current node's board and the goal.
- A class (that implements the Heuristic interface) that computes the number of misplaced tiles between the current node's board and the goal.
