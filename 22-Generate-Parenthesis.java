/*
The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close). Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. Each of these steps are recursively called.
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(result,"",0,0,n);
        return result;
    }
    
    private void helper(List<String> result, String str, int numOpeningBracket, int numClosingBracket, int max) {
        if(str.length()==2*max) {
            System.out.println(str);
            result.add(str);
            return;
        }
        
        if(numOpeningBracket < max) {
            helper(result,str+'(',numOpeningBracket+1,numClosingBracket,max);
        }
        
         if(numClosingBracket < numOpeningBracket) {
            helper(result,str+')',numOpeningBracket,numClosingBracket+1,max);
        }
        
        
        
    }
}

/*

Dry run with n= 3

helper(result,"",0,0,n) -> helper(result, '(', 1, 0, n) -> 
helper(result, '((', 2,0,n) -> helper(result, '(((', 3, 0 , n) ->
helper(result, '((()', 3,1,n) -> helper(result, '((())', 3, 2 , n) ->
helper(result, '((()))', 3,3,n) 



Now the string added to result and returned

Now, we keep returning 
*/
