package linkedlist.singlelist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		
		HeroNode hero2 = new HeroNode(2, "宋江", "及时雨");
		HeroNode hero4 = new HeroNode(4, "卢俊义", "玉麒麟");
		HeroNode hero5 = new HeroNode(5, "吴用", "智多星");
		HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
		// 创建链表
		SingleLinkedList list = new SingleLinkedList();
		// 添加节点
		list.addByOrder(hero2);
		list.addByOrder(hero4);
		list.addByOrder(hero5);
		list.addByOrder(hero7);
		
		// 测试两个有序链表的合并
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero3 = new HeroNode(3, "卢俊义", "玉麒麟");
		HeroNode hero6 = new HeroNode(6, "吴用", "智多星");
		HeroNode hero9 = new HeroNode(9, "林冲", "豹子头");
		SingleLinkedList list2 = new SingleLinkedList();
		list2.addByOrder(hero1);
		list2.addByOrder(hero3);
		list2.addByOrder(hero6);
		list2.addByOrder(hero9);
		
		// 更新节点信息
		HeroNode heroNode = new HeroNode(2, "小卢", "玉麒麟~~~");
		list.updateInfo(heroNode);
		// 删除节点
		list.delHero(3);
		// 获取节点个数
		System.out.println("节点个数：" + getLength(list.getHead()));
		// 获取倒数第2个节点
		HeroNode node = findLastIndexNode(list.getHead(), 1);
		System.out.println(node);
		// 单链表反转
		// reverseList(list.getHead());
		// 逆序打印链表节点，不能改变原链表结构
		reversePrint(list.getHead());
		// 显示链表
		System.out.println("-----------------");
		list.showList();
		
		// 合并两个有序链表，合成后依然有序
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
			// 头插
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
