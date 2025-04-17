package april;



// SEGMENT TREE

/**
 * update tc = log(n) for 1 update
 * construct = O(n) or O(2*n-1)
 * query = log(n)
 * 
 * ""use the array implementation if the fewer updates are present. in that method, the query time is O(1)""
 */
public class NumArray {

	int[] st;
	int[] nums;

	public NumArray(int[] nums) {
		int n = nums.length;
		this.nums = nums;
		// roughly 4 * n size is needed for most of the arrays.
		st = new int[4 * n];              // smallest power of 2 such that it should be >= (2*n - 1),    (2*n - 1) nodes will be present in the tree.
										  // n leaf nodes and (n-1) internal nodes. SHOULD BE CHECKED FOR "FBT"
		construct(0, st, nums, 0, n - 1);
	}

	private int construct(int si, int[] st, int[] nums, int left, int right) {
		if (left == right) {
			st[si] = nums[left];
			return nums[left];
		}

		int m = left + (right - left) / 2;

		st[si] = construct(2 * si + 1, st, nums, left, m) + construct(2 * si + 2, st, nums, m + 1, right);

		return st[si];

	}

	public void update(int index, int val) {

		int n = nums.length;

		int diff = val - nums[index];
		nums[index] = val;

		updateSt(0, 0, n - 1, index, diff);
	}

	private void updateSt(int si, int sl, int sr, int pos, int diff) {
		if (sl > pos || sr < pos) {
			return;
		}

		st[si] += diff;

		if (sl != sr) {

			int mid = (sl + sr) / 2;

			updateSt(2 * si + 1, sl, mid, pos, diff);

			updateSt(2 * si + 2, mid + 1, sr, pos, diff);
		}

	}

	public int sumRange(int left, int right) {

		int n = nums.length;

		return rangeSumQ(0, 0, n - 1, left, right);
	}

	private int rangeSumQ(int si, int sl, int sr, int l, int r) {
		if (l <= sl && r >= sr) {
			return st[si]; // -------------- full overlap
		}

		if (sr < l || sl > r) {
			return 0;// ----------------------- no overlap
		}

		int mid = (sl + sr) / 2;

		return rangeSumQ(2 * si + 1, sl, mid, l, r) + rangeSumQ(2 * si + 2, mid + 1, sr, l, r); // ------------- partial
																								// overlap
	}

	public static void main(String[] args) {
		NumArray na = new NumArray(new int[] { 1, 3, 5 });

		System.out.println(na.sumRange(0, 2));

		na.update(1, 2);

		System.out.println(na.sumRange(0, 2));

	}
}
