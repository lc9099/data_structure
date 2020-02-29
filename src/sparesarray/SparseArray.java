package sparesarray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 稀疏数组
public class SparseArray {

	public static void main(String[] args) throws IOException {
		
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][2] = 2;
		chessArr1[4][5] = 2;
		
		// 输出原始数组
		arrPrint(chessArr1);
		
		// 将二维数组转化为稀疏数组
		int sum = 0;
		for (int i = 0; i < chessArr1.length; i++) {		
			for (int j = 0; j < chessArr1[0].length; j++) {			
				if (chessArr1[i][j] != 0)
					sum++;
			}			
		}
		
		// 创建稀疏数组
		int sparseArr[][] = new int[sum + 1][3];
		// 用于记录元素的行数
		int count = 0;
		// 给稀疏数组赋值
		sparseArr[count][0] = chessArr1.length;
		sparseArr[count][1] = chessArr1[0].length;
		sparseArr[count][2] = sum;
		count++;		
		for (int i = 0; i < chessArr1.length; i++) {		
			for (int j = 0; j < chessArr1[0].length; j++) {			
				if (chessArr1[i][j] != 0) {
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
					count++;
				}
			}			
		}		
		// 遍历稀疏数组
		arrPrint(sparseArr);
		
		saveToFile(sparseArr);
		readFileToArr(sparseArr);
		
		// 将稀疏数组转化为二维数组
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		arrPrint(chessArr2);
		
		
	}
	
	public static void arrPrint(int[][] arr) {
		
		for (int[] row : arr) {	
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
	}
	
	
	public static void saveToFile(int[][] arr) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
		
		for (int i = 0; i < arr.length; i++) {
			String str = new String();
			for (int j = 0; j < arr[0].length; j++) {
				str += arr[i][j] + ",";
			}
			bw.write(str);
			bw.newLine();			
		}
		bw.close();
	}
	
	
	public static void readFileToArr(int[][] arr) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		
		String line;
		int row = 0;
		while ((line = br.readLine()) != null) {
			String[] array = line.split(",");
			
			for (int i = 0; i < array.length; i++)	{
				int num = Integer.parseInt(array[i]);
				arr[row][i] = num;
			}
			row++;
		}		
		br.close();
	}

}
