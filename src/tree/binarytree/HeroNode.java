package tree.binarytree;

public class HeroNode {

	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	public void preOrder() {
		System.out.println(this);
		
		if(this.left != null) {
			this.left.preOrder();
		}
		
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	public void midOrder() {
		
		if(this.left != null) {
			this.left.midOrder();
		}
		
		System.out.println(this);
		
		if(this.right != null) {
			this.right.midOrder();
		}
	}
	
	public void postOrder() {
		
		if(this.left != null) {
			this.left.postOrder();
		}
		
		if(this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);
	}
	
	public HeroNode searchByPre(int no) {
		
		if (this.no == no) {
			return this;
		}
		HeroNode curNode = null; 
		if(this.left != null) {
			curNode = this.left.searchByPre(no);
		}
		if(curNode != null) {
			return curNode;
		}
		
		if(this.right != null) {
			curNode = this.right.searchByPre(no);
		}
		return curNode;
		
	}
	
	
	public HeroNode searchBymid(int no) {
		
		HeroNode curNode = null; 
		if(this.left != null) {
			curNode = this.left.searchBymid(no);
		}
		if(curNode != null) {
			return curNode;
		}
		
		if (this.no == no) {
			return this;
		}
		
		if(this.right != null) {
			curNode = this.right.searchBymid(no);
		}
		return curNode;
		
	}
	
	public HeroNode searchBypost(int no) {
		
		HeroNode curNode = null; 
		if(this.left != null) {
			curNode = this.left.searchBypost(no);
		}
		if(curNode != null) {
			return curNode;
		}

		if(this.right != null) {
			curNode = this.right.searchBypost(no);
		}
		if(curNode != null) {
			return curNode;
		}
		
		if (this.no == no) {
			return this;
		}
		return curNode;

	}
	
	
	public void delNode(int no) {
		
		if(this.left != null && this.left.no == no){
			this.left = null;
			return;
		}
		
		if(this.right != null && this.right.no == no){
			this.right = null;
			return;
		}
		
		if(this.left != null) {
			this.left.delNode(no);
		}
		
		if(this.right != null) {
			this.right.delNode(no);
		}

	}
	
}
