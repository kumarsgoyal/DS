import java.util.*;

// Minimum sum of two numbers formed from digits of an array

// Given an array of digits (values are from 0 to 9), find the minimum possible
// sum of two numbers formed from digits of the array. All digits of given
// array must be used to form the two numbers.






class  MinimumSum {

	static int minimumSum(int[] arr) {
		int sum1 = 0;
		int sum2 = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		Iterator<Integer> it = heap.iterator();

		while(it.hasNext() == true) {
			sum1 = (sum1 * 10) + heap.poll();

			if(it.hasNext() == true) {
				sum2 = (sum2 * 10) + heap.poll();
			}
		}

		return sum1 + sum2;
	}

	static void print(int[] arr, int size) {
		System.out.print("\n[");
		for(int i = 0; i < size; i++) {
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

        System.out.println(minimumSum(arr));
    }
}