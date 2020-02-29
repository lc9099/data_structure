package quque;

import java.util.Scanner;

public class ArrayQuqueDemo {

	public static void main(String[] args) {
		
		CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
		Scanner scanner = new Scanner(System.in);
		String key;
		boolean loop = true;
		while(loop) {
			System.out.println("show：显示队列");
			System.out.println("exit：退出程序");
			System.out.println("add：添加数据到队列");
			System.out.println("get：从队列取出数据");
			System.out.println("head：查看队列头数据");
			
			key = scanner.next().toString();
			switch (key) {
			case "show":
				arrayQueue.showQuque();
				break;
			case "add":
				System.out.println("请输入一个数据:");
				int val = scanner.nextInt();
				arrayQueue.addQuque(val);
				break;
			case "get":
				try {
					int res = arrayQueue.getQuque();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "head":
				try {
					int head = arrayQueue.headQuque();
					System.out.printf("队列头的数据是%d\n", head);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
			
		}
		System.out.println("程序退出。。。");
	}
}
