package may;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Minimum Domino Rotations For Equal Row
public class MaximumDominoesRotation {

    //last my solution , easy to understand and optimal
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topSame = minRotation(tops,bottoms);

        if (topSame == Integer.MAX_VALUE) {
            int bottomSame = minRotation(bottoms,tops);

            if (bottomSame == Integer.MAX_VALUE) {
                return -1;
            } else {
                return bottomSame;
            }
        }

        return topSame;
    }

    private int minRotation(int[] tops, int[] bottoms) {

        int topSame = 0;

        int numCntBottom = bottoms[0] == tops[0] ? 1 : 0;

        for (int i = 1 ; i < tops.length ; i++ ) {
            if (tops[i] != tops[0]) {
                if (bottoms[i] != tops[0]) {
                    return Integer.MAX_VALUE;
                } else {
                    topSame ++;
                }
            } 

            if (bottoms[i] == tops[0])  {
                numCntBottom += 1;
            }
        }

        int bottSame = tops.length - numCntBottom;

        return Math.min(bottSame,topSame);
    }
	
	
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
	
	
}
