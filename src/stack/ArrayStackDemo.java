package stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack(4);
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		String key;
		
		while(loop) {
			System.out.println("show����ʾջ������");
			System.out.println("push����ջ");
			System.out.println("pop����ջ");
			System.out.println("exit���˳�");
			key = sc.next();
			switch (key) {
			case "show":
				stack.showStack();
				break;
			case "push":
				System.out.println("��������ջ�����ݣ�");
				int val = sc.nextInt();
				stack.push(val);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.println("��ջ��������" + res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				sc.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
		
	}
}
