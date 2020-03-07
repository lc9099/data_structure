package sort;

import java.util.Arrays;

public class SortDemo {

	public static void main(String[] args) {

		int array[] = { 3, 9, -1, 10, -2 };
//		bubbleSort(array);
//		selectSort(array);
//		insertSort(array);
		shellSort(array);
//		quickSort(array, 0, array.length - 1);
//		int temp[] = new int[array.length];
//		mergeSort(array, 0, array.length - 1, temp);
//		radixSort(array); // 基数排序不能排负数
		heapSort(array);
		System.out.println(Arrays.toString(array));

	}

	public static void bubbleSort(int[] array) {

		if (array.length == 0)
			return;

		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

					flag = true;
				}
			}
			// 如果没有进行交换则说明已排好序，不用再继续进行
			if (flag) {
				flag = false;
			} else {
				break;
			}
		}

	}

	public static void selectSort(int[] array) {

		if (array.length == 0)
			return;

		for (int i = 0; i < array.length - 1; i++) {

			int minIndex = i; // 最小值下标
			for (int j = i + 1; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			int min = array[minIndex];
			array[minIndex] = array[i];
			array[i] = min;
		}
	}

	public static void insertSort(int[] array) {

		if (array.length == 0)
			return;
		int insertVal;
		for (int i = 0; i < array.length - 1; i++) {
			insertVal = array[i + 1];
			int insertIndex = i;
			while (insertIndex >= 0 && insertVal < array[insertIndex]) {
				array[insertIndex + 1] = array[insertIndex];
				insertIndex--;
			}
			array[insertIndex + 1] = insertVal;
		}
	}

	public static void shellSort(int[] array) {

		if (array.length == 0)
			return;
		int temp;
		int gap = array.length / 2;
		int insertIndex;
		while (gap > 0) {
			for (int i = gap; i < array.length; i++) {
				temp = array[i];
				insertIndex = i - gap;
				while (insertIndex >= 0 && array[insertIndex] > temp) {
					array[insertIndex + gap] = array[insertIndex];
					insertIndex -= gap;
				}
				array[insertIndex + gap] = temp;
			}
			gap /= 2;
		}

	}

	public static void quickSort(int[] array, int start, int end) {

		if (array.length < 1 || start < 0 || end >= array.length || start > end)
			return;
		// 定义一个基准pivot
		int pivot = array[(start + end) / 2];
		int temp = 0;
		int left = start;
		int right = end;
		while (start < end) {

			while (array[start] < pivot) {
				start++;
			}
			while (array[end] > pivot) {
				end--;
			}

			if (start >= end) {
				break;
			}
			// 交换
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;

			if (array[start] == pivot) {
				end--;
			}
			if (array[end] == pivot) {
				start++;
			}
		}

		// 如果start == end，不处理会出现栈溢出
		if (start == end) {
			start--;
			end++;
		}

		if (left < start) {
			quickSort(array, left, start);
		}
		if (right > end) {
			quickSort(array, end, right);
		}

	}

	public static void mergeSort(int[] array, int start, int end, int[] temp) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid, temp);
			mergeSort(array, mid + 1, end, temp);
			merge2arr(array, start, mid, end, temp);
		}
	}

	private static void merge2arr(int[] array, int start, int mid, int end, int[] temp) {

		int left = start;
		int right = mid + 1;
		int tempIndex = 0;
		// 比较左右两边数组的值，将较小的放入temp中，直至一个数组全部放入
		while (left <= mid && right <= end) {

			if (array[left] <= array[right]) {
				temp[tempIndex] = array[left];
				left++;
				tempIndex++;
			} else {
				temp[tempIndex] = array[right];
				right++;
				tempIndex++;
			}
		}

		// 将有剩余数据的数组依次全部放入temp中
		while (left <= mid) {
			temp[tempIndex] = array[left];
			left++;
			tempIndex++;
		}

		while (right <= end) {
			temp[tempIndex] = array[right];
			right++;
			tempIndex++;
		}

		// 将temp中的元素拷贝到原数组中
		tempIndex = 0;
		while (start <= end) {
			array[start] = temp[tempIndex];
			start++;
			tempIndex++;
		}

	}

	public static void radixSort(int[] array) {

		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}
		int maxDigit = (max + "").length();
		int[][] bucket = new int[10][array.length];

		// 用一维数组记录各个桶放入数据的个数
		int[] bucketElementCounts = new int[10];
		for (int i = 0, n = 1; i < maxDigit; i++, n *= 10) {

			for (int j = 0; j < array.length; j++) {

				int digitOfElement = (array[j] / n) % 10;
				// 放入桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
				bucketElementCounts[digitOfElement]++;
			}

			int index = 0;
			for (int k = 0; k < bucketElementCounts.length; k++) {

				if (bucketElementCounts[k] != 0) {

					for (int l = 0; l < bucketElementCounts[k]; l++) {
						array[index] = bucket[k][l];
						index++;
					}
				}
				bucketElementCounts[k] = 0;
			}
		}

	}

	public static void heapSort(int[] array) {
		// 升序大顶堆，降序小顶堆
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			adjustHeap(array, i, array.length);
		}
			
		int temp;
		for(int i = array.length - 1; i>0; i--) {
			temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			adjustHeap(array, 0, i);
		}
	}

	public static void adjustHeap(int array[], int index, int len) {

		int temp = array[index];
		// 从index的左子节点开始
		for (int i = index * 2 + 1; i < len; i = i * 2 + 1) {
			if (i + 1 < len && array[i] < array[i + 1]) {
				i++;
			}
			if (array[i] > temp) {
				array[index] = array[i];
				index = i;
			} else {
				break;
			}
		}
		
		array[index] = temp;
		
	}

}
