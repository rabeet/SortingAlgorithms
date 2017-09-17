import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
	
	/* 
	 * choose a pivot from random
	 * subarray to the left is smaller, to the right is bigger
	 * run quicksort to the left and the right
	 * stop when whole array has been visited
	 * 
	 * TC: O(nlogn) best case
	 * SC: O(1)
	 */
	
	public static void main(String[] args) {

		int test[] = {5,4,3,2,1,0,0,-1};
		System.out.println(Arrays.toString(test));
		quicksortRabeet(test, 0, test.length);
		System.out.println(Arrays.toString(test));
		int[] test1 = {5,4,3,2,1,0,0,-1};
		System.out.println(Arrays.toString(test1));
		quicksort(test1, 0, test1.length-1);
		System.out.println(Arrays.toString(test1));
	
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int pivot = partition(arr, start, end);
		quicksort(arr, start, pivot-1);
		quicksort(arr, pivot+1, end);
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = (start + end)/2;
		Utilities.swap(arr, start, end);
		
		int i = start;
		for (int j = start; j < end; j++) {
			if (arr[j] <= arr[end]) {
				Utilities.swap(arr, i, j);
				i++;
			}
		}
		Utilities.swap(arr, i, end);
		return i;
	}
	
	public static void quicksortRabeet(int[] arr, int start, int end) {
		if (start > end) {
			return;
		}
		int pivot = (start + end) / 2;
		int pivotVal = arr[pivot];
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i ==  pivot)
				continue;
			if (arr[i] > arr[pivot])
				right.add(arr[i]);
			else
				left.add(arr[i]);
		}
		int[] temparr = new int[arr.length];
		int index = 0;
		for (int i : left)
			arr[index++] = i;
		arr[index++] = pivotVal;
		for (int i : right)
			arr[index++] = i;
		

		quicksortRabeet(arr, start+1, pivot);
		quicksortRabeet(arr, pivot, end-1);
	}

}