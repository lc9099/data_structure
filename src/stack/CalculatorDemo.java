package stack;

import java.util.Scanner;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要计算的式子：");
		String expression = sc.next();
		sc.close();
		
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack operStack = new ArrayStack(10);
		
		int index = 0; // 用于扫描计算式角标
		int num1, num2;
		int oper;
		int res;
		char ch; // 保存每次扫描到的符号
		String keepNum = ""; // 用于拼接多位数
		
		while(true) {
			ch = expression.substring(index, index + 1).charAt(0);
			
			if(isOper(ch)) {
				if (operStack.isEmpty()) {
					operStack.push(ch);
				}else if(priority(ch) <= priority(operStack.getTop())) {
					num1 = numStack.pop();
					num2 = numStack.pop();
					oper = operStack.pop();
					res = calculate(num1, num2, oper);
					numStack.push(res);
					operStack.push(ch);
				}else if(priority(ch) > priority(operStack.getTop())){
					operStack.push(ch);
				}
				
			}else {
				keepNum += ch;
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if(isOper(expression.substring(index+1, index+2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
					}
				}
	
			}
			// 判断是否扫描完成
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = calculate(num1, num2, oper);
			numStack.push(res);
		}
		
		System.out.println("结果是：" + numStack.pop());
		
	}
	
	public static int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		}else if (oper == '+' || oper == '-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	public static boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val =='/';
	}
	
	public static int calculate(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
}
