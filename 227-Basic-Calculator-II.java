class Solution {
    public int calculate(String s) {
        int len;
        // If empty string is given, then return 0
        if(s==null || (len = s.length())==0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        // In beginning, the num = 0 and sign is + (no sign)
        int num = 0;
        char sign = '+';
        
        
        for(int i=0;i<len;i++){
            
            // This is for case when there are digits in string
            // eg "30", thus we take each digit and make it num 30
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            
            // If the character is a sign or ' ' or last character which is not gigit
            if( (!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
}


/*
Let's dry run

3+2*2

First num is 3
, then sign is +, so we put 3 in stack - Stack [3]
, then num is 2
, then sign is +, so we put 2 in stack - Stack [3,2]
, Now sign is *
, then num is 2
, now since last character and sign is *, we pop 2 and push 2*2 in stack -Stack - [3,4]

Now, sum all elements of stack : 7
*/
