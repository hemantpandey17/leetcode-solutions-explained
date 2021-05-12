class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg_nodes = new int[numCourses]; // It will have count of courses that we have to do before course = index
        HashMap<Integer,List<Integer>> map = new HashMap<>(); // Map of node to list of children nodes
        
        
        for(int i=0 ; i<numCourses; i++) {
            map.put(i,new ArrayList<Integer>());
        }
        
        for(int[] edge:prerequisites) {
            indeg_nodes[edge[0]]++; // Indegree would determine, how many pre requisites does the course have
            map.get(edge[1]).add(edge[0]); // List of courses that appear after the course edge[1]
               
        }
        
        
        Queue<Integer> queue = new LinkedList<Integer>(); // Put only those courses for which no pre-requisite is required
        for(int i=0 ; i<indeg_nodes.length; i++) {
            if(indeg_nodes[i]==0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            visited++;
            
            for(int to:map.get(temp)) { 
                indeg_nodes[to]--;
                if(indeg_nodes[to]==0) {
                    queue.offer(to); // Put the courses in queue whose pre req are complete now
                }
            }
        }
        if(visited == numCourses)
            return true;
        else
            return false;
    }
}

/*

Dry run

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
             
Now indeg_nodes = [0,1] -> That means fro course 0 (at index 0), 0 prereqs are req and for course 1 at index 1, 1 pre req is reauired
list = {{1},{}} -> This means that for course 0- at index 0 is pre req for course 1 and course 1 at index 1 is pre req for no course

Queue  = [0] (Put all nodes with indeg 0)

poll 0, visited = 1
Now, all the elements at index 0 are processed and their indeg is decreased, anytime indegree is 0, add to queue
In the end we check if value of visited is equal to number or nodes or not.


*/
