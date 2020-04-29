import java.util.*;

class isArrayHeap {

	// if it is array it is supposed that it is complete binary tree
	static boolean isHeapUtil(int arr[], int index, int size) {
		//if leaf node return true
		if(index > (size - 1) / 2) {
			return true;
		}

		if((index * 2 + 2) > size) {
			return (arr[index] >= arr[index * 2 + 1]);
		}

		// if internal node statisfy condtion
		else if((arr[index] >= arr[index * 2 + 1] && arr[index] >= arr[index * 2 + 2])
			&& isHeapUtil(arr, index * 2 + 1, size) &&
			 isHeapUtil(arr, index * 2 + 2, size)) {
			return true;
		}

		return false;
	}
	static void isHeap(int arr[], int size) {
		if(isHeapUtil(arr, 0, size) == true) {
			System.out.println("Heap");
		}
		else {
			System.out.println("Not Heap");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();	
		int arr[] = new int[size];

		System.out.println("Enter the Elements");
		for(int i = 0; i < size; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}

		isHeap(arr, size - 1);
	}
}

// 8
// 90, 15, 10, 7, 12, 2, 7, 3