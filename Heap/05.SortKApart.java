import java.util.*;

// Sort a nearly sorted (or K sorted) array
// Given an array of n elements, where each element is at most k away from its
// target position, devise an algorithm that sorts in O(n log k) time. 

// O(nLogk) time and uses O(k) auxiliary space.




class  SortKApart {

	static void sort(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int len = arr.length;

		for(int i = 0; i <= k && i < len; i++) {
			heap.add(arr[i]);
		}

		int index = 0;

		for(int i = k + 1; i < len; i++) {
			arr[index++] = heap.poll();
			heap.add(arr[i]);
		}

		Iterator<Integer> it = heap.iterator();

		while(it.hasNext() == true) {
			arr[index++] = heap.poll();
		}

	}

	static void print(int[] arr) {
		System.out.print("\n[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of element in arr");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Start entering elements");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
        	arr[i] = num;
        }

        System.out.println("Enter value of k");
        int k = sc.nextInt();
        System.out.println("Before sorting: ");
        print(arr);

        sort(arr, k);

        System.out.println("After sorting");
        print(arr);
    }
}