package linkedlist.doublelist;

public class HeroNode2 {

	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 pre;
	

	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	// 为了显示方便，重写toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
	
	
}
