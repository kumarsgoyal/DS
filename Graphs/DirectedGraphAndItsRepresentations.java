import java.util.*;


class DirectedGraphAndItsRepresentations {

	static void arrayList(ArrayList<ArrayList<Integer>> graph, int size) {
		for(int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
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
