import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		int[] arr1 = {0,1,2,5,4,5,6,3,4,5,2,5,6,10,8,7};
		int[] arr2 = {0,1,2,5,4,5,6,3,4,5,2,5,6,10,8,7};
		//String[] arr2 = {"a","c","v","f","n","H","g","i","r"};
		System.out.println("Before sorting: " + Arrays.toString(arr1));
		// (1) Selection sort
		// SelectionSort.sort(arr1);
		// (2) Insertion sort
		// InsertionSort.sort(arr1);
		// (3) Shell sort
		// ShellSort.sort(arr1);
		// (4-1) Top-Down merge sort
		// MergeSortTopDown.sort(arr1);
		// (4-2) Bottom-Up merge sort
		// MergeSortBottomUp.sort(arr1);
		// (4-3) In-place merge sort
		// MergeSortInPlace.sort(arr1);
		// (5-1) Normal quick sort
		// QuickSort.quickSort(arr1);
		// (5-2) Quick sort 3 way
		// QuickSort.quickSort3Way(arr1);
		// (6) Priority queue
		HeapSort.sort(arr1);
		CheckArrayConsistency(arr1, arr2);
		CheckSorted(arr1);
		System.out.println("After sorting:  " + Arrays.toString(arr1));	
	}
	
	private static void CheckArrayConsistency(int[] arr1, int[] arr2){
		int[] letters = new int[arr1.length];
		for(int num : arr1){
			letters[num]++;
		}
		for(int num : arr2){
			if(--letters[num] < 0){
				System.out.println("ERROR: Find incosistency of input and output!");
				break;
			}
		}
	}
	
	private static void CheckSorted(int[] arr){
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i] > arr[i+1]){
				System.out.println("The array is not sorted");
				return;
			}
		}
	}
}
