class Solution {
    public int findMaxFish(int[][] grid) {
        // Find the Length..
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;

        for(int i = 0 ; i < m ; i++){
            for( int j = 0 ; j< n ; j++){
                // I recursively call for the DFS Method
                if(grid[i][j] != 0){
                  sum = Math.max(sum, DFS(grid , i, j));  
                }
            }
        }
            return sum;
    }
    public int DFS(int[][] grid , int r, int c){
        int m = grid.length;
        int n = grid[0].length;
      // Boundary Condition :
        if( r < 0 || c <0 || r >=m || c >=n || grid[r][c]== 0){
            return 0;
        }
         
       int val = grid[r][c];
       grid[r][c] = 0;
     
       return val + DFS(grid, r+1, c) + DFS(grid, r-1, c) + DFS(grid, r, c+1) + DFS(grid, r, c-1);
       
    }
}