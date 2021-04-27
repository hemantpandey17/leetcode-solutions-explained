class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        
        for(int pos = nums.length - 1; pos >=0 ; pos--) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])) {
                res[pos] = nums[start] * nums[start];
                start++;
            } else {
                res[pos] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}
