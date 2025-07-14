package may;

import java.util.List;
import java.util.ArrayList;


//Total Characters in String After Transformations II
//goodnotes
public class Solution {

	public long goodTriplets(int[] nums1, int[] nums2) {
        
        int n = nums2.length;
        int[] indexMap2 = new int[nums2.length];

        for (int i = 0 ; i < nums2.length ; i++) {
            indexMap2[nums2[i]] = i;
        }

        int[] segTree = new int[4*n+1];

        int firstElemIdx = indexMap2[nums1[0]];

        int m = 4*n + 1;
        update(1,0, n -1, firstElemIdx, segTree);

        int res = 0;

        for (int i =1 ; i < n ; i++) {
            int index2 = indexMap2[nums1[i]];

            int commonLeft = rangeSumQuery(1,0,n-1,0,index2,segTree);

            int uncommonLeft = index2 - commonLeft;

            int rightSize = n - index2 - 1;

            int commonRight = (rightSize - commonLeft);

            res += (commonLeft * commonRight);

            update(1,0,n-1,index2,segTree);
        }

        return res;
    }

    private int rangeSumQuery(int pos, int s, int e, int qs, int qe,int[] segTree) {
        if (qs > e || qe < s) {
            return 0;
        }

        if (qs <= s && qe >= e) {
            return segTree[pos];
        }

        int m = s + (e-s) / 2;

        return rangeSumQuery(pos*2, s , m, qs,qe, segTree) + rangeSumQuery(pos*2 + 1, m + 1, e, qs,qe,segTree);
    }

    private int update(int pos, int s, int e, int index, int[] segTree) {
        if (s == index && e == index) {
            segTree[pos]++;
            return segTree[pos];
        }

        if (index < s || index > e) {
            return segTree[pos];
        }

        int m = s + (e-s) / 2;

        segTree[pos] = update(pos*2, s,m,index,segTree) + update(pos * 2 + 1, m + 1, e, index, segTree);

        return segTree[pos];
    }

    public static void main(String[] args
    ) {

        Solution s = new Solution();
        int n =4;
        int[] seg = new int[n*4+1];

        s.update(1,0,n-1,2,seg);

        System.out.println("rangeSumQuery="+s.rangeSumQuery(1,0,n-1,0,3,seg));

		s.update(1, 0, n-1, 0, seg);

		System.out.println("rangeSumQuery="+s.rangeSumQuery(1,0,n-1,0,2,seg));

		s.update(1, 0, n-1, 3, seg);

		System.out.println("rangeSumQuery="+s.rangeSumQuery(1,0,n-1,0,2,seg));
    }
}
