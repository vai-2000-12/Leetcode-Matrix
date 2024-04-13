import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, ArrayList<Integer>>map = new HashMap<Integer, ArrayList<Integer>>();

        for(int i =0 ; i < m ; i++){
            for( int j = 0 ; j < n; j++){
              if(!map.containsKey(i-j)){
                  map.put(i-j, new ArrayList<Integer>());
              } 
                ArrayList<Integer> ls = map.get(i-j);
                 ls.add(mat[i][j]);
                 map.put((i-j), ls);
            }
        }

        for( int i =0 ; i < m ; i++){
            for( int j = 0 ; j< n ; j++){
                ArrayList<Integer> res = map.get(i-j);
                 Collections.sort(res);
                 mat[i][j] = res.remove(0);
                 map.put((i-j), res);
            }
        }
        return mat;
    }
}