package quque;

public class ArrayQueue {

	private int maxSize; // 最大容量
	private int front; // 队列头
	private int rear; // 队列尾
	private int[] arr; // 用于存放数据，模拟队列
	
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
			System.out.println("队列满，不能加入数据");
			return;
		}
		rear++;
		arr[rear] = num;
	}
	
	public int getQuque() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不可取数据");	
		}
		front++;
		return arr[front];
	}
	
	public void showQuque() {
		if(isEmpty()) {
			System.out.println("队列为空，不可遍历");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("array[%d]=%d\n",  i, arr[i]);
		}
	}
	
	public int headQuque() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，没有数据");
		}
		front++;
		return arr[front];
			
	}
	
}
