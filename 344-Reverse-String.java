class Solution {
//     public void reverseString(char[] s) {
//         helper(0, s.length-1, s);
//     }
    
//     private void helper(int start, int end, char[] s){
//         if(start>=end){
//             return;
//         }
//         char temp = s[start];
//         s[start] = s[end];
//         s[end] = temp;
//         helper(start+1, end-1, s);
//     }
    
    public void reverseString(char[]s) {
        
        if(s == null || s.length == 0)
            return;
        
        int start = 0;
        int end = s.length-1;
        
        while(start<end) {
            char temp = s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }
}
