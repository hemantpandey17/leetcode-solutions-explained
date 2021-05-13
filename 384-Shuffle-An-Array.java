public class Solution {
        int [] nums;
        Random random;
        
        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }
    
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null)
            return null;
        int[] a = nums.clone();
        for(int j=0; j<a.length; j++) {
            int i = random.nextInt(j+1);
            swap(a,i,j);
        }
        return a;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
