public class MinStack {

    /** initialize your data structure here. */
     Stack<Integer> stack; // stack to handle the push, pop and top operations
     Stack<Integer> min_val ; // stack needed to handle the getMin operation
      
     public MinStack() {
       stack = new Stack<Integer>();
       min_val = new Stack<Integer>();
    }
    
    /*
    When push() is called, add the value to the stack and if the minStack is empty, add to minStack,
    If minStack is not empty, check the peek value. If peek value is greater, then add to minStack as well,
    If peek value is smaller, add the peek value again.
    We are ensuring that the top of minstack always contains the minimum value in stack at that time
    And every time, the number of elements in both the stacks will remain same.
    */
    public void push(int x) {
        stack.push(x);
        if(min_val.isEmpty()) { 
            min_val.push(x);
        }
        else {
            int y = min_val.peek();
            if(y>x) {
                min_val.push(x);
            }
            else {
                min_val.push(y);
            }
        }
        
    }
    
    public void pop() {
        stack.pop();
        min_val.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack.peek();
    }
    
    public int getMin() {
          if(min_val.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return min_val.peek();     
        }
          
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
