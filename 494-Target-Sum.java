/* Do DFS and try both + and - at every step */

public class Solution {
    int result = 0;
	
    public int findTargetSumWays(int[] nums, int S) {
     
        if (nums == null || nums.length == 0) 
            return result;
        
        helper(nums, S, 0, 0);
        return result;
    }
    
    public void helper(int[] nums, int target, int pos, long eval){
          // System.out.println("Pos : " + pos + "\t" + "Eval : " + eval);
        if (pos == nums.length) {
             
            if (target == eval) 
                result++;
            return;
        }
        helper(nums, target, pos + 1, eval + nums[pos]);
         
        helper(nums, target, pos + 1, eval - nums[pos]);
    }
}
