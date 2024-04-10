/**
 * 
 * @author Nabil El-Hage
 * @assignment 5
 * 
 */

public class TreeNode<T> {
	protected T data = null;
	protected TreeNode<T> left = null;
	protected TreeNode<T> right = null;
	
	public TreeNode(T d) {
		this.data = d;
	}

	public TreeNode(TreeNode<T> node) {
		this.data = node.getData();
	}
	
	/**
	 * Sets the left node
	 * @param TreeNode<T> node
	 */
	public void setLeft(TreeNode<T> node) {
		this.left = node;
	}
	
	/**
	 * Sets the right node
	 * @param TreeNode<T> node
	 */
	public void setRight(TreeNode<T> node) {
		this.right = node;
	}
	
	/**
	 * Retrieves node data
	 * @return data
	 */
	public T getData() {
		return this.data;
	}
	
	/**
	 * Retrieve left node data
	 * @return TreeNode<T> left node
	 */
	public TreeNode<T> getLeft() {
		return this.left;
	}
	
	/**
	 * Retrieve right node data
	 * @return TreeNode<T> right node
	 */	
	public TreeNode<T> getRight() {
		return this.right;
	}
}