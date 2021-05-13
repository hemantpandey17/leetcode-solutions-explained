 /*public class Solution
 {
     public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1])
            nums[i++] = n;
    return i;
}
     
 }
 */
 public class Solution {
     public int removeDuplicates(int[] nums) {
         int len = nums.length;
         int id = 1;
         for(int i=1; i<nums.length; i++) {
             if(nums[i]!=nums[i-1]) {
                 nums[id++] = nums[i];
             }
         }
         return id;
     }
 }
