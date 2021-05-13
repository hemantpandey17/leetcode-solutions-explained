/*
Approach 1: Sliding Window + Hashmap.

Intuition

Let's use here the logic from the more simple problem with at most two distinct characters.

To solve the problem in one pass let's use here sliding window approach with two set pointers left and right serving as the window boundaries.

The idea is to set both pointers in the position 0 and then move right pointer to the right while the window contains not more than k distinct characters. If at some point we've got k + 1 distinct characters, let's move left pointer to keep not more than k + 1 distinct characters in the window.

compute

Basically that's the algorithm : to move sliding window along the string, to keep not more than k distinct characters in the window, and to update max substring length at each step.

    There is just one more question to reply - how to move the left pointer to keep only k distinct characters in the string?

Let's use for this purpose hashmap containing all characters in the sliding window as keys and their rightmost positions as values. At each moment, this hashmap could contain not more than k + 1 elements.

compute

For example, using this hashmap one knows that the rightmost position of character O in "LOVELEE" window is 1 and so one has to move left pointer in the position 1 + 1 = 2 to exclude the character O from the sliding window.

Algorithm

Now one could write down the algortihm.

    Return 0 if the string is empty or k is equal to zero.
    Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
    While right pointer is less than N:
        Add the current character s[right] in the hashmap and move right pointer to the right.
        If hashmap contains k + 1 distinct characters, remove the leftmost character from the hashmap and move the left pointer so that sliding window contains again k distinct characters only.
        Update max_len.


*/

class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position 
    // in the sliding window
    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

    int max_len = 1;

    while (right < n) {
      // add new character and move right pointer
      hashmap.put(s.charAt(right), right);
      right++;

      // slidewindow contains 3 characters
      if (hashmap.size() == k + 1) {
        // delete the leftmost character
        int del_idx = Collections.min(hashmap.values());
        hashmap.remove(s.charAt(del_idx));
        // move left pointer of the slidewindow
        left = del_idx + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}

/*
Input: s = "eceba", k = 2
left = 0, right = 0
We make a map to hold a character as key and its rightmost position as value
e->0,c->1
Now, we get e again, so map is
e->2,c->1
Now, we get b, we add b->4 to map
e->2,c->1,b->3
Now the size of map is greater than k = 2
so, we have to remove the leftmost element now, which we can get from map (the element with least index)
we remove the character from map and make left as deleted_index+1
map is - e->2,b->3 and left index is 2

And at every step we keep calculate max by (right - left).
*/
