package april;



//Inorder Sucessor

public class InorderSuccessor {
	
	private class Node {
	    int data;
	    Node left;
	    Node right;

	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

	
	/**
	 * brute force way is to do inorder traversal and print the next value after our required value.
	 * 
	 * below one utilizes the property of binary search tree
	 * @param root
	 * @param x
	 * @return
	 */
	
	public int inorderSuccessor(Node root, Node x) {
        // add code here.
        
        
        Node successor = null;
        
        while (root != null) {
            
            if (root.data > x.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return successor == null? -1 : successor.data;
    }
}
