class Solution {
// Thought
// We aim to find all possible A[i] + B[j] + C[k] + D[l] = 0, that is,
// A[i] + B[j] = -(C[k] + D[l])
// In other words, we need to count the number of all possible two-sums between A and B that equals to opposite of any two-sum between C and D.
// Thus, we enumerate all two-sums between C and D, and store sum-to-frequency mappings for reference.

// Code

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        Map<Integer, Integer> map = new HashMap<>(); // key: sum, value: frequency of sum.
        
        int n = A.length, result = 0; 
        
        // Get all possible two-sums between C and D.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        System.out.println(map);
        
        // Count the number of two-sums between A and B that equals to opposite of any two-sum between C and D
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(-sum))
                    result += map.get(-sum);
            }
        }
        
        return result;
    }

}

/*
Dry run

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Get all possible two-sums between C and D.
Combos are : -1+0. -1+2, 2+0, 2+2, create frequency map of these combos
{-1=1, 1=1, 2=1, 4=1}

Now for all combos of A and B, check if the alternate negative sum exist in map.
Combos are : 1-2, 1-1, 2-2, 2-1 = -1,0,0,1

For -1, 1 exists in the map
For 1, -2 exists in the map

Add the corresponding frequency to map.

*/
