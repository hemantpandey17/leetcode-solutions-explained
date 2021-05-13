public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        
         int rows = matrix.length;
         int cols= matrix[0].length;
         
         PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
         
         for(int i=0; i<rows;i++) {
             for(int j=0;j<cols;j++) {
                 queue.offer(matrix[i][j]);
                  
             }
        }
             
         for(int i=1;i < k ;i++) {
             queue.poll();
         }
           System.out.println(queue);
        return queue.peek();
    }
}
