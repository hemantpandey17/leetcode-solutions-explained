/*
 https://www.youtube.com/watch?v=RVIh0snn4Qc,
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        int max_area = 0;
        int area = 0;
        int i = 0;
        
        while(i<heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i); // Pushing indexes
                i++;
            }
            else {
                top = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[top] * i;
                }
                else {
                    area = heights[top] * (i - stack.peek()-1);
                }
                if(area > max_area) {
                    max_area = area;
                }
            }
        }
        while(!stack.isEmpty()) {
            top = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[top] * i;
                }
                else {
                    area = heights[top] * (i - stack.peek()-1);
                }
                if(area > max_area) {
                    max_area = area;
                }
        }
        
        return max_area;
        
    }
}

/*
Dry run
Input: [2,1,5,6,2,3]

We take a stack, take a variable area to store current arean and variable maxArea to store maxArea till now
Lets iterate over the array,

Since stack is empty, add index 0 to stack and increment i
Stack = [0]

Now, at i=1, height is 1, so we check if it it greater than height at top of stack, it is not. This means bar with height 2 cannot include bar with height 1 in its area, so we will noe calculate the area formed by bar with height 2
so we pop from stack, just to say that we are done with this bar, since stack is empty, area = 2, then our maxArea becomes 2 and i is still 1. Stack = []

Now, since stack is empty, we push index 1 to stack and increment i. Stack = [1]

Now i = 2, we get bar with height 5 at this index which is greater thar bar at index which is at top of stack, this mean bar 1 can include bar 5 in its area, push bar 5 at index 2 in stack and increment i. Stack = [1,2]

Now i = 3, we get bar with height 6 at this index which is greater thar bar at index which is at top of stack, this mean bar 5 can include bar 6 in its area, pushh bar 6 at index 3 in stack and increment i. Stack = [1,2,3]

Now i = 4, we get bar with height 2, see that height falls here, that means bar 6 cannot include bar 2 in area, so lets calculate the area formed by bar 6. Pop 4 from stack just to say that we are done with bar at index 4, since stack is not empty, calculate area formed by bar 6, ie height[3]*(i-stack.peek()-1) = 6*(4-3)=6, update maxArea as 6. Note, i is still at 4. Stack = [1,2]

Now bar with height 2 is still less than bar 5 which is at top of stack now, so we will calculate the area formed by bar 5, we pop from stack, sice stack is not empty, area = height[2]*(4-1-1) = 5*2=10, update maxArea as 10, Stack = [1]. i still at 4

Now bar with height 2 is greater than bar 1 which is at top, so we push to stack and increment i. Stack = [1,4]. i = 5

Now bar with height 3 is greater than bar 2 at top, push to stack and increment i, Stack = [1,4,5]

Now we do same area calculation procedure for stack [1,4,5].


*/
