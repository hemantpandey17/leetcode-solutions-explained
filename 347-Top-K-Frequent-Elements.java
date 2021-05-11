/*public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // List of integer array
        List<Integer>[] bucket = new List[nums.length - 1];
        
        // HashMap which stores of array with its frequency
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        // Result list 
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length==0) {
         return result;   
        }
        
        // For each element in array, make a map of element along with its count
        for(int i=0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            }
            else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        System.out.println(map);
        
        // For all keys in map 
         for(int key:map.keySet()) {
             // frequency of particular key
             int freq = map.get(key);
             System.out.println(freq);
             System.out.println(Arrays.toString(bucket));
             if(bucket[freq]==null) {
                 bucket[freq] = new ArrayList<Integer>();
             }
             // Add the key to index associated with frequency in bucket array
             bucket[freq].add(key);
             System.out.println(Arrays.toString(bucket));
         }
         // For end to start, if index is not null, then add to list
        for(int i = bucket.length - 1; i>=0 && result.size() < k; i--) {
            if(bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        return result;
    }
}*/

public class Solution {
public List<Integer> topKFrequent(int[] nums, int k) {
    // This array will be having the lists which contains the element having frequence count equal to index of list
    // eg : [1,1,1,2,2,3]
    // The frequency map : {1=3, 2=2, 3=1}
    // Now, bucket[3] will have list as [1] and bucket[2] will have list as [2]
    // Bucket array is : [null, [3], [2], [1], null, null, null]
    // Now, we traverse the array bucket from end and keep adding all elements in a result list till size of result list reaches        k
    
	List<Integer>[] bucket = new List[nums.length + 1];
    
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}
    
    System.out.println("The frequency map : " + frequencyMap);
    
	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}
    
    System.out.println("Bucket array is : " + Arrays.toString(bucket));
    
	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res;
}
}
