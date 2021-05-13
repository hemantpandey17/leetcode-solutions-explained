/*
In this problem, it feels binary search would go wrong since we are not sure if either side could have increasing or decreasing numbes.

However, the key point is that a peak would defiitely be present and the answer from either side of the array after creating the half in binary search is fine and so binary search works.

If we were asked to only find one peak then binary search would probably fail since we would not be sure of which direction to go in as the array is not sorted.
Binary search works since :

    either peak can be answer[sorted property which is strictly required for BS gets countered]
    peak definition can be checked with 2 indices adjacent to the mid value.

*/

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = (start + end)/2;
            if(nums[mid] < nums[mid+1]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}
