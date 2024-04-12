class Solution {
    public int maxAreaOfIsland(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       int max = 0;   
       for(int i = 0 ; i < m ; i++){
        for( int j = 0 ; j < n ; j++){
            if(grid[i][j] == 1){
                max = Math.max(max, DFSRec(grid, i , j , m , n));
            }
         }
       } 
         return max;
    }

    public int DFSRec(int[][]grid, int i , int j , int m, int n){
        int t = 0;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
       
       return 1 + DFSRec(grid , i+1, j , m ,n) + DFSRec(grid, i-1, j , m ,n)+DFSRec(grid, i, j+1 , m ,n) + DFSRec(grid, i, j-1 , m ,n);
 
    }
}