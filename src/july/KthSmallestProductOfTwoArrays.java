package july;

// Kth Smallest Product of Two Sorted Arrays
public class KthSmallestProductOfTwoArrays {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countProductsLessEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private long countProductsLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                // binary search for max b in nums2 where a * b <= x
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                count += l;
            } else if (a < 0) {
                // binary search for min b in nums2 where a * b <= x
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - l;
            } else {
                if (x >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
}
