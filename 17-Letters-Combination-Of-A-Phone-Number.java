class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digitLetter = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        
        
        for(int i = 0; i<digits.length(); i++) {
            int a = digits.charAt(i) - '0';
            String str = digitLetter[a];
            res = combine(res,str);
        }
        return res;
    }
    
    public List<String> combine(List<String> res, String str) {
            List<String> result = new ArrayList<>();
            for(int i=0; i<str.length(); i++) {
                for(String a: res) {
                     result.add(a + str.charAt(i));
                }
            }
        return result;
        }
}




