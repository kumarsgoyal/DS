import java.util.*;


class TransitiveClosure {

	static void arrayList(ArrayList<ArrayList<Integer>> graph, int size) {
		for(int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer> ());
		}
	}

	static void arrayList(ArrayList<ArrayList<Integer>> graph, int size, int size1) {
		for(int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer> (size1));
		}
	}

	static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}

	static void ShowGraph(ArrayList<ArrayList<Integer>> graph) {
		System.out.println(graph);
	}

	static void FindTransitive(ArrayList<ArrayList<Integer>> graph) {
		ArrayList<ArrayList<Integer>> trans = new ArrayList<ArrayList<Integer>> ();
		arrayList(trans, graph.size());

		for(int i = 0; i < graph.size(); i++) {
			for(int j = 0; j < graph.size(); j++) {
				trans.get(i).add(graph.get(i).get(j));
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


		FindTransitive(graph);
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
