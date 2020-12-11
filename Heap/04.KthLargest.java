import java.util.*;

// K’th Smallest/Largest Element in Unsorted Array | Set 1


class  KthLargest {

	static int findKth(int[] arr, int k) {
		int size = arr.length; // size or length of array
		int res = -1;

		// if kth value is less than 1 or more than size of arr
		// then kth value is out of bound;
		if(k > size || k < 1) {
			return res;
		}

		// max heap
		PriorityQueue<Integer> heap = new PriorityQueue<>(10, Collections.reverseOrder());

		for(int i = 0; i < size; i++) {
			heap.add(arr[i]);
		}

		for(int i = 0; i < k; i++) {
			res = heap.poll();
		}

		return res;
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of element in heap");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Start entering elements");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
        	arr[i] = num;
        }

        System.out.println("Enter value of k to find kth largest element");
        int k = sc.nextInt();
        System.out.println(findKth(arr, k));
    }
}