import java.util.*;

// Minimum product of k integers in an array of positive Integers


class  Product {

	static int mul(int[] arr, int k) {
		int result = 1;
		int num = 1;
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		Iterator<Integer> it = heap.iterator();

		while(it.hasNext() == true && k > 0) {
			num = heap.poll();
			result = result * num;
			k--;
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

        System.out.println("Minimum product of k integers in an array of " + 
        	"positive Integers smallest elements enter value of k");
        int k = sc.nextInt();

        System.out.println(mul(arr, k));
    }
}