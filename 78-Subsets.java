
     public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> inner = new ArrayList<Integer>();
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
         
        helper(outer, inner, 0, nums);
        return outer;
        }
        
        public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        
        // Inserting the blank list [] first  
          
        res.add(each);
         System.out.println(res);
         
        for (int i = pos; i < n.length; i++) {
                each.add(n[i]);
                System.out.println("Each list is" + each);
                helper(res, new ArrayList<>(each), i + 1, n);
                // We are doing backtracking here 
                each.remove(each.size() - 1);
                System.out.println("Each list after remove  is" + each);
        }
            return;
        }
}

/*
Complexity Analysis

Time complexity: O(N * 2^N) to generate all subsets and then copy them into output list.

Space complexity: O(N). We are usingO(N) space to maintain curr, and are modifying curr in-place with backtracking. Note that for space complexity analysis, we do not count space that is only used for the purpose of returning output, so the output array is ignored.
*/

/*

A big advantage of bit manipulation is that it can help to iterate over all the subsets of an N-element set. As we all know there are 2^N possible subsets of any given set with N elements. What if we represent each element in a subset with a bit. A bit can be either 0 or 1, thus we can use this to denote whether the corresponding element belongs to this given subset or not. So each bit pattern will represent a subset.

Consider a set A of 3 elements.
A = {a, b, c}

Now, we need 3 bits, one bit for each element. 1 represent that the corresponding element is present in the subset, whereas 0 represent the corresponding element is not in the subset. Let’s write all the possible combination of these 3 bits.

0 = (000)2 = {}
1 = (001)2 = {c}
2 = (010)2 = {b}
3 = (011)2 = {b, c}
4 = (100)2 = {a}
5 = (101)2 = {a, c}
6 = (110)2 = {a, b}
7 = (111)2 = {a, b, c}

Pseudo Code:

possibleSubsets(A, N):
    for i = 0 to 2^N:
        for j = 0 to N:
            if jth bit is set in i:
                print A[j]
        print ‘\n’

*/
// public class Solution {
// public List<List<Integer>> subsets(int[] nums) {
//     int n = nums.length;
//     List<List<Integer>> subsets = new ArrayList<>();
//     // There are 2^n subsets fora set witn n elements
//     for (int i = 0; i < Math.pow(2, n); i++)
//     {
//         // create a list for every susbset
//         List<Integer> subset = new ArrayList<>();
//         for (int j = 0; j < n; j++)
//         {   // If the jth bit is set 
//             if (((1 << j) & i) != 0)
//                 // add the element at index j to the list 
//                 subset.add(nums[j]);
//         }
//         // sort the subset (not necessory)
//         //Collections.sort(subset);
//         // adding to the outer list
//         subsets.add(subset);
//     }
//     return subsets;
// }
// }
