class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}

/*
Complexity Analysis:

Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.

Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.

*/
