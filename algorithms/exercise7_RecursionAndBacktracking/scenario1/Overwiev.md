1. **Tower of Hanoi:**
    
    - The base case is when there is only one disk to move, in which case it is simply moved from the source peg to the target peg.
    - For more than one disk, the problem is solved recursively: first move the top n-1 disks to an auxiliary peg, then move the largest disk to the target peg, and finally move the n-1 disks from the auxiliary peg to the target peg.
2. **Generating Permutations and Combinations:**
    
    - For permutations, the base case is when there is only one puzzle piece left, in which case the permutation is simply the piece itself. For more than one piece, each piece is swapped with each other piece and permutations of the remaining pieces are generated recursively.
    - For combinations, the base case is when no puzzle pieces are left, in which case the combination is an empty set. For more than zero pieces, each piece is selected and combinations of the remaining pieces are generated recursively.
3. **N-Queens Puzzle and Maze Navigation:**
    
    - For the N-Queens puzzle, the base case is when all queens have been placed successfully. If not, queens are placed one by one in different columns, starting from the leftmost column. When placing a queen in a column, clashes with already placed queens are checked. If a clash is found, then the position is skipped and the next one is tried. If no position can be found in the current column, then false is returned.
    - For maze navigation, the base case is when the end of the maze is reached. If not, the algorithm starts from the top-left corner of the maze and moves in all four directions (up, down, left, right) one step at a time. If a path is found, true is returned. If no path is found after moving in all four directions, then the algorithm backtracks and returns false.