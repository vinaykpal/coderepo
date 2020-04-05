package binaryTreeQues;

public class IsBinTreeBST {
	
	/**
	 * Check if Binary Tree is Binary Search Tree
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean isBST(TreeNode root, int min, int max ) {
		if(root == null){
			//System.out.println("IsBST: true");
			return true;
		}
		
		if((root.val <= min) ||(root.val > max)) {
			//System.out.println("IsBST: false");
			return false;
		}
		
		return isBST(root.left, min, root.val ) && isBST(root.right, root.val, max);
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("In package: bin tree: IsBST");
		
		BuildBinaryTree bt= new BuildBinaryTree(5);
		bt.add(4);
		bt.add(7);
		bt.add(1);
		bt.add(9);
		bt.add(11);
		/**
		 * print Tree in Breadth First Search
		 * In Order
		 * Pre Order
		 * Post Order
		 */
		bt.printBinTree();
		
		System.out.println("isBST return: " + isBST(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
