package may;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Minimum Domino Rotations For Equal Row
public class MaximumDominoesRotation {
	
	
	/**
	 * optimal solution.
	 * 
	 * find notes in goodnotes
	 * @param tops
	 * @param bottoms
	 * @return
	 */
	public int minDominoRotationsOptimal(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != Integer.MAX_VALUE) {
            return rotations;
        } else {
            rotations = check(bottoms[0], tops, bottoms);
            return rotations == Integer.MAX_VALUE ? -1 : rotations;
        }
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotationsTop = 0;
        int rotationsBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return Integer.MAX_VALUE; // impossible to make all values equal to target
            } else if (tops[i] != target) {
                rotationsTop++;
            } else if (bottoms[i] != target) {
                rotationsBottom++;
            }
        }

        return Math.min(rotationsTop, rotationsBottom);
    }
    
    
    /**
     * simpler but efficient, than all solution in leetcode
     * 
     * 
     */
    
    private int helper(int[] tops, int[] bottoms, int val) {
        int top_res = 0, bottom_res = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val && bottoms[i] != val) {
                return -1;
            } else if (tops[i] != val) {
                top_res++;
            } else if (bottoms[i] != val) {
                bottom_res++;
            }
        }
        return Math.min(top_res, bottom_res);
    }



    public int minDominoRotationsSimpler(int[] tops, int[] bottoms) {
        
        
        int ans = -1;
        for (int i = 1; i < 7; i++) {
            int cur_ans = helper(tops, bottoms, i);

            if (cur_ans != -1 && (ans == -1 || ans > cur_ans)) {
                ans = cur_ans;
            }
        }
        return ans;
    }
	
	/**
	 * sum optimal solution.
	 * 
	 * tc = O(n), but can be optimized further
	 * O(space) => O(1)
	 * @param tops
	 * @param bottoms
	 * @return
	 */
	public int minDominoRotations(int[] tops, int[] bottoms) {

		int res = Math.min(makeSame(tops, bottoms), makeSame(bottoms, tops));

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	/**
	 * tries to make the top same
	 */
	private int makeSame(int[] top, int[] bottom) {

		Set<Integer> topSet = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));

		int min = Integer.MAX_VALUE;

		for (int num : topSet) {

			int count = 0;
			for (int i = 0; i < top.length; i++) {
				if (top[i] != num) {
					if (bottom[i] == num) {
						count++;
					} else {
						count = Integer.MAX_VALUE;
						break;
					}
				}
			}

			min = Math.min(count, min);
		}

		return min;
	}
}
