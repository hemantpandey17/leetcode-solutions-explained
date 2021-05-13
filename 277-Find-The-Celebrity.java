/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// public class Solution extends Relation {
    
//     private int numberOfPeople;
    
//     public int findCelebrity(int n) {
//         numberOfPeople = n;
//         for (int i = 0; i < n; i++) {
//             if (isCelebrity(i)) {
//                 return i;
//             }
//         }
//         return -1;
//     }
    
//     private boolean isCelebrity(int i) {
//         for (int j = 0; j < numberOfPeople; j++) {
//             if (i == j) 
//                 continue; // Don't ask if they know themselves.
//             if (knows(i, j) || !knows(j, i)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

/*
Time Complexity : O(n^2)
For each of the nn people, we need to check whether or not they are a celebrity.

Checking whether or not somebody is a celebrity requires making 22 API calls for each of the n - 1 other people, for a total of 2⋅(n−1)=2⋅n−2 calls. In big-oh notation, we drop the constants, leaving O(n)O(n).

So each of the nn celebrity checks will cost O(n)O(n), giving a total of O(n^2)

Space Complexity : O(1).

Our code only uses constant extra space. The results of the API calls are not saved.
*/

public class Solution extends Relation {
    
    private int numberOfPeople;
    
    public int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) 
                continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}

/*
Complexity Analysis

Time Complexity : O(n).

Our code is split into 2 parts.

The first part finds a celebrity candidate. This requires doing n - 1 calls to knows(...) API, and so is O(n)

The second part is the same as before—checking whether or not a given person is a celebrity. We determined that this is O(n).

Therefore, we have a total time complexity of O(n + n) = O(n+n)=O(n).

Space Complexity : O(1).

Same as above. We are only using constant extra space.
*/
