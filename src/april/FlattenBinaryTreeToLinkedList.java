package april;

public class FlattenBinaryTreeToLinkedList {
	
	/**
	 * NOTES
	 * in the question they mentioned the linked list will be the PRE_ORDER traversal of the binary tree, hence we can just do the preorder traversal to get the answer
	 */

	TreeNode res = new TreeNode();

	public void flatten(TreeNode root) {
		
		TreeNode resDup = res;
		preOrder(root);

		root = resDup.right;
	}

	
	private void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		TreeNode tempLeft = root.left;
		TreeNode tempRight = root.right;
		
		res.right = root;
		root.left = null;
		res = root;
		
		preOrder(tempLeft);
		
		preOrder(tempRight);
	}
}
