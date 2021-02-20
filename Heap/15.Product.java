import java.util.*;

// Largest triplet product in a stream

class  Product {

	static int mul(int[] arr, int k) {
		if(arr.length < k) {
			System.out.println("Not sufficient element in heap");
			return -1;
		}

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		int result = 1;

		while(k > 0) {
			k--;
			result = result * heap.poll();
		}

		return result;

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

        System.out.println("Triplet Product: " + mul(arr, 3));
    }
}