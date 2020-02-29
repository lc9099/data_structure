package stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack(4);
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		String key;
		
		while(loop) {
			System.out.println("show：显示栈的内容");
			System.out.println("push：入栈");
			System.out.println("pop：出栈");
			System.out.println("exit：退出");
			key = sc.next();
			switch (key) {
			case "show":
				stack.showStack();
				break;
			case "push":
				System.out.println("请输入入栈的数据：");
				int val = sc.nextInt();
				stack.push(val);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.println("出栈的数据是" + res);
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
		System.out.println("程序退出");
		
	}
}
