public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
     
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    backtrack(list, temp, nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) 
    {
         //System.out.println("Remain is now less than 0 ");
        return;
    }
    else if(remain == 0)
    {
        list.add(new ArrayList<>(tempList));
        //System.out.println("The result till now is : " + list);
        
    }
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
           // System.out.println(tempList);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            //System.out.println("Removing the last element now for backtracking ");
            tempList.remove(tempList.size() - 1);
        }
    }
}
    }
