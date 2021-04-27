
public class Solution {
    
    /*
    You don't need to sort the array, the binary search is in the range [1,n] not in the array, you binary search for a number in this range, and check if the count of numbers less than or equals that in nums is greater than itself. like that:
    */
    public int findDuplicate(int[] nums) {
        // nums = [1,3,4,4,2]
        int low = 1, high = nums.length - 1; // low = 1, high = 4
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5); // mid = 2
            int cnt = 0;
            for (int a : nums) { // Counting all the elements which are less than or equal to 2
            if (a <= mid) ++cnt; // count = 2
            }      // If the value of count is greater than mid, then we find duplicate using same way between low and mid
            if (cnt <= mid) 
                low = mid + 1; // count = 2, mid = 2, low = mid + 1 = 3
            else 
                high = mid - 1;
        }
    return low;
    }
}

/*

Time Complexity - O(nlogn) logn times for outer while loop and n times for inner for loop
Space Complexity - O(1)

*/
