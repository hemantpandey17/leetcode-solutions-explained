//The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be marked as negative. In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list

public class Solution {
      public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) -1;
           
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
          
         
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}

/*
Dry run

[4,3,2,7,8,2,3,1]

When we see 4, we change value at index 3 from 7 to -7
When we see 3, we change value at index 2 from 2 to -2
When we see 2, we change value at index 1 from 3 to -3
...
...

Now only those indexes will be +ve , corresponding numbers to which does not exist in array


*/
