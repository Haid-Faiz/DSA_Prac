
class QuickSort {
	public static void main(String[] args) {
	
		int[] arr = {5,6,7,21,65,78,14,2,9,1};

		quickSort(arr, 0, arr.length-1);
		printArray(arr);
	}

	public static void quickSort(int[] arr, int low, int high) {

			if(high>low) {
			    int p = partition(arr, low, high);
			    quickSort(arr, low, p-1);
			    quickSort(arr, p, high);
			}
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		
		while(high>=low) {

			while(arr[low]<pivot)
				low++;
			while(arr[high]>pivot)
				high--;

			if(high>=low) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;

				low++;
				high--;
			}
		}
		return low;
	}

	public static void printArray(int[] arr) {
		System.out.println("Sorted Array is:");
		for(int i: arr) {
			System.out.print(i + " ");
		}
	}

}