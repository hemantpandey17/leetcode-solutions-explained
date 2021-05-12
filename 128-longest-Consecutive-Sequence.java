public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int n:nums) {
            set.add(n);
        }
        
        int len = 0;
        for(int n:nums) {
            
            // The if condition will be true only if it is start of the streak.
            // For ex : for 100 entry, we check if 99 exist in set or not, if not we know any streak with 100 in it start at 100
            if(!set.contains(n-1)) {
                int temp = n;
                while(set.contains(temp)) {
                    temp++;
                }
            
                len = Math.max(len,temp-n);
            }   
        }
        
        return len;
    }
}
