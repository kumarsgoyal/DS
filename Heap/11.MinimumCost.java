import java.util.*;

// Connect n ropes with minimum cost


class  MinimumCost {

	static int minimumCost(int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int res = 0;
		int num = 0;
		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		Iterator<Integer> it = heap.iterator();

		while(it.hasNext() == true) {
			num = heap.poll();
			if(it.hasNext() == true) {
				num = num + heap.poll();
				res += num;
				heap.add(num);
			}
		}

		return res;
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

        System.out.println(minimumCost(arr));
    }
}