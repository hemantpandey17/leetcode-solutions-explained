class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        
        String max = s.substring(0,1);
        
        for(int i=0 ; i<s.length(); i++) {
            String temp = pallindromeMax(s,i,i);
            if(temp.length() > max.length()) {
                max = temp;
            }
            
            temp = pallindromeMax(s,i,i+1);
            if(temp.length() > max.length()) {
                max = temp;
            }
        }
        
        return max;
    }
    
    public String pallindromeMax(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}

/*
Complexity Analysis

Time complexity : O(n^2)
Since expanding a palindrome around its center could take O(n) time, the overall complexity is O(n^2)

Space complexity : O(1).
*/
