public class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            
            int mid = (start+end)/2;
            
            if(nums[mid]==target) {
                return mid;
            }
            
            if(nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                }
                else {
                    start =  mid + 1;
                }
            }
            
            else {
                 if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
            
        
        
    }
}

/*
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

start = 0
end = 6

while start < end

mid = 3, nums[mid] = 7

First we check if the middle element is the target, no

We check if start is greater or less than mid element, 

in this case 4 < 7 (mid is greater than start), this means that it is not rotated between start and mid
Now, we see that if target lies between start and mid, then we make end = mid, otherwise we know target lies in other half, so start = mid + 1

If mid is not greater than start, then we know that there is a rotation here, so we know that there is no rotation in other half
So we check if target lies between mid and end, if it does, we make start = mid + 1, if not we make end = mid - 1

In this case,
since mid 7 is greater than start but 0 does not lie between 4 and 7, so we start from now, start = 4, end = 6
Mid = 5, nums[mid] = 1
Now nums[mid] > nums[start], and 0 lies between, we make end = mid, thus end = 5

Now mid = 4+5/2 = 4
Now target == num[mid], so we return mid i.e 4

*/
