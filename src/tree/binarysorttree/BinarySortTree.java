package tree.binarysorttree;

public class BinarySortTree {

	private Node root;

	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	public void ordreByInfix() {
		if (root != null) {
			root.orderByInfix();
		} else {
			System.out.println("¶þ²æÅÅÐòÊ÷Îª¿Õ¡£");
		}
	}

	public Node searchTargetNode(int val) {
		if (root == null) {
			return root;
		} else {
			return root.searchTargetNode(val);
		}
	}

	public Node searchParentNode(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchParentNode(val);
		}
	}

	public int delRightTreeMin(Node node) {

		Node target = node;
		while (target.left != null) {
			target = target.left;
		}

		delNode(target.val);
		return target.val;
	}

	public void delNode(int val) {
		if (root == null) {
			return;
		} else {

			Node targetNode = searchTargetNode(val);
			if (targetNode == null) {
				return;
			}

			if (root.left == null && root.right == null) {
				root = null;
				return;
			}

			Node parentNode = searchParentNode(val);
			if (targetNode.left == null && targetNode.right == null) {

				if (parentNode.left != null && parentNode.left.val == val) {
					parentNode.left = null;
				} else if (parentNode.right != null && parentNode.right.val == val) {
					parentNode.right = null;
				}

			} else if (targetNode.left != null && targetNode.right != null) {

				int min = delRightTreeMin(targetNode.right);
				targetNode.val = min;

			} else {

				if (targetNode.left != null) {
					if (parentNode != null) {
						if (parentNode.left.val == val) {
							parentNode.left = targetNode.left;
						} else {
							parentNode.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}

				} else {
					if (parentNode != null) {
						if (parentNode.left.val == val) {
							parentNode.left = targetNode.right;
						} else {
							parentNode.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}
		}
	}

}
