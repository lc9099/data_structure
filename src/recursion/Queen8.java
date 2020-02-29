package recursion;

public class Queen8 {

	int max = 8;// 皇后数
	// 保存被放置后的结果
	int[] array = new int[max];
 	
	public static void main(String[] args) {
		Queen8 queen8 = new Queen8();
		queen8.check(0);
	}
	
	private void check(int n) {
		if ( n == max) {
			resPrint();
			return;
		}
		
		for(int i = 0; i < max; i++) {
			array[n] = i;		
			if (judge(n)) {
				
				check(n+1);
			}
		}
	}
	
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n -i) == Math.abs(array[n] - array[i])){
				 return false;
			}
		}
		return true;
	}
	
	private void resPrint() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
