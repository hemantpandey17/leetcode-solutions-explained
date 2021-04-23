public class Solution {
  /*  public int missingNumber(int[] nums) {
           
         int sum=0;
          int len=nums.length+1;
           for(int n:nums)
           sum+=n; // keep on adding the value of each element to the sum
          return ((len*(len-1)) /2-sum); // Sum of n numbers - sum
            
        
        }
      */ 
    
    /*
    Intuition

We can harness the fact that XOR is its own inverse to find the missing element in linear time.

Algorithm

Because we know that nums contains n numbers and that it is missing exactly one number on the range 
[0..n−1], we know that n definitely replaces the missing number in nums. Therefore, if we initialize an integer to n and XOR it with every index and value, we will be left with the missing number. Consider the following example (the values have been sorted for intuitive convenience, but need not be):
    */
    public int missingNumber(int[] nums) {
        int j = nums.length;
        for(int i=0; i<nums.length; i++) {
            j = j^i^nums[i];
        }
        
        return j;
    }
  
    }
