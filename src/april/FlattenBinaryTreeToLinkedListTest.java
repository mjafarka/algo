package april;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FlattenBinaryTreeToLinkedListTest {

	FlattenBinaryTreeToLinkedList flattener = new FlattenBinaryTreeToLinkedList();

	@Test
	void testFlattenSimpleTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		flattener.flatten(root);

		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
		assertEquals(expected, getFlattenedList(root));
	}

	@Test
	void testFlattenSingleNode() {
		TreeNode root = new TreeNode(1);
		flattener.flatten(root);
		List<Integer> expected = Arrays.asList(1);
		assertEquals(expected, getFlattenedList(root));
	}

	@Test
	void testFlattenEmptyTree() {
		TreeNode root = null;
		flattener.flatten(root);
		assertNull(root);
	}

	@Test
	void testFlattenLeftSkewedTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);

		flattener.flatten(root);

		List<Integer> expected = Arrays.asList(1, 2, 3);
		assertEquals(expected, getFlattenedList(root));
	}

	@Test
	void testFlattenRightSkewedTree() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);

		flattener.flatten(root);

		List<Integer> expected = Arrays.asList(1, 2, 3);
		assertEquals(expected, getFlattenedList(root));
	}

	// Helper to collect the values from the flattened list
	private List<Integer> getFlattenedList(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		while (root != null) {
			result.add(root.val);
			if (root.left != null) {
				throw new AssertionError("Left child should be null in the flattened tree");
			}
			root = root.right;
		}
		return result;
	}
}
