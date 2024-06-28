import java.util.*;

class Pair {
    int x;
    int y;
    int steps;

    public Pair(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<Pair>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1; 
                }
            }
        }

        int max = 0;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.x;
            int c = curr.y;
            int cnt = curr.steps;

            max = Math.max(max, cnt);

            int[] dr = {1, -1, 0, 0};
            int[] dc = {0, 0, 1, -1};

            // For all the 4 directions:
            for (int k = 0; k < 4; k++) {
                int row = r + dr[k];
                int col = c + dc[k];

                // Boundary Condition:
                if (row >= 0 && row < m && col >= 0 && col < n && visited[row][col] == 0) {
                    q.add(new Pair(row, col, cnt + 1));
                    visited[row][col] = 1;
                }
            }
        }
        return max == 0 ? -1 : max;
    }
}
