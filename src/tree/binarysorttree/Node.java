package tree.binarysorttree;

public class Node {

	int val;
	Node left;
	Node right;

	public Node(int val) {
		super();
		this.val = val;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}

		if (node.val < this.val) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}

	public void orderByInfix() {
		if (this.left != null) {
			this.left.orderByInfix();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.orderByInfix();
		}
	}

	public Node searchTargetNode(int val) {
		if (val == this.val) {
			return this;
		} else if (val < this.val) {
			if (this.left == null) {
				return null;
			}
			return this.left.searchTargetNode(val);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.searchTargetNode(val);
		}
	}

	public Node searchParentNode(int val) {

		if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
			return this;
		} else {
			if (val < this.val && this.left != null) {
				return this.left.searchParentNode(val);
			} else if (val >= this.val && this.right != null) {
				return this.right.searchParentNode(val);
			}else {
				return null;
			}
		}
	}

}
