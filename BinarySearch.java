
class BinarySearch{
	public static void main(String[] args) {
		// took sorted array
		int[] arr = {4,5,8,12,15,20,45,49,52,55};
		int searchNum = 45;

		int low = 0;
		int high = arr.length-1;
		int middle = (low+high)/2;

		while(high>=low) {
			
			if(arr[middle] == searchNum) {
				System.out.println(searchNum + " is found at: " + middle);
				break;
			} else if(searchNum > arr[middle]) {
				low = middle++;
			} else {
				high = middle--;
			}
			middle = (low+high)/2;
		}
		
		if(low>high) {
			System.out.println("SearchNum is not found");
		}
	}
}