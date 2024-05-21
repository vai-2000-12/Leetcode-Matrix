class Solution {
    public int[][] largestLocal(int[][] grid){
        int n =  grid.length;
        int[][] maxLocal = new int[n-2][n-2];
      
        for( int i =  0 ; i < n-2 ; i++){
            for( int j = 0 ; j < n-2 ; j++){
              maxLocal[i][j] = findMax(grid, i , j);
            }
        }
        return maxLocal;
    }

    public int findMax(int[][]grid, int i , int j){
      int maxElem = 0;

      for(int k = i ; k < i+3 ; k++){
        for(int l = j ;  l < j+3 ; l++){
           maxElem = Math.max(maxElem ,  grid[k][l]);         
        }
      }
        return maxElem;
    }
}