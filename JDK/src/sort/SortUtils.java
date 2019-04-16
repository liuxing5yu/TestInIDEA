package sort;

import java.util.Arrays;

import org.junit.Test;

public class SortUtils {
	public static void main(String[] args) {
		int[] src = new int[]{1, 3, 5, 7, 8, 9};
		System.out.println(binarySearch2(src, 2));
		System.out.println(binarySearch(src, 3, 0, src.length - 1));
	}

	public static int binarySearch2(int[] arr, int des) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == arr[middle]) {
				return middle;
			} else if (des < arr[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * * 二分查找算法 * *
	 *
	 * @param srcArray 有序数组 *
	 * @param des      查找元素 *
	 * @return des的数组下标，没找到返回-1
	 */
	public static int binarySearch(int[] srcArray, int des) {
		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (des == srcArray[middle]) {
				return middle;
			} else if (des < srcArray[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找特定整数在整型数组中的位置(递归)
	 *
	 * @paramdataset
	 * @paramdata
	 * @parambeginIndex
	 * @paramendIndex
	 * @returnindex
	 */
	public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex) {
			return -1;
		}
		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		} else if (data > dataset[midIndex]) {
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		} else {
			return midIndex;
		}
	}

	/**
	 * 冒泡排序
	 *
	 * @param list
	 */
	public <T extends Comparable<T>> void sort(T[] list) {
		boolean swapped = true;
		for (int i = 1, len = list.length; i < len && swapped; ++i) {
			swapped = false;
			for (int j = 0; j < len - i; ++j) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					T temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	@Test
	public void testBubbleSort() {
		int[] arr = new int[]{1, 3, 2, 5, 4};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 冒泡排序
	 *
	 * @param arr
	 */
	public void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 冒泡排序
	 */
	@Test
	public void testBubbleSort2() {
		int[] arr = {1, 5, 3, 2, 4, 6, 5};
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
