import java.util.*;

// Maximum distinct elements after removing k elements
// Given an array arr[] containing n elements. The problem is to find maximum
// number of distinct elements (non-repeating) after removing k elements from
// the array.




class  MaximumDistinct {

	static int distinct(int[] arr, int k) {
		PriorityQueue<Integer> heap = 
			new PriorityQueue<>(Collections.reverseOrder());
		HashMap<Integer, Integer> map = new HashMap<>();

		// storing frequency of each element in map 
		for (int i = 0; i < arr.length; i++) { 
			if(map.containsKey(arr[i])) { 
				int val = map.get(arr[i]); 
				val++; 
				map.remove(arr[i]); 
				map.put(arr[i], val); 
			} 
			else {
				map.put(arr[i], 1); 
			}
		}

		// inserting frequency of each element in 'heap' 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
			heap.add(entry.getValue()); 
		}

		while(k > 0 && heap.size() != 0) {
			int temp = heap.poll();
			temp--;

			if(temp > 0) {
				heap.add(temp);
			}
			k--;
		}

		int res = 0; 
		int index = 0;
		while (heap.size() != 0) { 
			if(heap.poll() == 1) {
				res++; 
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

        System.out.println("Enter value of no. of operation to make elements" + 
        	" distinct");
        int k = sc.nextInt();

        print(arr, size);
        System.out.println(distinct(arr, k));
    }
}