public class Solution {
    public int findKthLargest(int[] a, int k) {
        int index = quickselect(a,0,a.length-1,a.length - k + 1);
        return a[index];
    }
    
    public int quickselect(int[] a, int low, int high, int k) {
        int i = low;
        int j = high;
        
        int pivot = a[high];
        while(i < j) {
            if(a[i++] > pivot)
                swap(a,--i,--j);
        }
        swap(a,i,high);
        int m = i - low + 1;
        if(m ==k)
            return i;
        else if(m > k) {
            return quickselect(a,low,i-1,k);
        }
        else {
            return quickselect(a,i+1,high,k-m);
        }
    }
    
    public void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}

// O(N) best case / O(N^2) worst case running time + O(1) memory


/*
You can take a couple of approaches to actually solve it:

    O(N lg N) running time + O(1) memory

The simplest approach is to sort the entire input array and then access the element by it's index (which is O(1)) operation:

public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}

    O(N lg K) running time + O(K) memory

Other possibility is to use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the whole input and maintains the size of priority queue.

public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}


*/
