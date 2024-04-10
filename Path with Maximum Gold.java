class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, DFSForMaxGold(grid, m, n, i, j, new boolean[m][n]));
            }
        }
        return max;
    }

    public int DFSForMaxGold(int[][] grid, int m, int n, int i, int j, boolean[][] visited){
        
        int ans = 0;
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) {
            return ans;
        }

        visited[i][j] = true;

        int left = DFSForMaxGold(grid, m, n, i, j - 1, visited);
        int right = DFSForMaxGold(grid, m, n, i, j + 1, visited);
        int up = DFSForMaxGold(grid, m, n, i - 1, j, visited);
        int down = DFSForMaxGold(grid, m, n, i + 1, j, visited);

        ans = grid[i][j] + Math.max(Math.max(left, right), Math.max(up, down));
        visited[i][j] = false;

        return ans;
    }
}
