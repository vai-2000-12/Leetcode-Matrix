class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        for( int i = 0 ; i < grid.length; i++){
            for( int j = 0 ; j < grid[0].length; j++){
            if (j < grid[0].length - 1  && grid[i][j] == grid[i][j + 1]) {
                    return false;
             }
            if (i < grid.length - 1 && grid[i][j] != grid[i + 1][j]) {
                    return false;
            }
        }
    }     
        return true;
    }
}