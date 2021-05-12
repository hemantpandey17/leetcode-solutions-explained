class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        int res = 0;
        int i = 0;
        
        if(str.charAt(0) == '-') {
            sign = -1;
            i++;
        }
            
        else if(str.charAt(0) == '+') {
            sign = 1;
            i++;
        }
        
        while(i < str.length()) {
            int digit = str.charAt(i) - '0';
            if(digit > 9 || digit < 0)
                break;
            if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
            i++;
        }
        
        if(sign ==  1)
            return res;
        if(sign == -1)
            return -1 * res;
        
        return res;
        
        
    }
}
