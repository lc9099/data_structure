package tree.binarytree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		HeroNode root = new HeroNode(1, "�ν�");
		HeroNode node2 = new HeroNode(2, "����");
		HeroNode node3 = new HeroNode(3, "¬����");
		HeroNode node4 = new HeroNode(4, "�ֳ�");
		HeroNode node5 = new HeroNode(5, "��ʤ");
		
		
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
//			System.out.println("�ҵ���no = " + resNode.getNo() + " name = " + resNode.getName());
//		}else {
//			System.out.println("û���ҵ�" );
//		}
		
		tree.delNode(3);
		System.out.println("----------");
		tree.preOrder();
	}
}
