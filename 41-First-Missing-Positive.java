class Solution {
    public int firstMissingPositive(int[] A) {
        
        //Dry run : [3,4,-1,1]
        
        int i = 0;
        while(i < A.length){
            // If A[i]=i+1, this means element is already in correct position
            // If A[i] <=0, this means element is negative, do not care
            // If element is greater than length, do not care, our value lies between 1 and A.length
            
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) 
                i++;
            else if(A[A[i]-1] != A[i]) 
                swap(A, i, A[i]-1); 
            else 
                i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) 
            i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

/*
Input: [3,4,-1,1]

We iterate over the array, we check if ith character is in correct position if A[i] == i+1 or it is negative number or it is greater than length of array, if any of this is true, increment i

Else, we switch the entry to its correct position, for example the entry is 3, we know correct poistion of 3 is A[2], so wecheck if A[2] is equal 3 or not, if no, we swap and put 3 to its correct position, Now A = [-1,4,3,1], we won't increment i here as the value at i is changed

Now, entry at i is -1, which is less than 0, so we don't care. Increment i

Now, entry at i=1 is 4, we know correct position of 4 is A[3], we check if 4 is equal to A[3], if not, swap. A = [-1,1,3,4]. we won't increment i here as the value at i is changed

Now, entry at i=1 is 1, we know correct position of 1 is A[0], so we swap, A=[1,-1,3,4], we won't increment i here as the value at i is changed

Now entry at i=1 is -1, which is negative, so we dont care and increment i.

Now entry at i=2 is 3, which is correct postion so we increment i

Now entry at i=3 is 4, which is correct position so we increment i

Now, iterate over array again and check the first index there is incorrect entry and then return i + 1.





*/
