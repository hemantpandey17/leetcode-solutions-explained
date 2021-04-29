/*
Now the question is how to rob a circular row of houses. It is a bit complicated to solve like the simpler question. It is because in the simpler question whether to rob num[lo] is entirely our choice. But, it is now constrained by whether num[hi] is robbed.

However, since we already have a nice solution to the simpler problem. We do not want to throw it away. Then, it becomes how can we reduce this problem to the simpler one. Actually, extending from the logic that if house i is not robbed, then you are free to choose whether to rob house i + 1, you can break the circle by assuming a house is not robbed.

For example, 1 -> 2 -> 3 -> 1 becomes 2 -> 3 if 1 is not robbed.

Since every house is either robbed or not robbed and at least half of the houses are not robbed, the solution is simply the larger of two cases with consecutive houses, i.e. house i not robbed, break the circle, solve it, or house i + 1 not robbed. Hence, the following solution. I chose i = n and i + 1 = 0 for simpler coding. But, you can choose whichever two consecutive ones.

*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) 
            return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    /* the order is: prev2, prev1, num  */
public int rob(int[] nums, int lo, int hi) {
    if (nums.length == 0) 
        return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int i=lo; i<=hi; i++) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + nums[i], prev1);
        prev2 = tmp;
    }
    return prev1;
}
}

/*
Dry run
Input: [1,2,3,1]
Max(rob(nums,0,2),rob(nums,1,3)

Lets call rob function on (nums,0,2) - i,e fund max robbery in [1,2,3]

include = 0, exclude = 0;
We iterate between index 0 and 2 (low nand high)
i = 0, e = 0;
Now, if we include the current value, include = e + nums[lo] = 0 + 1 = 1
and exculde will be Math.max(0,0) = 0
This means if we include 1, max robbery till here is 1 and if we exclude, max robbery till here is 0

We go to 2, i=1,e=0 (i and e are here for previous entry)
include = e + num[j] = 0 + 2 = 2
exclude = Math.max(0,1) = 1
This means if we include 2, max robbery is 2 and if we exclude 2, max robbery till here is 1

We go to 3, i=2, e=1 (i and e are here for previous entry)
include = e + num[j] = 1 + 3 = 4
exclude = Math.max(1,2) = 2

Return(Math.max(include, exclude)) = 4


*/
