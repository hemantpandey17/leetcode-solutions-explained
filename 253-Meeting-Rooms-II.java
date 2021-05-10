/*
Sorting part is easy, but for every meeting how do we find out efficiently if a room is available or not? At any point in time we have multiple rooms that can be occupied and we don't really care which room is free as long as we find one when required for a new meeting.

A naive way to check if a room is available or not is to iterate on all the rooms and see if one is available when we have a new meeting at hand.

    However, we can do better than this by making use of Priority Queues or the Min-Heap data structure.

Instead of manually iterating on every room that's been allocated and checking if the room is available or not, we can keep all the rooms in a min heap where the key for the min heap would be the ending time of meeting.

So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied.

If the room we extracted from the top of the min heap isn't free, then no other room is. So, we can save time here and simply allocate a new room.

Let us look at the algorithm before moving onto the implementation.

Algorithm

    Sort the given meetings by their start time.
    Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
    For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
    If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
    If not, then we allocate a new room and add it to the heap.
    After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.



*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, (w1,w2) -> w1[0]-w2[0]);
        
         PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
         });
             
        pq.offer(intervals[0]);
             
        for(int i=1 ; i<intervals.length; i++) {
            int[] interval = pq.poll();
            
            //  if the start time is greater than the end time of polled out meeting, that means the same room                  can be used forboth meeting, so we change the end time and eventually add the changed one to pq.
            if(intervals[i][0] >= interval[1]) {
                interval[1] = intervals[i][1];
            }
            
            // Otherwise, separate rooms will be needed, so we add the current meeting and then later add the                   polled out meeting
            else {
                pq.offer(intervals[i]);
            }
            pq.offer(interval);
        }
        return pq.size();
        
    }
}

/*
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*
 class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, (w1,w2) -> w1.start-w2.start);
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        pq.offer(intervals[0]);
        
        for(int i=1 ; i<intervals.length; i++) {
            Interval interval = pq.poll();
            
            if(intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            }
            else {
                pq.offer(intervals[i]);
            }
            pq.offer(interval);
        }
        return pq.size();
    }
}

*/
