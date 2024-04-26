import java.util.*;

class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (boolean[] c : visited) {
            Arrays.fill(c, false);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && containsCycle(i, j, visited, grid, i, j, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(int i, int j, boolean[][] visited, char[][] grid, int pr, int pc, int prevI, int prevJ) {
        // Boundary Condition:-
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != grid[pr][pc]) {
            return false;
        }

        if (visited[i][j]) {
            return true;
        }

        visited[i][j] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if ((ni != prevI || nj != prevJ) && containsCycle(ni, nj, visited, grid, i, j, i, j)) {
                return true;
            }
        }

        return false;
    }
}
