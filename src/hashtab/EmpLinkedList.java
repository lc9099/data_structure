package hashtab;

public class EmpLinkedList {

	private Employees head;
	
	public void add(Employees emp) {
		if(head == null) {
			head = emp;
			return;
		}
		Employees curEmp = head;
		while(curEmp.next != null) {
			curEmp = curEmp.next;
		}
		curEmp.next = emp;
	}
	
	public void list(int no) {
		if (head == null) {
			System.out.println(no + "链表为空。。。");
			return;
		}
		System.out.print( no + "链表信息为：");
		Employees curEmp = head;
		while(true) {
			System.out.println("==> id=" + curEmp.id + ", name=" + curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
	}
	
	public Employees findEmpById(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return head;
		}
		Employees curEmp = head;
		while(true) {
			if(curEmp.id == id) {
				break;
			}
			if (curEmp.next == null) {
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;
		
	}

}
