package tree.binarytree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		HeroNode root = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "吴用");
		HeroNode node3 = new HeroNode(3, "卢俊义");
		HeroNode node4 = new HeroNode(4, "林冲");
		HeroNode node5 = new HeroNode(5, "关胜");
		
		
		tree.setRoot(root);
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		
		tree.preOrder();
//		tree.midOrder();
//		tree.postOrder();
		
//		HeroNode resNode = tree.searchBypre(7);
//		if(resNode != null) {
//			System.out.println("找到了no = " + resNode.getNo() + " name = " + resNode.getName());
//		}else {
//			System.out.println("没有找到" );
//		}
		
		tree.delNode(3);
		System.out.println("----------");
		tree.preOrder();
	}
}
