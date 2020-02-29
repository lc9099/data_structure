package linkedlist.circlelist;

public class CircleSingleLinkedList {

	private Boy first = null;
	
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不正确");
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
			System.out.println("没有一个小孩");
			return;
		}

		Boy cur = first;
		while(true) {
			System.out.println("小孩编号：" + cur.getNo());
			if(cur.getNext() == first) {
				break;
			}
			cur = cur.getNext();
		}
	}
	
	/**
	 * josephu问题
	 * @param startNo 表示从第几个开始数
	 * @param countNum 表示数几次
	 * @param nums 表示最初有多少人
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("输入参数有误");
			return;
		}
		// 让helper指向first的前一个
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		// 从第startNo开始报数，则让first指向startNo，helper指向first的前一个
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
			System.out.println("编号 " + first.getNo() + " 小孩出圈");
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("最后留在圈中的小孩编号：" + first.getNo());
		
		
	}	
	
}
