class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
             //System.out.println("middle : " + mi);
            if (letters[mi] <= target) 
                lo = mi + 1;
            else 
                hi = mi;
            //System.out.println("lo : " + lo);
            //System.out.println("hi : " + hi);
        }
        if(lo == letters.length)
            return letters[0];
        return letters[lo];
    }
}

/*
letters = ["c", "f", "j"]
target = "g"
Output: "j"

*/
