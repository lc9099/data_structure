package quque;

public class ArrayQueue {

	private int maxSize; // �������
	private int front; // ����ͷ
	private int rear; // ����β
	private int[] arr; // ���ڴ�����ݣ�ģ�����
	
	public ArrayQueue(int maxSize) {
		
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.front = -1;
		this.rear = -1;
			
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public boolean isFull() {
		return rear == maxSize -1;
	}
	
	public void addQuque(int num) {
		if(isFull()) {
			System.out.println("�����������ܼ�������");
			return;
		}
		rear++;
		arr[rear] = num;
	}
	
	public int getQuque() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");	
		}
		front++;
		return arr[front];
	}
	
	public void showQuque() {
		if(isEmpty()) {
			System.out.println("����Ϊ�գ����ɱ���");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("array[%d]=%d\n",  i, arr[i]);
		}
	}
	
	public int headQuque() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�û������");
		}
		front++;
		return arr[front];
			
	}
	
}
