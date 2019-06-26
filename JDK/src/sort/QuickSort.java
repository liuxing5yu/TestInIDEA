package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hwj
 * @date 2019/4/12 9:20
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 2, 4, 6, 5};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] a, int start, int end) {
		if (start < end) {
			int baseNum = a[start];//选基准值
			int midNum;//记录中间值
			int i = start;
			int j = end;
			do {
				while ((a[i] < baseNum) && i < end) {
					i++;
				}
				while ((a[j] > baseNum) && j > start) {
					j--;
				}
				if (i <= j) {
					midNum = a[i];
					a[i] = a[j];
					a[j] = midNum;
					i++;
					j--;
				}
			} while (i <= j);

			if (start < j) {
				quickSort(a, start, j);
			}
			if (end > i) {
				quickSort(a, i, end);
			}
		}
	}

	@Test
	public void testQuickSort() {
		int[] arr = {1, 5, 3, 2, 4, 6, 5};
		int start = 0, end = arr.length - 1;
		int base = arr[start], mid = arr[start];

		int i = start, j = end;
		do {
			while (i < end && arr[i] < base) {
				i++;
			}
			while (j > start && arr[j] > base) {
				j--;
			}
			if (i <= j) {
				mid = arr[i];
				arr[i] = arr[j];
				arr[j] = mid;
				i++;
				j--;
			}
		} while (i <= j);

		if (start < j) {
			quickSort(arr, start, j);
		}
		if (end > i) {
			quickSort(arr, i, end);
		}

		System.out.println(Arrays.toString(arr));
	}
}
