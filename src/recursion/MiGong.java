package recursion;

public class MiGong {

	public static void main(String[] args) {
		
		// ģ���Թ�
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
	 * 	��map[i][j]Ϊ0ʱ����ʾ�õ�û���߹���
	 * 	��map[i][j]Ϊ1ʱ����ʾ����ͨ����
	 * 	��map[i][j]Ϊ2ʱ����ʾͨ·������
	 * 	��map[i][j]Ϊ3ʱ����ʾ�߹������ǲ�ͨ
	 * 	���ԣ���->��->��->��
	 * @param map �Թ���ͼ
	 * @param i	��ʼ����
	 * @param j ��ʼ����
	 * @return �ҵ�Ϊtrue�� ����false
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		
		if (map[6][5] == 2) {
			return true;
		}else {
			if (map[i][j] == 0) {
				
				map[i][j] = 2; // �ٶ�������ͨ
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
