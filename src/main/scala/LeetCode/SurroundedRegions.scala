package LeetCode

/*
130. Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
object SurroundedRegions {
  def solve(board: Array[Array[Char]]): Unit = {
    val w = board.length
    if (w==0) return
    val l = board(0).length
    if (l==0) return
    if (w<2||l<2) return

    (0 until w) foreach { i=>
      if (board(i)(0)=='O') boundaryDFS(i,0)
      if (board(i)(l-1)=='O') boundaryDFS(i,l-1)
    }
    //Start from first and last row, turn '0' to '*'
    (0 until l) foreach { j=>
      if (board(0)(j)=='O') boundaryDFS(0,j)
      if (board(w-1)(j)=='O') boundaryDFS(w-1,j)
    }
    //Start from first and last column, turn '0' to '*'
    (0 until w) foreach { i=>
      (0 until l) foreach { j=>
        if (board(i)(j)=='O') board(i)(j)='X'
        else if (board(i)(j)=='*') board(i)(j)='O'
      }
    }
    /*
    private void dfs(char[][] board, int x, int y) {
        // mark current index as visited
        board[x][y] = '1';
        // common trick: use of directional vectors for up, down, left, right
        int[] directX = {-1, 1, 0, 0};
        int[] directY = {0, 0, -1, 1};
        for (int i = 0; i < directX.length; i++) {
            if (isValid(board, x + directX[i], y + directY[i])) {
                dfs(board, x + directX[i], y + directY[i]);
            }
        }
    }
    */
    def boundaryDFS(i: Int, j: Int): Unit = {
      if (i<0 || i>=w || j<0 || j>=l) return
      if (board(i)(j)=='O') board(i)(j)='*'
      if (i>1&&board(i-1)(j)=='O') boundaryDFS(i-1,j)
      if (i<w-2&&board(i+1)(j)=='O') boundaryDFS(i+1,j)
      if (j>1&&board(i)(j-1)=='O') boundaryDFS(i,j-1)
      if (j<l-2&&board(i)(j+1)=='O') boundaryDFS(i,j+1)
    }
  }
}
