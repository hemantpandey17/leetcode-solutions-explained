public class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<arr.length-2 ;i++) {
             
            if(i==0 || arr[i] > arr[i-1] ) {      // Avoiding duplicates coz they don't make any difference
                int start = i+1;
                int end = arr.length-1;
                while(start < end) {
                    if(arr[i] + arr[start] + arr[end] == 0) {
                        result.add(Arrays.asList(arr[i],arr[start],arr[end]));
                    }
                    if(arr[i] + arr[start] + arr[end] < 0) {
                        int curr_start = start;
                        while(arr[start]==arr[curr_start] && start < end) { // avoiding duplicates i.e if the previous value is same
                            start++;                                        // keep incrementing start i.e arr[start] == arr[curr_start] will
                        }                                                   // always be true once, we increment start, now the arr[start]                                                                               // is the next element. We will keep updating start till it is                                                                               // equal to the arr[curr_start].
                    }
                    else {
                        int curr_end = end;
                        while(arr[end] == arr[curr_end] && start < end) {  // Similar as above
                            end--;
                        }
                    }
                }
                
            }
        }
        
        return result;
        
    }
}
