// k largest(or smallest) elements in an array
import java.util.*; 
import java.lang.*; 
import java.io.*; 


class MaxHeap {
	private PriorityQueue<Integer> pQueue;
	
	MaxHeap () {
		pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	protected void addElement(int value) {
		pQueue.add(value);
	}

	protected void print() {
		System.out.println(pQueue);
	}

	protected int poll() {
		return pQueue.poll();
	}


}

class KthLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MaxHeap arr = new MaxHeap();

		System.out.println("Enter num of elements");
		int t = sc.nextInt();
		System.out.println("Enter elements");
		for(int i = 0; i < t; i++) {
			int num = sc.nextInt();
			arr.addElement(num);
		}

		int k = sc.nextInt();
		int temp = 0;
		for(int i = 0; i < k; i++) {
			temp = arr.poll();
		}

		System.out.println(temp);

	}
}





/*

10 // no of node in heap
10
20
35
30
23
19
25
15
39
40
*/
