class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i=1; i<nums.length; i++) {
            int maxValTillNow = 0;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    maxValTillNow = Math.max(maxValTillNow, dp[j]);
                }
            }
            dp[i] = maxValTillNow + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
