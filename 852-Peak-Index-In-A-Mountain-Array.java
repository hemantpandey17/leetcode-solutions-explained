class Solution {
   /* public int peakIndexInMountainArray(int[] A) {
        if(A.length < 3)
            return -1;
        for(int i=1; i<A.length-1; i++) {
            if((A[i] - A[i-1]) > 0 && (A[i] - A[i+1] > 0))
                return i;
        }
        return -1;
    }
    */
    
    public int peakIndexInMountainArray(int[] A) {
        if(A.length < 3)
            return -1;
        int low = 0;
        int high = A.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(A[mid] < A[mid+1]) {
                low = mid + 1;
            }
            else { 
                high = mid;
            }
        }
        return low;
       
    }
    
    
}

/*
[24,69,100,99,79,78,67,36,26,19]
lo = 0, hi = 9, mid = 4
Since arr[4](79) > arr[5], hi = mid  = 4
lo = 0, hi = 4, mid = 2
Since arr[2](100) > arr[3], hi = mid = 2
lo = 0, hi = 2, mid = 1
Since arr[1](69) < arr[3], lo = mid + 1 = 2
lo = 2, hi = 2
return 2


*/
