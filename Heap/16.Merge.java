import java.util.*;

// Merge two binary Max Heaps

class  Merge {

	static void merge(PriorityQueue<Integer> heap1, PriorityQueue<Integer> heap2) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

		Iterator<Integer> it1 = heap1.iterator();
		while(it1.hasNext() == true) {
			heap.add(heap1.poll());
		}

		Iterator<Integer> it2 = heap2.iterator();
		while(it2.hasNext() == true) {
			heap.add(heap2.poll());
		}

		System.out.println(heap);
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	PriorityQueue<Integer> heap1 = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> heap2 = new PriorityQueue<>(Collections.reverseOrder());
        
        System.out.println("Enter the number of element in heap 1: ");
        int size1 = sc.nextInt();
        System.out.println("Start entering elements: ");
        for(int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            heap1.add(num);
        }

        System.out.println("Enter the number of element in heap 2: ");
        int size2 = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size2; i++) {
            int num = sc.nextInt();
            heap2.add(num);
        }

        merge(heap1, heap2);
    }
}