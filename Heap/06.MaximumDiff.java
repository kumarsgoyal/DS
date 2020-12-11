import java.util.*;

// Maximum difference between two subsets of m elements
// Given an array of n integers and a number m, find the maximum
// possible difference between two sets of m elements chosen from given array.



class  MaximumDiff {

	static int diff(int[] arr, int m) {
		int size = arr.length;
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		if(m > size) {
			return -1;
		}
		else if(m == size) {
			return 0;
		}

		int min = 0;
		int max = 0;

		for(int i = 0; i < size; i++) {
			heap.add(arr[i]);
		}

		Iterator<Integer> it = heap.iterator();
		int index = 0;
		int start = size - m;
		while(it.hasNext() == true) {
			if(index < m) {
				min += heap.peek();
			}
			if(index >= start) {
				max += heap.peek();
			}

			index++;
			heap.poll();
		}

		return max - min;

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

        System.out.println("Enter value of m no. of elements to make pair");
        int m = sc.nextInt();

        print(arr);
        System.out.println(diff(arr, m));
    }
}