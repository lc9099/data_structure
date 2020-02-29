package quque;

public class CircleArrayQueue {

	private int maxSize; // �������
	private int front; // ����ͷ
	private int rear; // ����β
	private int[] arr; // ���ڴ�����ݣ�ģ�����
	
	public CircleArrayQueue(int maxSize) {
		
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.front = 0;
		this.rear = 0;
			
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	public void addQuque(int num) {
		if(isFull()) {
			System.out.println("�����������ܼ�������");
			return;
		}
		arr[rear] = num;
		rear = (rear + 1) % maxSize;
	} 
	
	public int getQuque() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");	
		}
		int val = arr[front];
		front = (front + 1) % maxSize;
		return val;
		
	}
	
	public void showQuque() {
		if(isEmpty()) {
			System.out.println("����Ϊ��...");
			return;
		}
		for (int i = front; i < front + arrSize(); i++) {
			System.out.printf("array[%d]=%d\n",  i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int headQuque() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�û������");
		}
		return arr[front];
			
	}
	
	public int arrSize() {
		return (rear + maxSize - front) % maxSize; 
	}
	
}
