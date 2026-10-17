# Two-Dimensional Arrays: a complete guide

A two-dimensional array represents data arranged by rows and columns, such as a grid, board, image, or table. The Java examples use `int[][]`, but the same reasoning applies to `char[][]` and other element types.

## 1. What `int[][]` means in Java

Java's `int[][]` is an array whose elements are references to row arrays. It is often pictured as a rectangle, but the rows can have different lengths:

```java
int[][] grid = {
    {1, 2, 3},
    {4, 5, 6}
};
```

Here `grid.length` is the number of rows (`2`), and `grid[0].length` is the number of columns in row `0` (`3`). Access a cell with `grid[row][column]`.

```text
       column 0  1  2
row 0       1   2  3
row 1       4   5  6
```

Do not assume every row has the same length unless the input guarantees a rectangular matrix.

## 2. Creating and initializing grids

```java
int[][] rectangular = new int[3][4]; // 3 rows, 4 columns, initialized to 0
char[][] board = new char[9][9];
int[][] jagged = new int[3][];       // row arrays not created yet
jagged[0] = new int[2];
jagged[1] = new int[5];
jagged[2] = new int[1];
```

Use `matrix.length` for rows. For a nonempty rectangular matrix, use `matrix[0].length` for columns. For potentially jagged rows, use `matrix[row].length` inside the row loop. Validate null/empty rows only when the method contract allows them.

## 3. Traversing a matrix

Row-major traversal visits each row from left to right, then moves to the next row:

```java
for (int r = 0; r < matrix.length; r++) {
    for (int c = 0; c < matrix[r].length; c++) {
        System.out.println(matrix[r][c]);
    }
}
```

This is `O(RC)` for a rectangular `R × C` matrix. Keep row and column roles consistent: first index is row, second is column. A common error is using `matrix.length` as the column bound, which only works for square matrices.

## 4. Neighbor coordinates and bounds

For four-direction movement, use row/column offsets:

```java
int[] dr = {-1, 1, 0, 0};
int[] dc = {0, 0, -1, 1};

for (int k = 0; k < 4; k++) {
    int nr = r + dr[k];
    int nc = c + dc[k];
    if (nr >= 0 && nr < matrix.length
            && nc >= 0 && nc < matrix[nr].length) {
        // (nr, nc) is a valid neighbor
    }
}
```

For eight-direction movement, include the four diagonal offset pairs. The bounds check must happen before indexing. On a jagged array, checking the candidate row's length is important.

## 5. Common matrix operations

### Sum rows, columns, and all cells

For rectangular matrix `m`, the row sum for row `r` is accumulated over columns. A column sum fixes `c` and iterates through rows. Total sum visits all cells once. Use `long` when totals can exceed `int`.

### Transpose

The transpose swaps rows and columns: `transpose[c][r] = matrix[r][c]`. An `R × C` input becomes a `C × R` output.

For a square matrix, transpose in place by swapping only pairs above the main diagonal:

```java
for (int r = 0; r < n; r++) {
    for (int c = r + 1; c < n; c++) {
        int temp = matrix[r][c];
        matrix[r][c] = matrix[c][r];
        matrix[c][r] = temp;
    }
}
```

If all pairs are swapped, each pair is swapped twice and the matrix returns to its original state.

### Rotate a square matrix 90 degrees clockwise

One in-place method is transpose, then reverse each row. The method requires a square matrix. For rectangular matrices, produce a new matrix with swapped dimensions and map each cell carefully.

### Diagonals

In a square matrix, the main diagonal has `r == c`; the opposite diagonal has `r + c == n - 1`. In non-square matrices, state precisely which diagonal or shape is intended.

## 6. Searching matrices

The search method depends on the ordering guarantee.

- **Unsorted matrix:** inspect all cells, `O(RC)`.
- **Each row sorted independently:** binary search each row, `O(R log C)`.
- **Rows and columns both sorted:** start at top-right. If the current value is too large, move left; if too small, move down. Each move removes a row or column, giving `O(R + C)`.
- **One globally sorted row-major sequence:** binary search indices `[0, R*C)`, mapping index `mid` to `row = mid / C`, `column = mid % C`. Guard the zero-column case and be mindful of multiplication overflow.

Never apply an ordered search without using exactly the ordering property it relies on.

## 7. Prefix sums in two dimensions

A 2D prefix sum supports rectangle sum queries. Define `prefix[r][c]` as the total in the rectangle from the top-left through row `r - 1`, column `c - 1`; use a table one row and one column larger than the input. The recurrence is:

```text
prefix[r + 1][c + 1] = matrix[r][c]
                       + prefix[r][c + 1]
                       + prefix[r + 1][c]
                       - prefix[r][c]
```

For half-open rectangle `[r1, r2) × [c1, c2)`, its sum is:

```text
prefix[r2][c2] - prefix[r1][c2]
- prefix[r2][c1] + prefix[r1][c1]
```

The add-back term corrects for the top-left overlap being subtracted twice. Preprocessing is `O(RC)` and each query is `O(1)`.

## 8. Grid traversal problems: DFS and BFS

Many grid problems are graph problems: each cell is a vertex and neighboring cells are edges. Use DFS for reachability or connected components; use BFS for shortest path when every move has the same cost.

Mark cells visited when enqueuing in BFS, not after removing them, so the same cell is not added repeatedly. You may store coordinates as a small pair object or encode them as an integer. If modifying the input to mark visited, confirm mutation is allowed.

For weighted moves, ordinary BFS may not give the shortest path. Depending on edge costs, use 0-1 BFS or Dijkstra's algorithm.

## 9. Common pitfalls

- Swapping `rows` and `columns` or using a square-only bound on a rectangular matrix.
- Accessing `matrix[0]` when there are zero rows.
- Treating a jagged Java array as rectangular.
- Checking a value before checking its coordinates are in bounds.
- Confusing diagonal movement with four-direction movement.
- Forgetting to mark a cell visited, causing repeated work or recursion loops.
- Marking visited too late in BFS and enqueueing duplicates.
- Applying in-place rotation to a nonsquare matrix.
- Overflow in row-count × column-count or prefix sums.
- Accidentally counting the same cell twice in a path or region.

## 10. A reliable grid workflow

1. Identify row and column counts, and whether rows are rectangular.
2. Write down the coordinate convention and allowed directions.
3. Decide whether the task is a scan, ordered search, path, connected-region, or range-query problem.
4. Define bounds before indexing and decide how visited cells are represented.
5. Choose DFS, BFS, dynamic programming, or prefix sums based on the question.
6. Check tiny dimensions (`1 × 1`, one row, one column), corners, and boundaries.

## 11. Practice progression

Traverse and sum a matrix; transpose; rotate a square matrix; search a sorted matrix; count islands; flood fill; shortest path in an unweighted maze; number of paths; minimum path sum; and rectangle-sum queries. For every problem, draw coordinates and verify the transition at a corner cell.
