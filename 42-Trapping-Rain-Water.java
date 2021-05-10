public class Solution {
    public int trap(int[] height) {
        
        if(height.length==0) {
            return 0;
        }
        
        int maxSoFar = 0;      // Variable to store maximum height seen so far
        int[] max_right = new int[height.length];  // An array to store maximum height of any tower on right side of a particular tower
        int maxSeenLeft = 0; // We can use an array for left also, but we believe in optimization, so using a single variable
        int rainwater = 0; // Result which needs to be  returned
        
        for(int i=height.length-1; i>=0; i--) {   // Initialising the max_right array
            if(height[i] > maxSoFar) {
                maxSoFar = height[i];
                max_right[i] = maxSoFar;
            }
            else {
                max_right[i] = maxSoFar;
            }
        }
        
        
        for(int i=0; i<height.length;i++) {      // Calculating rainwater for rvery tower as per algorithm
            rainwater = rainwater + Math.max(Math.min(maxSeenLeft, max_right[i])-height[i],0);
            
            if(height[i] > maxSeenLeft) { // updating the maxSeen left
                maxSeenLeft = height[i];
            }
            
        }
        
        return rainwater;
        
    }
}
