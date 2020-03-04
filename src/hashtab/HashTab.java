package hashtab;

public class HashTab {

	private EmpLinkedList[] empLinkedListArray;
	private int size; // ��ʾ�ж���������
	
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
			System.out.println(empLinkedListNo + 1 + "�������ҵ��˹�Աid=" + id);
		}else {
			System.out.println("û���ҵ�");
		}
		
	}
	
	// ��дɢ�к�����ȡģ����
	public int hashFun(int id) {
		return id % size;
	}
	
}
