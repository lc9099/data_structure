package stack;

import java.util.ArrayList;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		
		String infixExpression = "1+((2+3)*4)-5";
		ArrayList<String> infixExpressionList = toInfixExpressionList(infixExpression);
		ArrayList<String> suffixExpressionList = infixToSuffix(infixExpressionList);
		System.out.println(suffixExpressionList);
		int res = calculate(suffixExpressionList);
		System.out.println("结果是：" + res);
		
		
	}
	
	public static ArrayList<String> infixToSuffix(ArrayList<String> list){
		
		Stack<String> stack = new Stack<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (String item : list) {
			if (item.matches("\\d+")) {
				arrayList.add(item);
			}else if (item.equals("(")) {
				stack.push(item);
			}else if (item.equals(")")){
				while(!stack.peek().equals("(")) {
					arrayList.add(stack.pop());
				}
				stack.pop();
			}else {
				
				while(stack.size() != 0 && getOperVal(stack.peek()) >= getOperVal(item)) {
					arrayList.add(stack.pop());
				}
				stack.push(item);
			}
		}
		while(stack.size() != 0) {
			arrayList.add(stack.pop());
		}
		
		return arrayList;
	}
	
	public static int getOperVal(String oper) {
		int res = 0;
		switch (oper) {
		case "+":
			res = 1;
			break;
		case "-":
			res = 1;
			break;
		case "*":
			res = 2;
			break;
		case "/":
			res = 2;
			break;
		default:
			break;	
		}
		
		return res;
	}
	
	public static ArrayList<String> toInfixExpressionList(String s){
		ArrayList<String> list = new ArrayList<String>();
		int index = 0;
		String str;
		char ch;
		while(index < s.length()) {
			if ((ch = s.charAt(index)) < 48 || (ch = s.charAt(index)) > 57) {
				list.add("" + ch);
				index++;
			}else {
				str = "";
				while(index < s.length() && (ch=s.charAt(index)) >= 48 && (ch=s.charAt(index)) <= 57) {
					str += ch;
					index++;
				}
				list.add(str);
			}
		}
		return list;
		
	}

	public static ArrayList<String> getListString(String expression){
		
		String[] strings = expression.split(" ");
		ArrayList<String> list = new ArrayList<String>();
		
		for (String elem : strings) {
			list.add(elem);
		}
		return list;
	}
	
	public static int calculate(ArrayList<String> list) {
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			// 正则匹配是否是多位数
			if(item.matches("\\d+")) {
				stack.push(item);
			}else {
				int num1 = Integer.parseInt(stack.pop()); 
				int num2 = Integer.parseInt(stack.pop()); 
				int res = 0;
				switch (item) {
				case "+":
					res = num1 + num2;
					break;
				case "-":
					res = num2 - num1;
					break;
				case "*":
					res = num1 * num2;
					break;
				case "/":
					res = num2 / num1;
					break;
				default:
					break;
				}
				stack.push("" + res);
			}
			
		}
		return Integer.parseInt(stack.pop());
	}
	
}
