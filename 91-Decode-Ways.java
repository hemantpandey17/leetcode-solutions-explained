class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<array.length;i++){
            if(array[i] == '(' || array[i] == '{' || array[i] == '[')
                stack.push(array[i]);
            else if(!stack.empty() && stack.peek() == '(' && array[i] == ')')
                stack.pop();
            else if(!stack.empty() && stack.peek() == '{' && array[i] == '}')
                stack.pop();
            else if(!stack.empty() && stack.peek() == '[' && array[i] == ']')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
}

/*
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
*/
