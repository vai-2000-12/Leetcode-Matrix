import java.util.*;

class Solution {
    private final int[] DirX = { 1, -1, 0, 0};
    private final int[] DirY = {0, 0, 1, -1};

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int distance = 0;
     

        Deque<int[]> q = new ArrayDeque<>();
        FirstIsland(grid, q);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int d = 0; d < 4; d++) {
                    int newX = curr[0] + DirX[d];
                    int newY = curr[1] + DirY[d];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (grid[newX][newY] == 1) {
                            return distance;
                        }

                        if (grid[newX][newY] == 0) {
                            q.add(new int[]{newX, newY});
                            grid[newX][newY] = -1;
                        }
                    }
                }
            }
            distance++;
        }
        return distance;
    }

    private void FirstIsland(int[][] grid, Deque<int[]> q) {
        int m = grid.length;
        int n = grid[0].length;
          
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, m, n, q);
                    return;
                }
            }
        }
    }

    private void dfs(int[][] grid, int x, int y, int m, int n, Deque<int[]> q) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) {
            return;
        }

        grid[x][y] = -1;
        q.add(new int[]{x, y});

        dfs(grid , x+1 , y , m , n , q);          
        dfs(grid , x , y+1 , m , n , q);          
        dfs(grid , x-1 , y , m , n , q);          
        dfs(grid , x , y-1 , m , n , q);          

    }
}
