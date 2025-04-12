package april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utilities.PrintUtility;

public class CombinationSum2 {
	
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(candidates);
		backtrack(0,0,candidates,target, new ArrayList<>(), result);
		
		
		return result;
	}
	
	private void backtrack(int i,int curSum,  int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
		if (curSum == target) {
			result.add(new ArrayList<>(comb));
			return;
		}
		
		else if (curSum > target) {
			return;
		}
		
		
		for (int j = i ; j < candidates.length ; j ++ ) {
			
			comb.add(candidates[j]);
			backtrack(j+1,curSum + candidates[j],candidates, target, comb, result);
			comb.remove(comb.size()-1);
			
			
			while (j + 1 < candidates.length && candidates[j + 1] == candidates[j]) 
				j ++;
			
//			System.out.println("hello");
			
			
		}
	}
	
	public static void main(String[] args) {
		
		CombinationSum2 cmb = new CombinationSum2();
		int[] candidates = new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		int target = 27;
		
		List<List<Integer>> result = cmb.combinationSum2(candidates, target);
		
		PrintUtility p = new PrintUtility();
		
		p.print2DList(result);
		
	}
}
