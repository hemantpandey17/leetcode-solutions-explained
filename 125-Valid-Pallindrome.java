class Solution {
    public boolean isPalindrome(String s) {
        if(s== null || s.length() == 0 || s.length() == 1)
            return true;
        
        s = s.replaceAll("[^A-Za-z0-9]","");
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        
        if(sb.toString().equals(s))
            return true;
        else
            return false;
    }
}

/*
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
*/
