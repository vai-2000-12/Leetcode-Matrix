class Solution {
    int ans = 0;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return ans;
    }

    void dfs(char[][] grid, int i, int j, int n, int m) {
        if (!isValid(grid, i, j, n, m))
            return;

        grid[i][j] = '0';

        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
    }

    public boolean isValid(char[][] grid, int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == '1');
    }
}
