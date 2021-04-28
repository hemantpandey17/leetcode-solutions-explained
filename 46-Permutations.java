class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(res, temp, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        else {
            for(int i=0; i<nums.length; i++) {
                if(temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                helper(res,temp,nums);
                temp.remove((temp.size()-1)); 
                }

            }
        return;
        }
    }


/*

public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 


*/
