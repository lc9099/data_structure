package linkedlist.circlelist;

public class CircleSingleLinkedList {

	private Boy first = null;
	
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		
		Boy cur = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				cur = first;
			}else {
				cur.setNext(boy);
				boy.setNext(first);
				cur = boy;
			}
		}
		
	}
	
	public void showBoy() {
		if(first == null) {
			System.out.println("û��һ��С��");
			return;
		}

		Boy cur = first;
		while(true) {
			System.out.println("С����ţ�" + cur.getNo());
			if(cur.getNext() == first) {
				break;
			}
			cur = cur.getNext();
		}
	}
	
	/**
	 * josephu����
	 * @param startNo ��ʾ�ӵڼ�����ʼ��
	 * @param countNum ��ʾ������
	 * @param nums ��ʾ����ж�����
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("�����������");
			return;
		}
		// ��helperָ��first��ǰһ��
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		// �ӵ�startNo��ʼ����������firstָ��startNo��helperָ��first��ǰһ��
		for(int i = 0; i < startNo - 1; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		while(true) {
			if(helper == first) {
				break;
			}
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.println("��� " + first.getNo() + " С����Ȧ");
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("�������Ȧ�е�С����ţ�" + first.getNo());
		
		
	}	
	
}
