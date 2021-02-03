import java.util.*;

// Sum of all elements between k1’th and k2’th smallest elements


class  SumBetween {

	static int sum(int[] arr, int k1, int k2) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int k = k2 - k1 - 1;
		int sum = 0;
		int num = 0;
		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		Iterator<Integer> it = heap.iterator();

		while(it.hasNext() == true && k1 > 0) {
			num = heap.poll();
			k1--;
		}

		while(it.hasNext() == true && k > 0) {
			num = heap.poll();
			k--;
			sum += num;
		}

		return sum;
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

        System.out.println("Sum of all elements between k1’th and k2’th " + 
        	" smallest elements enter value of k1 and k2");
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();

        System.out.println(sum(arr, k1, k2));
    }
}