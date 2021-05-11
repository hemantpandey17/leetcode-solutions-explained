class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || k <= 0) {
			return new int[0];
		}
        
        
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window.
        int n = nums.length;
        int[] r = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int ri = 0;
         /* Process first k (or first window) elements of array */
        
        for(int i=0 ; i<nums.length; i++) {
            
            // The element at the front of the queue is the index of largest element of
            // previous window ie queue.peek(), Remove the elements which are out of this window
            while(!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();
            
            // For very element, the previous smaller elements are useless so
            // remove them from deque
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) 
                deque.removeLast();
            
            // Add new element at rear of queue, note that queue contains index and r contains content
            deque.offer(i);
            if( i >= k - 1) {
                r[ri++] = nums[deque.peek()];
            }
            System.out.println(deque);
        }
        return r;
    }
}

/*
Dry run

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Creating a result array of size n-k+!

Push index of 1 in deque, deque - [0]

we come to 3, since window size is 3, we are still in window and forst while loop checks if we are going out of window, so noting to do in first loop, second while loop makes sure that the peek of deque always contains the index of largest element.So, we get 3 which is greater than nums[deque.peekLst()] = 1, we remove index of 1 and push index of 3, deque - [1]

We come to -1, still in the window, nothing to do in first while loop, current element is less than peek index element, then we add -1's index to queue, deque [1,2]

Now, i >= k-1, so we have encountered all elements of first window, we make r[0] = nums[1] = 3

Now, for index 3, we get -3, we check if we are getting out of window by checking deque.peek() < i - k + 1, so we are not, also the peek lement is greater than curr, so we add, deque = [1,2,3]

Now for index 4, we get 5, we are out of window here, so we do deque.removeLast(), which will remove index 1 from queue, and since 5 > -3 and 5 > -1, we remove index 2 and 3, add 4 to queue, deque = [4]


...........



*/
