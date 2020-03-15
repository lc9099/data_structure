package tree.binarysorttree;

public class BinarySortTreeDemo {

	public static void main(String[] args) {

		int[] arr = { 7, 3, 10, 12, 5, 1, 9 };
		BinarySortTree binarySortTree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}

		binarySortTree.ordreByInfix();
	}
}
