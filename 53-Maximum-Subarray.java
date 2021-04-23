public class Solution {
    
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}
}

/*
class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int currSum = nums[0], maxSum = nums[0];

    for(int i = 1; i < n; ++i) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}
*/

/*
[1,2,-2,3,7,-4,-3,2,9] -> Input
n = 9
A dp array is created with length 9
max = 1

In 1st iter  : (1>0), dp[1] = 2+1 = 3, max = 3
In 2nd iter : (3>0), dp[2] = -2+3 = 1, max = 3
In 3rd iter : (1>0), dp[3] = 1+3 = 4, max = 4
...
...
...
The max sum will be 15 which will incorporate the complete array
*/
