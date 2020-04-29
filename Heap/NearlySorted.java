// k largest(or smallest) elements in an array
import java.util.*;

class NearlySorted {

	static PriorityQueue<Integer> pQueue = new PriorityQueue<Integer> ();

	static void addValue(int arr[], int size) {
		for(int i = 0; i < size; i++) {
			pQueue.add(arr[i]);
		}
	}

	static void nearlysort(int arr[], int size) {
		addValue(arr, size);

		for(int i = 0; i < size; i++) {
			arr[i] = pQueue.poll();
		}
	}

	static void print(int arr[], int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of Array");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the elements");
		for(int i = 0; i < size; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}

		nearlysort(arr, size);
		print(arr, size);


	}
}





/*

10 // no of node in heap
10
20
35
30
23
19
25
15
39
40
*/
