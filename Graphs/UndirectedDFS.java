import java.util.*;


class UndirectedGraphDFS {

	static void arrayList(ArrayList<ArrayList<Integer>> graph, int size) {
		for(int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	static void DFS(ArrayList<ArrayList<Integer>> graph, int arr[], int index) {
		arr[index] = 1;
		System.out.print(index + " ");
		for(int i = 0; i < graph.get(index).size(); i++) {
			if(arr[graph.get(index).get(i)] == 0) {
				DFS(graph, arr, graph.get(index).get(i));
			}
		}
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of vertex");
		int vsize = sc.nextInt();

		// LinkedList<Integer> adj[]; or we can use array or linkedlist
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

		int arr[] = new int[graph.size()];

		for(int i = 1; i < graph.size(); i++) {
			if(arr[i] == 0) {
				DFS(graph, arr, i);		
			}
		}

	}
}


/*
 // test case


// no. of vertex
// no. of edge

 5 
 7

 0
 1

 0
 4

 1
 2

 1
 3

 1
 4

 2
 3

 3
 4


*/