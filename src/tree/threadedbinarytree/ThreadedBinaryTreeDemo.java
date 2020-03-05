package tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		
		HeroNode root = new HeroNode(1,"tom");
		HeroNode node2 = new HeroNode(3,"jack");
		HeroNode node3 = new HeroNode(6,"smith");
		HeroNode node4 = new HeroNode(8,"mary");
		HeroNode node5 = new HeroNode(10,"king");
		HeroNode node6 = new HeroNode(14,"ding");
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.setRoot(root);
		tree.threadedNodeByPre();
		HeroNode left = node2.getLeft();
		System.out.println(left);
		HeroNode right = node2.getRight();
		System.out.println(right);
		
		System.out.println("-----------");
		tree.threadedListByPre();
	}
}
