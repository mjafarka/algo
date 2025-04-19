package april;

public class CountGoodTripletsInAnArray {
	public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] indeces = new int[n];

        for (int i = 0 ; i < nums2.length ; i++ ) {
            indeces[nums2[i]] = i; // nums2 at which index
        }

        int count = 0;

        for (int i = 0 ; i < n - 2 ; i++ ) {
            for (int j = i + 1 ; j < n  - 1; j++ ) {
//                if (indeces[nums1[i]] < indeces[nums1[j]])
                for (int k = j + 1 ; k < n ; k++) {
                    if (indeces[nums1[i]] < indeces[nums1[j]] && indeces[nums1[j]] < indeces[nums1[k]]) {
                        count ++;
                    }
                }
            }
        }

        return count;

        // return 1;
    }
	
	
	// test case 103 passed
	public long goodTriplets2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] indeces = new int[n];

        for (int i = 0 ; i < nums2.length ; i++ ) {
            indeces[nums2[i]] = i; // nums2 at which index
        }

        int count = 0;

        for (int i = 0 ; i < n - 2 ; i++ ) {
            for (int j = i + 1 ; j < n  - 1; j++ ) {
//                if (indeces[nums1[i]] < indeces[nums1[j]])
                for (int k = j + 1 ; k < n ; k++) {
                    if (indeces[nums1[i]] < indeces[nums1[j]] && indeces[nums1[j]] < indeces[nums1[k]]) {
                        count ++;
                    }
                }
            }
        }

        return count;

        // return 1;
    }
}
