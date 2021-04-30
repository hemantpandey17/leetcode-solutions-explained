// the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.

class Solution {
       public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max=0;
            for (int i=0, j=0; i<s.length(); ++i){
                if (map.containsKey(s.charAt(i))){
                                    // j represents the start of the current string with unique characters, so If you have a string like abba, when you encounter last a, you want to mark the start of the string from index 2(second occurrence of b) which is the last known index which holds uniqueness assumption, not from map.get(a)+1 which is 1
                    j = Math.max(j,map.get(s.charAt(i))+1);
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-j+1);
            }
            return max;
        }
    }

// Input : abba

// map : [a:0]
// map : [a:0,b:1]
// Now b comes again, j = max(0,2) = 2
// Now a comes again, j = max(2,1) = 2 [If we didn't use max, j would have been 1, thus false result]
