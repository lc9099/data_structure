package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {

	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node node = createHuffmanTree(arr);
		preOrder(node);

	}

	
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("ЙўЗђТќЪїЮЊПе");
		}
	}
	
	public static Node createHuffmanTree(int[] arr) {

		List<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		while (nodes.size() > 1) {
			Collections.sort(nodes);

			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);

			Node parentNode = new Node(leftNode.value + rightNode.value);
			parentNode.left = leftNode;
			parentNode.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
		}
		
		return nodes.get(0);

	}
}
