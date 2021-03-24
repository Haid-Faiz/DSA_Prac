
class InsurtionSort{
	public static void main(String[] args) {
		System.out.println("Insurtion Sort algo");
		
		int [] arr = {5,1,6,8,10,2,45,3};
		int temp,j;

		for(int i=1; i<arr.length; i++) {
			
			temp = arr[i];
			j=i;
		
			while(j>0 && arr[j-1]>temp) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
		
		System.out.print("Sorted array:");
		for(int i: arr) {
			System.out.print(i +" ");
		}
		
	}
}