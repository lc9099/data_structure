package linkedlist.singlelist;

public class SingleLinkedList {

	// ��ʼ��ͷ�ڵ�
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
		boolean flag = false; // flag��־��ӵı���Ƿ���ڣ�Ĭ��false
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
			System.out.printf("׼�������Ӣ�۱��%d�Ѿ����ڣ��������\n", heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	
	public void updateInfo(HeroNode herohead) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false; // ��ʾ�Ƿ��ҵ��ýڵ�
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
			System.out.printf("û���ҵ����%d�Ľڵ�\n", herohead.no);
		}
	}
	
	public void delHero(int no) {
		if(head.next == null) {
			System.out.println("����Ϊ�գ�����ɾ��");
		}
		
		HeroNode temp = head;
		boolean flag = false; // �Ƿ��ҵ���ɾ���ڵ��ǰһ���ڵ�
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
			System.out.printf("Ҫɾ����%d��Ų�����\n", no);
		}
	}

	public void showList() {
		
		if (head.next == null) {
			System.out.println("����Ϊ��");
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
