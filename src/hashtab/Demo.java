package hashtab;

public class Demo {

	public static void main(String[] args) {
		
		HashTab hashTab = new HashTab(7);
		Employees emp1 = new Employees(1, "li");
		Employees emp2 = new Employees(2, "wang");
		Employees emp3 = new Employees(8, "zhang");

		hashTab.add(emp1);
		hashTab.add(emp2);
		hashTab.add(emp3);
		
		hashTab.list();
		hashTab.findEmpById(7);
	}
}
