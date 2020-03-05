package tree.threadedbinarytree;

public class ThreadedBinaryTree {

	private HeroNode root;
	private HeroNode pre;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void threadedListByMid() {
		
		HeroNode node = root;
		while (node != null) {
			
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
		
	}
	
	public void threadedNodeByMid() {
		threadedNodeByMid(this.root);
	}
	
	public void threadedNodeByMid(HeroNode node) {
		
		if (node == null) {
			return;
		}
		
		threadedNodeByMid(node.getLeft());
		
		if(node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
		
		threadedNodeByMid(node.getRight());
	}
	
	
	public void threadedListByPre() {
		
		HeroNode node = root;
		while (node != null) {
			while(node.getLeftType() == 0) {
				System.out.println(node);
				node = node.getLeft();
			}	
			System.out.println(node);
			node = node.getRight();
		}
		
	}
	
	public void threadedNodeByPre() {
		threadedNodeByPre(this.root);
	}
	
	public void threadedNodeByPre(HeroNode node) {
		
		if (node == null) {
			return;
		}

		if(node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}		
		pre = node;
		
		if (node.getLeftType() == 0) {
			threadedNodeByPre(node.getLeft());
		}
		if(node.getRightType() == 0) {
			threadedNodeByPre(node.getRight());
		}
		
	}
	
}
