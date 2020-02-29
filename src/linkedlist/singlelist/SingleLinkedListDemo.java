package linkedlist.singlelist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		
		HeroNode hero2 = new HeroNode(2, "�ν�", "��ʱ��");
		HeroNode hero4 = new HeroNode(4, "¬����", "������");
		HeroNode hero5 = new HeroNode(5, "����", "�Ƕ���");
		HeroNode hero7 = new HeroNode(7, "�ֳ�", "����ͷ");
		// ��������
		SingleLinkedList list = new SingleLinkedList();
		// ��ӽڵ�
		list.addByOrder(hero2);
		list.addByOrder(hero4);
		list.addByOrder(hero5);
		list.addByOrder(hero7);
		
		// ����������������ĺϲ�
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero3 = new HeroNode(3, "¬����", "������");
		HeroNode hero6 = new HeroNode(6, "����", "�Ƕ���");
		HeroNode hero9 = new HeroNode(9, "�ֳ�", "����ͷ");
		SingleLinkedList list2 = new SingleLinkedList();
		list2.addByOrder(hero1);
		list2.addByOrder(hero3);
		list2.addByOrder(hero6);
		list2.addByOrder(hero9);
		
		// ���½ڵ���Ϣ
		HeroNode heroNode = new HeroNode(2, "С¬", "������~~~");
		list.updateInfo(heroNode);
		// ɾ���ڵ�
		list.delHero(3);
		// ��ȡ�ڵ����
		System.out.println("�ڵ������" + getLength(list.getHead()));
		// ��ȡ������2���ڵ�
		HeroNode node = findLastIndexNode(list.getHead(), 1);
		System.out.println(node);
		// ������ת
		// reverseList(list.getHead());
		// �����ӡ����ڵ㣬���ܸı�ԭ����ṹ
		reversePrint(list.getHead());
		// ��ʾ����
		System.out.println("-----------------");
		list.showList();
		
		// �ϲ��������������ϳɺ���Ȼ����
		System.out.println("-----------------");
		HeroNode newHead = mergeTwoList(list.getHead(), list2.getHead());
		while(true) {
			if (newHead == null) {
				break;
			}
			System.out.println(newHead);
			newHead = newHead.next;
		}
		
	}
	
	public static HeroNode mergeTwoList(HeroNode head1, HeroNode head2) {
		
		HeroNode tempHead = new HeroNode(0, "", "");
		HeroNode cur = tempHead;
		HeroNode temp1 = head1.next;
		HeroNode temp2 = head2.next;
		
		while(temp1 != null && temp2 != null) {
			
			if(temp1.no < temp2.no) {
				cur.next = temp1;
				cur = cur.next;
				temp1 = temp1.next;
				
			}else {
				cur.next = temp2;
				cur = cur.next;
				temp2 = temp2.next;
			}
		}
		if (temp1 == null){
			cur.next = temp2;
		}else {
			cur.next = temp1;
		}
		return tempHead.next;
	}
	
	public static void reversePrint(HeroNode head) {
		if (head.next == null){
			return ;
		}
		
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
	}
	
	public static void reverseList(HeroNode head) {
		if (head.next == null || head.next.next == null){
			return ;
		}
		
		HeroNode reverseHead = new HeroNode(0, "", "");
		HeroNode cur = head.next;
		HeroNode next = null;
		while(cur != null) {
			next = cur.next;
			// ͷ��
			cur.next = reverseHead.next;
			reverseHead.next  = cur;
			
			cur = next;
		}
		head.next = reverseHead.next;
		
	}
	
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode temp = head.next;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if (head.next == null) {
			return null;
		}
		
		int size = getLength(head);
		if (index <= 0 || index >size) {
			return null;
		}
		
		HeroNode temp = head;
		for(int i = 0; i <= size - index; i++) {
			temp =temp.next;
		}
		return temp;
		
	}
	
}
