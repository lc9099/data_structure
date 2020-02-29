package search;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchDemo {

	public static int maxSize = 20;
	
	public static void main(String[] args) {
		int array[] = {1, 9, 11,11, 17, 34, 89};
//		ArrayList<Integer> list = sequenceSearch(array, 11);
//		ArrayList<Integer> list = binarySearch(array, 0, array.length - 1, 11);
//		ArrayList<Integer> list = insertValSearch(array, 0, array.length - 1, 11);
		int fibSearch = fibSearch(array, 11);
		System.out.println("要找数值的下标是：" + fibSearch);
//		System.out.println("要找数值的下标是：" + list);
		
		
	}
	
	public static ArrayList<Integer> sequenceSearch(int[] array, int findVal) {
		
		ArrayList<Integer> resList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if(array[i] == findVal) {
				resList.add(i);
			}
		}
		return resList;

	}
	
	public static ArrayList<Integer> binarySearch(int[] array, int start, int end, int findVal) {
		
		if (start > end || array.length == 0 || start < 0 || end > array.length) {
			return new ArrayList<Integer>();
		}
		
		int mid = (start + end) / 2;
		int midVal = array[mid];
		
		if (findVal > midVal) {
			return binarySearch(array, mid + 1, end, findVal);
		}else if(findVal < midVal) {
			return binarySearch(array, start, mid - 1, findVal);
		}else {
			ArrayList<Integer> resList = new ArrayList<Integer>();
			int temp = mid -1;
			while(true) {
				if (temp < 0 || array[temp] != findVal) {
					break;
				}
				resList.add(temp);
				temp--;
			}
			resList.add(mid);
			temp = mid + 1;
			while(true) {
				if (temp > array.length - 1 || array[temp] != findVal) {
					break;
				}
				resList.add(temp);
				temp++;
			}
			return resList;
		}
	}
	
	public static ArrayList<Integer> insertValSearch(int[] array, int start, int end, int findVal) {
		
		if (start > end || findVal < array[0] || findVal > array[array.length - 1]) {
			return new ArrayList<Integer>();
		}
		
		int mid = (start + end) / 2;
		int midVal = array[mid];
		
		if (findVal > midVal) {
			return insertValSearch(array, mid + 1, end, findVal);
		}else if(findVal < midVal) {
			return insertValSearch(array, start, mid - 1, findVal);
		}else {
			ArrayList<Integer> resList = new ArrayList<Integer>();
			int temp = mid -1;
			while(true) {
				if (temp < 0 || array[temp] != findVal) {
					break;
				}
				resList.add(temp);
				temp--;
			}
			resList.add(mid);
			temp = mid + 1;
			while(true) {
				if (temp > array.length - 1 || array[temp] != findVal) {
					break;
				}
				resList.add(temp);
				temp++;
			}
			return resList;
		}
	}
	
	public static int[] makeFib() {
		int[] fib= new int[maxSize];
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i < maxSize; i++) {
			fib[i] = fib[i - 1] + fib[i -2];
		}
		return fib;
	}
	
	public static int fibSearch(int[] array, int findVal){
		
		int start = 0;
		int end = array.length - 1;
		int fibIndex = 0;
		int mid;
		int fib[] = makeFib();
		while (end > fib[fibIndex] - 1) {
			fibIndex++;
		}
		
		int[] tempArr = Arrays.copyOf(array, fib[fibIndex]);
		for (int i = end; i < tempArr.length; i++) {
			tempArr[i] = array[end];
		}

		while(start <= end) {
			mid = start + fib[fibIndex - 1] - 1;
			if (findVal < tempArr[mid]) {
				end = mid - 1;
				fibIndex--;
			}else if (findVal > tempArr[mid]) {
				start = mid + 1;
				fibIndex -= 2;
				
			}else {
		
				if (mid <= end) {
					return mid;
				}else {
					return end;
				
				}		
				
			}
			
		}
		return -1;
		
	}
	
	
	
}
