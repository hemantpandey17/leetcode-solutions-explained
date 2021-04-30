/*
see editorial solution
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // Boolean array to store if the string s is broken till index i
        boolean[] isBreakable = new boolean[s.length()+1];
        isBreakable[0]=true; // we initialize the element \text{dp}[0]dp[0] as \text{true}true, since the null string is always present in the dictionary,
        
        for(int end=1; end<=s.length(); end++) {
            for(int start=0; start<end; start++) {
                if(wordDict.contains(s.substring(start,end)) && isBreakable[start] == true) {
                    isBreakable[end]=true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(isBreakable));
        return isBreakable[s.length()];
    }
}

/*
Complexity Analysis

n is the length of the input string.

Time complexity : O(n^3)
There are two nested loops, and substring computation at each iteration. Overall that results in O(n^3)

Space complexity : O(n). Length of pp array is n+1.
*/

/*
Dry run

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true

Make an array isBreakable of length 9

End = 1, start = 0
We check if the wordDict contains the substring formed by s.substring(start,end) i.e "l", No

End = 1, start = 1, start would always be less than end, inner loop breaks

End = 2, start = 0
Similiart we check for all, we get a word contained in wordDict when end will be 5 and start will be 0 i.e "leet"
Now the next condition is to check isBreakable[start], which is 0 in this case, so we go in inner loop, make isBreakable[5] = true

This means that within index 0-4 we find a word which is there in the wordDict

Now, we will keep repeating the same procedure, we will find another word whtn start = 5 and end = 8, i.e code
and we check isBreakable[5], which we made true when we found leet earlier.

So we make isBreakable[8] = true.

In the end isBreakable[s.length()] will determine if the word is breakable or not.

*/
