package tree.arrbinarytree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree tree = new ArrBinaryTree(arr);
		tree.postOrder();
	}
}
