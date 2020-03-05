package tree.threadedbinarytree;

public class HeroNode {

	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	// ���leftType==0���ʾָ�������������leftType==1 ���ʾָ��ǰ���ڵ�
	// ���rightType==0���ʾָ�������������rightType==1 ���ʾָ���̽ڵ�
	private int leftType;
	private int rightType;
	
	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

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
}
