import java.util.*;


class DirectedGraphBFS {

	static void arrayList(ArrayList<ArrayList<Integer>> graph, int size) {
		for(int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}

	static void BFS(ArrayList<ArrayList<Integer>> graph) {
		int arr[] = new int[graph.size()];
		Queue<Integer> que = new LinkedList<Integer>();


		for(int i = 0; i < graph.size(); i++) {
			if(arr[i] == 0  && graph.get(i).size() != 0) {
				arr[i] = 1;
				que.add(i);
				// count++ for no. of component
			}

			while(que.size() != 0) {
				int temp = que.poll();
				System.out.print(temp + " ");

				for(int j = 0; j < graph.get(temp).size(); j++) {
					if(arr[graph.get(temp).get(j)] == 0) {
						arr[graph.get(temp).get(j)] = 1;
						que.add(graph.get(temp).get(j));
					}
				}
			}
		}
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of vertex");
		int vsize = sc.nextInt();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>> ();

		arrayList(graph, vsize);
		
		System.out.println("Enter the number of edge");
		int edge = sc.nextInt();
		
		for(int i = 0; i < edge; i++) {
			System.out.println("Enter the vextex no to vertex no");
			Integer u = sc.nextInt();
			Integer v = sc.nextInt();
			addedge(graph, u, v);
		}


		BFS(graph);
		

	}
}


/*
 // test case

 11 // no. of vertex
 13 // no. of edge

 1. 2
 2. 3,4
 3. 1
 4. 5
 5. 6
 6. 4
 7. 6, 8
 8. 9
 9. 10
 10. 11, 7
*/
