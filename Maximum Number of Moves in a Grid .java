// QUES- 2684
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxStep = 0;
        for(int i = 0 ; i < m ;i++){
            maxStep = Math.max(maxStep, DFS(i, 0, grid));
        }
        return maxStep;
    }
   public int DFS(int r, int c, int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    
    // Boundary Condition:
    if (r < 0 || c < 0 || r >= m || c >= n) {
        return 0;
    }
    
      if (c + 1 < n && grid[r][c + 1] > grid[r][c]){
        int a = 1 + DFS(r - 1, c + 1, grid); //Up-Right
        int b = 1 + DFS(r, c + 1, grid);     //Right
        int d = 1 + DFS(r + 1, c + 1, grid); //Down-Right

        count = Math.max(count, Math.max(a, Math.max(b, d)));
    }
    return count;
     }
}
