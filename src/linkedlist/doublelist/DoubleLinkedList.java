package linkedlist.doublelist;

public class DoubleLinkedList {

	private HeroNode2 head = new HeroNode2(0, "", "");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	public void showList() {
		
		if (head.next == null) {
			System.out.println("����Ϊ��");
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
		boolean flag = false; // flag��־��ӵı���Ƿ���ڣ�Ĭ��false
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
			System.out.printf("׼�������Ӣ�۱��%d�Ѿ����ڣ��������\n", heroNode.no);
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
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
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
		
		HeroNode2 temp = head.next;
		boolean flag = false; // �Ƿ��ҵ���ɾ���ڵ��ǰһ���ڵ�
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
			System.out.printf("Ҫɾ����%d��Ų�����\n", no);
		}
	}
	
}
