package may;

class Node {
	int left;
	int right;
	int sum;
	Node leftN;
	Node rightN;

	public Node(int left, int right) {
		this.left = left;
		this.right = right;
		leftN = null;
		rightN = null;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
}

class NumArray {
	Node root;

	public NumArray(int[] nums) {
		int left = 0;
		int right = nums.length;

		Node segT = new Node(left, right-1);

		dfs(nums, left, right, segT);

		root = segT;
	}

	private int dfs(int[] nums, int l, int r, Node segT) {

		if (Math.abs(l-r) == 1) {
			// Node last = new Node(l,r);
			segT.setSum(nums[l]);

			return nums[l];
		}

		int m = l + (r - l) / 2;

		Node left = new Node(l, m - 1);
		Node right = new Node(m, r-1);

		segT.leftN = left;
		segT.rightN = right;

		int leftS = dfs(nums, l, m, left);

		int rightS = dfs(nums, m, r, right);

		segT.setSum(leftS + rightS);

		return leftS + rightS;
	}

	public void update(int index, int val) {
		Node findNode = find(root, index);

		int diff = val - findNode.getSum();

		update(root, index, diff);
	}

	public int sumRange(int left, int right) {
		return sumRangeHelper(root, left, right);
	}

	private int sumRangeHelper(Node root, int left, int right) {
		if (root == null || root.right < left || root.left > right) {
			return 0;
		} else if (root.right <= right && root.left >= left) {
			return root.getSum();
		}

		return sumRangeHelper(root.leftN, left, right) + sumRangeHelper(root.rightN, left, right);
	}

	private void update(Node root, int idx, int diff) {
		if (root == null || idx < root.left || idx > root.right) {
			return;
		}

		root.setSum(root.getSum() + diff);

		update(root.leftN, idx, diff);
		update(root.rightN, idx, diff);
	}

	private Node find(Node root, int idx) {
		if (root == null || root.left == idx && root.right == idx) {
			return root;
		} else if (idx < root.left || idx > root.right) {
			return null;
		}

		Node left = find(root.leftN, idx);
		if (left != null) {
			return left;
		}
		Node right = find(root.rightN, idx);
		if (right != null) {
			return right;
		}

		return null;
	}
	
	public static void main(String[] args) {
		NumArray n = new NumArray(new int[] {1,3,5});
		
		n.update(1, 4);
		
		System.out.println(n.sumRange(1, 2));
		System.out.println(n.sumRange(0, 1));
		System.out.println(n.sumRange(0, 2));
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(index,val); int param_2 =
 * obj.sumRange(left,right);
 */