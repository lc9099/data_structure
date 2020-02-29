package linkedlist.doublelist;

public class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	public void showList() {
		
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
		while(true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
		
	}

	public void addToEnd (HeroNode2 heroNode) {
		HeroNode2 temp = head;
		while(true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;	
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	public void addByOrder(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		boolean flag = false; // flag标志添加的编号是否存在，默认false
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (heroNode.no < temp.next.no) {
				break;
			}else if(temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.out.printf("准备插入的英雄编号%d已经存在，不能添加\n", heroNode.no);
		}else {
			
			if(temp.next != null) {
				heroNode.next = temp.next;
				temp.next.pre = heroNode;
			}
			temp.next = heroNode;
			heroNode.pre = temp;

		}
		
	}
	
	public void updateInfo(HeroNode2 herohead) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
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
		
		HeroNode2 temp = head.next;
		boolean flag = false; // 是否找到待删除节点的前一个节点
		while(true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.pre.next = temp.next;
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
		}else {
			System.out.printf("要删除的%d编号不存在\n", no);
		}
	}
	
}
