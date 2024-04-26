class Solution {
    public void solve(char[][] board) {
        int R = board.length;
        if (R <= 2 || board[0].length <= 2) return; // Boundary Condition
        
        int C = board[0].length;

        // Traverse first and last column
        for (int i = 0; i < R; i++) {
            if (board[i][0] == 'O') DFS(i, 0, board);
            if (board[i][C - 1] == 'O') DFS(i, C - 1, board);
        }

        // Traverse first and last row
        for (int j = 0; j < C; j++) {
            if (board[0][j] == 'O') DFS(0, j, board);
            if (board[R - 1][j] == 'O') DFS(R - 1, j, board);
        }

        // Flip 'O' to 'X' and 'A' to 'O'
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    public void DFS(int i, int j, char[][] board) {
        int R = board.length;
        int C = board[0].length;
        
        // Boundary Condition
        if (i < 0 || j < 0 || i >= R || j >= C || board[i][j] != 'O') return;

        // Mark current cell as 'A'
        board[i][j] = 'A';

        // DFS in all four directions
        DFS(i + 1, j, board);
        DFS(i - 1, j, board);
        DFS(i, j + 1, board);
        DFS(i, j - 1, board);
    }
}