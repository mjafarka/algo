package april;

public class FlattenBinaryTreeToLinkedList {

	TreeNode res;

	public void flatten(TreeNode root) {
		reverseInorder(root);

		root = res;
	}

//	private void reverseInorder(TreeNode root) {
//		if (root == null) {
//			return;
//		}
//
//		reverseInorder(root.right);
//
//		TreeNode temp = root.left;
//		if (res == null) {
//			root.left = null;
//			res = root;
//		} else {
////			res.right = root;
//
//			root.right = res;
//			res = root;
//			root.left = null;
//		}
//
//		reverseInorder(temp);
//	}
	
	
	private void reverseInorder(TreeNode root) {
		if (root == null) {
			return;
		}

		reverseInorder(root.left);

		TreeNode temp = root.right;
		if (res == null) {
			root.left = null;
			res = root;
		} else {
//			res.right = root;

			root.right = res;
			res = root;
			root.left = null;
		}

		reverseInorder(temp);
	}
}
