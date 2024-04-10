/**
 * 
 * @author Nabil El-Hage
 * @assignment 5
 * 
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	protected TreeNode<String> root = null;
	protected String lastLetter;
	
	public MorseCodeTree(){
		buildTree();
	}
	
	/**
	 * Inserts new node
	 * @param String code
	 * @param String letter
	 */
	@Override
	public void insert(String code, String letter){
		this.addNode(this.root, code, letter.toLowerCase());
		
	}

	/**
	 * Adds new node
	 * @param TreeNode<String> node
	 * @param String code
	 * @param String letter
	 */
	@Override
	public void addNode(TreeNode<String> node, String code, String letter){
		TreeNode<String> newNode = new TreeNode<String>(letter);
		
		if (code.length() == 1){
			if (code.equals(".")){
				node.setLeft(newNode);
			}else{
				node.setRight(newNode);
			}
		}else if (code.substring(0, 1).equals(".")){
			this.addNode(node.getLeft(), code.substring(1), letter);
		}else{
			this.addNode(node.getRight(), code.substring(1), letter);
		}
	}
	
	/**
	 * Get the Root node
	 * @return TreeNode<String> root
	 */
	@Override
	public TreeNode<String> getRoot(){
		return this.root;
	}	

	/**
	 * Sets Root node
	 * @param Node new nod
	 */
	@Override
	public void setRoot(TreeNode<String> node){
		this.root = node;		
	}
	
	/**
	 * Fetches node given a code
	 * @param String code
	 * @return String data
	 */
	@Override
	public String fetch(String code){
		return this.fetchNode(this.root, code);
	}

	/**
	 * 
	 * @param TreeNode<String> node
	 * @param String code
	 * @return lastLetter
	 */
	@Override
	public String fetchNode(TreeNode<String> node, String code){
		if (code.length() == 1){
			this.lastLetter = code.equals(".") ? node.getLeft().getData() : node.getRight().getData();
		}else{
			if(code.substring(0, 1).equals(".")){
				this.fetchNode(node.getLeft(), code.substring(1));
			}else{
				this.fetchNode(node.getRight(), code.substring(1));
			}
		}
		return this.lastLetter;
	}

	/**
	 * Converts tree to an ArrayList
	 * @return ArrayList<String> sorted list
	 */
	@Override
	public java.util.ArrayList<String> toArrayList(){
		java.util.ArrayList<String> list = new java.util.ArrayList<String>();
		this.LNRoutputTraversal(this.root, list);
		
		return list;
	}

	/**
	 * Translate's tree to correct letter values
	 */
	@Override
	public void buildTree() {
		this.root = new TreeNode<String>("");
		
		//MorseCode Translations to Letters
		this.insert(".", "e");
		this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
	}
	
	/**
	 * Sort's tree
	 * @param TreeNode<String> node
	 * @param ArrayList<String> list
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> node, java.util.ArrayList<String> list) {
		if (node == null){
			return; 
			}
		this.LNRoutputTraversal(node.getLeft(), list);
		list.add(node.getData());
		this.LNRoutputTraversal(node.getRight(), list);
	}
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported Operation");
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported Operation");
	}
}