public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        System.out.println("Prefix : " + prefix);
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // trim the last character of prefix
                if (prefix.isEmpty()) return ""; // At any time, if prefix becomes empty, retrun "" (means there is no common prefix)
            } 
        }     
        return prefix;
    }
}
