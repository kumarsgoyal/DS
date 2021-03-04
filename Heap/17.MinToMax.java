import java.util.*;

// Convert min Heap to max Heap

class  MinToMax {

	static PriorityQueue minToMax(PriorityQueue<Integer> heap) {
		PriorityQueue<Integer> heap1 = new PriorityQueue<>(Collections.reverseOrder());

		Iterator<Integer> it1 = heap.iterator();
		while(it1.hasNext() == true) {
			heap1.add(heap.poll());
		}

        return heap1;
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        System.out.println("Enter the number of element in heap : ");
        int size = sc.nextInt();
        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            heap.add(num);
        }

        System.out.print("Before convertion");
        System.out.println(heap);
        heap = minToMax(heap);
        System.out.print("After convertion");
        System.out.println(heap);
    }
}