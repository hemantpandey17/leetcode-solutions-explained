public class Solution {
    
    /*
    The basic approach is to start comparing the last elements of both arrays and keep adding the larger element to the last.
    Repaeating the same thing again and again till elements of nums 2 are finished.
    */
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m-1; // index of last element of nums1
        int j = n-1; // index of last element of nums2
        int k = m+n-1; // index of last element of result array
        
        while(i>=0 && j>=0) {
            if(nums1[i] > nums2[j] ) { // if last element of nums1 is greater
                nums1[k--] = nums1[i--]; // last elemet of result array will last element of nums 1
            }
            else {
                nums1[k--] = nums2[j--]; // else, last element of nums2 will be last element of result array 
            }
        }
        
        while(j >= 0) { // if nums 2 has more elements and elements of nums1 are finished
            nums1[k--] = nums2[j--]; // add them
        }

    }
}
