package linkedlist.doublelist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		
		HeroNode2 hero2 = new HeroNode2(2, "宋江", "及时雨");
		HeroNode2 hero4 = new HeroNode2(4, "卢俊义", "玉麒麟");
		HeroNode2 hero5 = new HeroNode2(5, "吴用", "智多星");
		HeroNode2 hero7 = new HeroNode2(7, "林冲", "豹子头");
		// 创建链表
		DoubleLinkedList list = new DoubleLinkedList();
		// 添加节点
		list.addToEnd(hero2);
		list.addToEnd(hero5);
		list.addByOrder(hero4);
		list.addByOrder(hero7);
		
		// 更新节点信息
		HeroNode2 heroNode = new HeroNode2(4, "小卢", "玉麒麟~~~");
		list.updateInfo(heroNode);
		// 删除节点
		// list.delHero(5);
		// 显示链表
		list.showList();
		
	}
	
	
}
