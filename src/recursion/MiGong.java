package recursion;

public class MiGong {

	public static void main(String[] args) {
		
		// 模拟迷宫
		int[][] map = new int[8][7];
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[3][3] = 1;
		map[2][3] = 1;
		
		for (int[] item : map) {
			for(int a : item) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		setWay(map, 1, 1);
		System.out.println("---------------");
		for (int[] item : map) {
			for(int a : item) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 	当map[i][j]为0时，表示该点没有走过，
	 * 	当map[i][j]为1时，表示不能通过，
	 * 	当map[i][j]为2时，表示通路可以走
	 * 	当map[i][j]为3时，表示走过，但是不通
	 * 	策略：下->右->上->左
	 * @param map 迷宫地图
	 * @param i	开始的行
	 * @param j 开始的列
	 * @return 找到为true， 否则false
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		
		if (map[6][5] == 2) {
			return true;
		}else {
			if (map[i][j] == 0) {
				
				map[i][j] = 2; // 假定可以走通
				if (setWay(map, i+1, j)) {
					return true;
				}else if (setWay(map, i, j+1)) {
					return true;
				}else if (setWay(map, i-1, j)) {
					return true;
				}else if (setWay(map, i, j-1)){
					return true;
				}else {
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
		
	}
	
}
