package linkedlist.singlelist;

public class SingleLinkedList {

	// 初始化头节点
	private HeroNode head = new HeroNode(0, "", "");
	
	public HeroNode getHead() {
		return head;
	}
	
	public void addToEnd (HeroNode heroNode) {
		HeroNode temp = head;
		while(true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;	
		}
		temp.next = heroNode;
	}
	
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false; // flag标志添加的编号是否存在，默认false
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.out.printf("准备插入的英雄编号%d已经存在，不能添加\n", heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	
	public void updateInfo(HeroNode herohead) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false; // 表示是否找到该节点
		while(true) {
			if(temp == null) {
				break;
			}
			if(herohead.no == temp.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = herohead.name;
			temp.nickName = herohead.nickName;
		}else {
			System.out.printf("没有找到编号%d的节点\n", herohead.no);
		}
	}
	
	public void delHero(int no) {
		if(head.next == null) {
			System.out.println("链表为空，不能删除");
		}
		
		HeroNode temp = head;
		boolean flag = false; // 是否找到待删除节点的前一个节点
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除的%d编号不存在\n", no);
		}
	}

	public void showList() {
		
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
	
	
}
