/*public class MedianFinder {
    List<Integer> list = new ArrayList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        list.add(num);
        
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        double median = 0;
        if(list.size()%2==0) {
            Collections.sort(list);
            
            
            int m1 = list.size()/2;
             
            int m2= list.size()/2 + 1;
            ;
            median = ((double)list.get(m1-1) + (double)list.get(m2-1))/2 ;
            
        }
        else {
            Collections.sort(list);
            int pos = (0 + list.size())/2;
            median = list.get(pos);
           
            return (list.get(pos));
            
        }
        return median;
        
    }
};*/

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

class MedianFinder {
    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half
 
    public MedianFinder(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
 
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num); // Add to max heap
        
        minHeap.offer(maxHeap.poll()); // balancing step
 
        if(maxHeap.size() < minHeap.size()){ // maintain size property
            maxHeap.offer(minHeap.poll());
        }
    }
 
    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }
}

/*
Adding number 41
MaxHeap lo: [41]           // MaxHeap stores the largest value at the top (index 0)
MinHeap hi: []             // MinHeap stores the smallest value at the top (index 0)
Median is 41
=======================
Adding number 35
MaxHeap lo: [35]
MinHeap hi: [41]
Median is 38
=======================
Adding number 62
MaxHeap lo: [41, 35]
MinHeap hi: [62]
Median is 41
=======================
Adding number 4
MaxHeap lo: [35, 4]
MinHeap hi: [41, 62]
Median is 38
=======================
Adding number 97
MaxHeap lo: [41, 35, 4]
MinHeap hi: [62, 97]
Median is 41
=======================
Adding number 108
MaxHeap lo: [41, 35, 4]
MinHeap hi: [62, 97, 108]
Median is 51.5

*/
