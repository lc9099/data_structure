package stack;

public class ArrayStack {

	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int val) {
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = val;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ��");
		}
		int val = stack[top];
		top--;
		return val;
	}
	
	public void showStack() {
		if(isEmpty()) {
			System.out.println("ջ�գ�û�����ݡ�����");
			return;
		}
		
		for (int i = top; i >= 0; i--) {
			System.out.println("stack[" + i + "] = " + stack[i]);
		}
	}
	
	public int getTop() {
		return stack[top];
	}
	
}
