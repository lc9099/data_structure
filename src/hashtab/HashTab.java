package hashtab;

public class HashTab {

	private EmpLinkedList[] empLinkedListArray;
	private int size; // 表示有多少条链表
	
	public HashTab(int size) {
		
		this.size = size;
		empLinkedListArray = new EmpLinkedList[this.size];
		
		for(int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	
	public void add(Employees emp) {
		
		int empLinkedListNo = hashFun(emp.id);
		empLinkedListArray[empLinkedListNo].add(emp);
		
	}
	
	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i + 1);
		}
	}
	
	public void findEmpById(int id) {
		int empLinkedListNo = hashFun(id);
		Employees empById = empLinkedListArray[empLinkedListNo].findEmpById(id);
		if (empById != null) {
			System.out.println(empLinkedListNo + 1 + "链表中找到了雇员id=" + id);
		}else {
			System.out.println("没有找到");
		}
		
	}
	
	// 编写散列函数（取模法）
	public int hashFun(int id) {
		return id % size;
	}
	
}
