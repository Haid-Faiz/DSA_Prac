/**
 * This class implements a data structure that always return the 
 * maximum value in a given collection of integers. Heap properties
 * will be used for this implementation
 * @author Aime Mbakop
 *
 */
public class MaxHeap {
	
	/**
	 * An array to stored the collection of integers
	 */
	private int[] intArray;
	
	/**
	 * The number of elements in the heap
	 */
	private int size = 0;
	
	/**
	 * Construct a MaxHeap object for a given number of elements
	 */
	public MaxHeap(int n) {
		
		intArray = new int[n];
	}
	
	/**
	 * This method is used to add/build the heap
	 * @param num the value to add to MaxHeap
	 */
	public void add(int num) {
		
		//Increase the capacity of the underlying array 
		//if needed
		if (size == intArray.length) {
			
			doubleLength();
		}
		
		intArray[size] = num;
		movingUp(size);
		size++;
	}
	
	/**
	 * This method removes and returns the maximum value
	 * in the collection while maintaining the heap structure 
	 * @return the max value in the MaxHeap
	 */
	public int getMax() {
		
		if (size == 0) {
			
			return 0;
		}
		int max = intArray[0];
		intArray[0] = intArray[size - 1];
		size--;
		movingDown(0);
		return max;
	}
	
	/**
	 * Helper method to move up the tree
	 * @param the index of the value to move up from
	 */
	private void movingUp(int index) {
		
		//In a full binary tree if a node is at index i
		//its parent is at index (i-1) / 2
		if (index == 0) {
			
			return;
		}
		int parIndex = (index - 1) / 2;
		if (intArray[parIndex] < intArray[index]) {
			
			swap(index, parIndex);
			movingUp(parIndex);
		}	
	}
	
	/**
	 * Helper method to move down the tree
	 * @param the index of the value to move down from
	 */
	private void movingDown(int index) {
		
		//In a full binary tree if a node is at index i
		//its left child is at index 2*i + 1
		//and its right child is at index 2*i + 2
		int descendent = 0;
		int leftChild = (index * 2) + 1;
		int rightChild = (index * 2) + 2;
		
		if (rightChild < size && intArray[rightChild] > intArray[leftChild]) {
			
			descendent = rightChild;
		}
		else if(leftChild < size) {
			
			descendent = leftChild;
		}
		else 
		{
			return;
		}
		
		if (intArray[index] < intArray[descendent]) {
			
			swap(index, descendent);
			movingDown(descendent);
		}
	}
	
	/**
	 * Helper method to swap two values in MaxHeap
	 * underlying array
	 * @param x, y the indices of the values to be swapped 
	 */
	private void swap(int x, int y) {
		
		int temp = intArray[x];
		intArray[x] = intArray[y];
		intArray[y] = temp;	
	}
	
	/**
	 * Helper method to double the length of
	 * MaxHeap underlying array
	 */
	private void doubleLength() {
		
		int[] arr = new int[intArray.length * 2];
		System.arraycopy(intArray, 0, arr, 0, size);
		intArray = arr;
	}
	
	/**
	 * Ideally I should have a separate file for testing
	 * but I just wanted to keep everything in one file
	 * Feel free to add more test cases 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] ar = {87, 52, 90, 45, 21};
		MaxHeap testing = new MaxHeap(10);
		for (int i = 0; i < ar.length; i++) {
			
			testing.add(ar[i]);
		}
		
		System.out.println("Maximum value: " + testing.getMax());
		System.out.println("Given array length: " + ar.length);
		System.out.println("Current MaxHeap size: " + testing.size);
		
		testing.add(250);
		System.out.println("New value added to the MaxHeap");
		System.out.println("New maximum value: " + testing.getMax());
		System.out.println("New maximum value: " + testing.getMax());
		System.out.println("New maximum value: " + testing.getMax());
		System.out.println("New maximum value: " + testing.getMax());
		System.out.println("Given array length: " + ar.length);
		System.out.println("Current MaxHeap size: " + testing.size);
	}
	
	/**
	 * Time complexity analysis:
	 * Initially constructing a MaxHeap from a given collection of integers
	 * is O(nlogn) since the initial collection of integers has to be
	 * traversed once, and adding an element to the Maxheap while 
	 * maintaining the heap structure is dependent on the height of the 
	 * complete binary tree. Thus the add operation is O(logn).
	 * Similarly removing and returning the maximum value from 
	 * MaxHeap while maintaining the heap structure is O(logn).
	 * Therefore, the overall time complexity for MaxHeap is O(nlogn).
	 */
	
}
