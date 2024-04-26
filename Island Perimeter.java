class Solution {
    public int islandPerimeter(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;

       if(grid == null) return 0;
       
       for(int i =0 ; i < m ; i++){
          for( int j = 0 ; j < n ; j++){
            if(grid[i][j] == 1){
                return DFSToGetPerimeter(i,j, grid);
            }
          }
       }
       return 0;
    }
    public int DFSToGetPerimeter(int i , int j , int[][]grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        if(i < 0 || j < 0 || i >=m ||j >=n|| grid[i][j] == 0){ return 1;}
        if (grid[i][j] == -1) return 0;
        grid[i][j] = -1;

        count+=DFSToGetPerimeter(i+1, j, grid);
        count+=DFSToGetPerimeter(i-1, j, grid);
        count+=DFSToGetPerimeter(i, j+1, grid);
        count+=DFSToGetPerimeter(i, j-1, grid);

        return count;
    }
}