// Time Limit Exceeded :-

class Solution {
    int mod = 1000000007;
    long ans = -1;
    public int maxProductPath(int[][] grid){

        solve(grid, 0  , 0 , 1);
        return(int)(ans % mod);
        
    }
    public void solve(int[][] grid , int i , int j , long product){
        int m = grid.length;
        int n = grid[0].length;

        if(i == m || j == n){
            return;
        }

        //Edge Case 1 :-
        if(i == m-1 && j == n-1){
          ans = Math.max(ans , product * grid[i][j]);
          return;   
        }

        // Edge Case 2:-
        if(grid[i][j] == 0){
             ans = Math.max(ans , 0);   
        }

       // recursive Call :- 
       solve(grid, i , j+1 , product * grid[i][j]);
       solve(grid, i+1 , j , product * grid[i][j]);

    }
}