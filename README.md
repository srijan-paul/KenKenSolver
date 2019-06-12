# KenKenSolver
A java program that solves kenken boards using Depth First Search and recursive backtracking. 

# How does it work ?
It solves kenken boards after parsing them from a .txt file.
The input must be in the following format :

1. The first line in the file represents the number of rows and colums (e.g - 3) (0 indexed, so 3 will mean 4x4 grid)
2. The subsequent lines will be describing the cages , the operations and the cells belonging to the cage.
3. Note : the cells are in (row, col) format like in a matrix.

The following example demonstrates a sample input :

                    3
                    1 - 0 0 0 1
                    1 - 0 2 1 2
                    4 + 1 0 2 0
                    1 - 1 1 2 1
                    1 # 2 2
                    
The signs carry their conventional meanings and the pound sign means the particular cell is reserved for that number and can only take that
value.

Program parses the data from the file, initializes the board and sets up the constraints. 
Afterwards, proceeds to find a solution to the puzzle,using the depth-first search algorithm.
Prints board if a solution was found.

So far it has been tested on boards upto 9x9 and produces results in less than a second.

example :

File : board4.txt
```6
18 * 0 0 1 0 2 0
60 * 0 1 0 2 0 3
5 + 0 4 0 5
2 / 1 1 2 1
11 + 1 2 1 3 2 3
10 * 1 4 1 5 2 5
8 * 2 2 3 2 3 3
1 - 2 4 3 4
2 - 3 0 3 1
72 * 3 5 4 5 4 4
5 + 4 0 4 1
20 * 4 2 4 3 5 3
30 * 5 0 5 1 5 2
1 - 5 4 5 5
```

Output : 

![Example](https://i.imgur.com/7oCzKF9.jpg)
