package linkedlist.doublelist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		
		HeroNode2 hero2 = new HeroNode2(2, "�ν�", "��ʱ��");
		HeroNode2 hero4 = new HeroNode2(4, "¬����", "������");
		HeroNode2 hero5 = new HeroNode2(5, "����", "�Ƕ���");
		HeroNode2 hero7 = new HeroNode2(7, "�ֳ�", "����ͷ");
		// ��������
		DoubleLinkedList list = new DoubleLinkedList();
		// ��ӽڵ�
		list.addToEnd(hero2);
		list.addToEnd(hero5);
		list.addByOrder(hero4);
		list.addByOrder(hero7);
		
		// ���½ڵ���Ϣ
		HeroNode2 heroNode = new HeroNode2(4, "С¬", "������~~~");
		list.updateInfo(heroNode);
		// ɾ���ڵ�
		// list.delHero(5);
		// ��ʾ����
		list.showList();
		
	}
	
	
}
