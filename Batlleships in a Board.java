class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int count = 0;

        for( int i =0 ; i < m ; i++){
            for( int j = 0 ; j < n ; j++){
                if(board[i][j] == 'X'){
                    count++;
                    DFS(i , j , board);
                }
            }
        }
        return count;
    }
    public void DFS(int i , int j , char[][]board){
      // Boundary Condition:
       int m = board.length;
       int n = board[0].length;

       if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '.'){
         return;
       }
        board[i][j] = '.';

        DFS(i+1 , j , board);
        DFS(i-1 , j , board);
        DFS(i , j+1 , board);
        DFS(i , j-1 , board);

    }
}