import java.util.*;


class UndirectedGraphAndItsRepresentations {

	static void arrayList(ArrayList<ArrayList<Integer>> graph, int size) {
		for(int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	static void showGraph(ArrayList<ArrayList<Integer>> graph) {
		System.out.println(graph);
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


		showGraph(graph);
		

	}
}


/*
 // test case

 5 // no. of vertex
 7 // no. of edge

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