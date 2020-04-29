import java.util.*; 

class PriorityqueueMinHeap { 

	public static void main(String args[]) 
	{ 
		// Min Heap 
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
		
		// Max Heap
		// PriorityQueue<Integer> pQueue =  
  		// 	new PriorityQueue<Integer>(Collections.reverseOrder()); 

		Scanner sc = new Scanner(System.in);

		System.out.println("Num of elements");
		int t = sc.nextInt(); // test cases
		System.out.println("Start Entering element");
		for(int i = 0; i < t; i++) {
			int num = sc.nextInt();
			pQueue.add(num);
		}

		// Printing the most priority element 
		System.out.println("Min value using peek function:" + pQueue.peek()); 

		// Printing all elements 
		System.out.println("The queue elements using iterator:"); 
		Iterator itr = pQueue.iterator(); 
		while (itr.hasNext()) 
			System.out.print(itr.next() + " ");
		System.out.print("\n");



		// Removing the top priority element (or head) and 
		// printing the modified pQueue using poll() 
		pQueue.poll(); 
		System.out.println("After removing an element with poll function:");

		Iterator<Integer> itr2 = pQueue.iterator(); 
		while (itr2.hasNext()) 
			System.out.print(itr2.next() + " "); 
		System.out.print("\n");

		// Removing num using remove() 
		System.out.println("Enter num to remove with remove function:"); 
		int rem = sc.nextInt();
		pQueue.remove(rem);
		Iterator<Integer> itr3 = pQueue.iterator(); 
		while (itr3.hasNext()) 
			System.out.print(itr3.next() + " "); 
		System.out.print("\n");

		// Check if an element is present using contains() 
		System.out.println("Enter the num to check Priority queue contains" +  
			"num or not?: "); 
		int con = sc.nextInt();
		boolean b = pQueue.contains(con); 
		System.out.println(b);

		// Getting objects from the queue using toArray() 
		// in an array and print the array 
		Object[] arr = pQueue.toArray(); 
		System.out.println("Value in array: "); 
		for (int i = 0; i < arr.length; i++) 
			System.out.println("Value: " + arr[i].toString()); 
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