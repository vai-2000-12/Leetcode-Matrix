class Solution 
{
    public int countSubIslands(int[][] grid1, int[][] grid2)
    {
        // O(n*m) time where n is grid1.length and m is grid2.length
        // O(n*m) space 
        int count = 0;
        
        for(int i = 0; i < grid2.length; i++)
        {
            for(int j = 0; j < grid2[0].length; j++)
            {
                if(grid2[i][j] == 1 && DFS(grid1, grid2, i, j))
                    count += 1;
            }
        }
        return count;
    }
    
    private boolean DFS(int[][] grid1, int[][] grid2, int i, int j)
    {
        if(i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0)
            return true;
        
        boolean flag = grid1[i][j] == 1;
        
        
        grid2[i][j] = 0;
        
        boolean up = DFS(grid1, grid2, i-1, j);
        boolean down = DFS(grid1, grid2, i+1, j);
        boolean left = DFS(grid1, grid2, i, j-1);
        boolean right = DFS(grid1, grid2, i, j+1);
        
        return (flag && up && down && left && right);
    }
}