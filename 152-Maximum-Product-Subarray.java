class Solution {
    int maxProduct(int A[]) {
        // store the result that is the max we have found so far
        int r = A[0];
        
    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
        int imax = r, imin = r;
        
        for (int i = 1; i < A.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            //so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
                

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}

// Any idea why we are taking the min value also,
// lets suppose input [2,-3,-2]
// Here if we don't take -6 after index 2, max will be 2
// we don't know whether numbers ahead are positive or negative

/*
Input: [2,3,-2,4]

r = 2, imax = 2, imin =2
That means till index 0, we have max prod as 2 and min prod as 2

When we see 3, 
imax = max(3,2*3) = 6
imin = min(3,2*3) = 3

When we see -2,
since it is less than 0, we swap imax and imin
imax = 3, imin=6
imax = max(-2,-3*2) = -2
imin = min(-2,-2*6) = -12

We see 4
imax = max(4,-2*4)=4
imin = min(4,4*-12) = -48

*/
