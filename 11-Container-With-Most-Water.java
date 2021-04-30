class Solution {
    public int maxArea(int[] height) {
       
        int maxArea = 0 ; 
        // Two pointer approach, well explained in the editorial solution
        int l = 0; // leftmost height (left pointer)
        int r = height.length - 1; // rightmost height (right pointer)
        
        while(l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l)); // variable which keeps account of the maximum area
            if(height[l] < height[r]) // see the editorial section for clarification
                l++;
            else
                r--;
        }
        return maxArea;
    }
}

/*
The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.

We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. Futher, we maintain a variable \text{maxarea}maxarea to store the maximum area obtained till now. At every step, we find out the area formed between them, update \text{maxarea}maxarea and move the pointer pointing to the shorter line towards the other end by one step.

Initially we consider the area constituting the exterior most lines. Now, to maximize the area, we need to consider the area between the lines of larger lengths. If we try to move the pointer at the longer line inwards, we won't gain any increase in area, since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width. This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.

*/
