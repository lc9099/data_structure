package quque;

import java.util.Scanner;

public class ArrayQuqueDemo {

	public static void main(String[] args) {
		
		CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
		Scanner scanner = new Scanner(System.in);
		String key;
		boolean loop = true;
		while(loop) {
			System.out.println("show����ʾ����");
			System.out.println("exit���˳�����");
			System.out.println("add��������ݵ�����");
			System.out.println("get���Ӷ���ȡ������");
			System.out.println("head���鿴����ͷ����");
			
			key = scanner.next().toString();
			switch (key) {
			case "show":
				arrayQueue.showQuque();
				break;
			case "add":
				System.out.println("������һ������:");
				int val = scanner.nextInt();
				arrayQueue.addQuque(val);
				break;
			case "get":
				try {
					int res = arrayQueue.getQuque();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "head":
				try {
					int head = arrayQueue.headQuque();
					System.out.printf("����ͷ��������%d\n", head);
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
		System.out.println("�����˳�������");
	}
}
