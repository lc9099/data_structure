package tree.binarytree;

public class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	
	public void midOrder() {
		if(this.root != null) {
			this.root.midOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	
	public HeroNode searchBypre(int no) {
		if(this.root != null) {
			return this.root.searchByPre(no);
		}else {
			return null;
		}
	}
	
	public HeroNode searchBymid(int no) {
		if(this.root != null) {
			return this.root.searchBymid(no);
		}else {
			return null;
		}
	}
	
	public HeroNode searchBypost(int no) {
		if(this.root != null) {
			return this.root.searchBypost(no);
		}else {
			return null;
		}
	}
	
	
	public void delNode(int no) {
		if(this.root != null) {
			if(root.getNo() == no) {
				root = null;
			}else {
				this.root.delNode(no);
			}

		}else {
			System.out.println("空树，不能删除");
		}
	}
	
}
