import java.util.*;

class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Array Which you want to create : ");
        int size = sc.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> set = subset(nums);
        
        for (List<Integer> result : set) {
            System.out.println(result);
        }
        sc.close();
    }

    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(nums, 0, curr, res);
        return res;
    }

    private static void solve(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        // Add the current subset to the result
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            // Recursively call the solve method
            solve(nums, i + 1, curr, res);
            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
/*
 * Enter the Size of the Array Which you want to create : 
 *   3
 * Enter the elements of the array: 
     1 2 3
    []
    [1]
    [1, 2]
    [1, 2, 3]
    [1, 3]
    [2]
    [2, 3]
    [3] 
  
*/