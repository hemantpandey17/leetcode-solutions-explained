class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0)
            return true;
        
        Arrays.sort(intervals, (w1,w2) -> w1[0]-w2[0]);
        
        for(int i= 1; i<intervals.length; i++) {
            if(intervals[i-1][1] > intervals[i][0])
                return false;
        }
        
        return true;
    }
}

/*
Complexity Analysis

Time complexity : O(nlogn). The time complexity is dominated by sorting. Once the array has been sorted, only O(n) time is taken to go through the array and determine if there is any overlap.

Space complexity : O(1). Since no additional space is allocated.

*/
