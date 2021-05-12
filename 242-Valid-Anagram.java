/*
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null && t==null)
        return true;
        else if(s.length()!=t.length())
        return false;
        
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1,c2))
        {
            return true;
        }
        else
        return false;
    }
}
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) {
            return true;
        }
        else if(s.length()!=t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        for(char ch:t.toCharArray()) {
            freq[ch - 'a']--;
            if(freq[ch-'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}
        
        
