class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null)
            return "";
        
        int[] freq = new int[128];
        for(char ch : t.toCharArray()) {
            freq[ch - 'A']++;
        }
        
        int count = t.length();
        int begin = 0;
        int end = 0;
        int beginSubStr = 0;
        int endSubStr = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(end < s.length()) {
            
            if(freq[s.charAt(end) - 'A'] > 0) {
                count--;
            }
            
            freq[s.charAt(end) - 'A']--;
            end++;
            
            while(count == 0) {
                if(minLen > end - begin ) {
                    minLen = end - begin;
                    
                    beginSubStr = begin;
                    endSubStr = end;
                    System.out.println(s.substring(beginSubStr, endSubStr));
                }
                
                if(freq[s.charAt(begin) - 'A'] == 0)
                    count++;
                freq[s.charAt(begin) - 'A']++;
                begin++;
                    
            }
        }
        return(s.substring(beginSubStr, endSubStr));
    }
}

/*
Dry run

S = ADOBECODEBANC
T = ABC

Created frequency array of T with 1 at indexes of A, B and C and 0 at other places
count = 3
begin,end,beginSubstr,endSubstr = 0

We start from forst current with pointer end
We check its frequency in array, if it is greater that 0. then we decrement count by 1 (this means we got 1 character we wanted)

Now, we reduce the frequency by 1 in array and increment the end pointer
We'll repeat it till count becomes 0, that means all the characters in T we have got in S till now, in this case end will be at ADOBEC (5)

minLen will be 5 now, now beginSubstr =0, endSubStr = 5
Now we will slide window from left when count is 0, so we check character at begin, its frequency in arr is already 0,
so we increase count since now we are not considering A and slided from left
Now we increase the freq of A in array that means it can be used again now
And increment the begin by 1, now begin come as D


*/
