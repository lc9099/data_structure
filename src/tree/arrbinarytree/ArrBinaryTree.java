package tree.arrbinarytree;

public class ArrBinaryTree {

	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}
	
	public void preOrder() {
		this.preOrder(0);
	}
	public void preOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		System.out.println(arr[index]);
		
		if((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
	}
	
	public void midOrder() {
		this.midOrder(0);
	}
	public void midOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		
		if((index * 2 + 1) < arr.length) {
			midOrder(index * 2 + 1);
		}
		System.out.println(arr[index]);

		if((index * 2 + 2) < arr.length) {
			midOrder(index * 2 + 2);
		}
	}
	
	public void postOrder() {
		this.postOrder(0);
	}
	public void postOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		
		if((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}

		if((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		
		System.out.println(arr[index]);

	}
	
}
