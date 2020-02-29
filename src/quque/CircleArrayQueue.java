package quque;

public class CircleArrayQueue {

	private int maxSize; // 最大容量
	private int front; // 队列头
	private int rear; // 队列尾
	private int[] arr; // 用于存放数据，模拟队列
	
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
			System.out.println("队列满，不能加入数据");
			return;
		}
		arr[rear] = num;
		rear = (rear + 1) % maxSize;
	} 
	
	public int getQuque() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不可取数据");	
		}
		int val = arr[front];
		front = (front + 1) % maxSize;
		return val;
		
	}
	
	public void showQuque() {
		if(isEmpty()) {
			System.out.println("队列为空...");
			return;
		}
		for (int i = front; i < front + arrSize(); i++) {
			System.out.printf("array[%d]=%d\n",  i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int headQuque() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，没有数据");
		}
		return arr[front];
			
	}
	
	public int arrSize() {
		return (rear + maxSize - front) % maxSize; 
	}
	
}
