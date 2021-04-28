public class Solution  
{
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
		combine(combs, temp, 1, n, k);
		return combs;
	}
	public static void combine(List<List<Integer>> combs, List<Integer> temp, int start, int n, int k) {
		if(k==0) {
			combs.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=start;i<=n;i++) {
			temp.add(i);
			combine(combs, temp, i+1, n, k-1);
			temp.remove(temp.size()-1);
		}
	}
}
