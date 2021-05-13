/*
The Reverse Polish Notation is a stack of operations, thus, I decided to use java.util.Stack to solve this problem. As you can see, I add every token as an integer in the stack, unless it's an operation. In that case, I pop two elements from the stack and then save the result back to it. After all operations are done through, the remaining element in the stack will be the result.
*/

class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s: tokens) {
            if(s.equals("+")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a + b);
            }
            
            else if(s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            }
            
            else if(s.equals("*")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a * b);
            } 
            
            else if(s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            }
            
            else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
