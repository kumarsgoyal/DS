// Kosaraju Algo for Strongly Connected Graph

import java.util.*;


class StronglyConnectedGraph {

	static void Arraylist(ArrayList<Integer> graph[], int size) {
		for(int i = 0; i < size; i++) {
			graph[i] = new ArrayList<Integer> ();
		}
	}
	static void addedge(ArrayList<Integer> graph[], int u, int v) {
		graph[u].add(v);
	}

	static void showGraph(ArrayList<Integer> graph[]) {
		for(int i = 1; i < graph.length; i++) {
			if(graph[i].size() > 0) {
				System.out.println(i + " - " + graph[i]);
			}
		}
	}

	static void showGraph(ArrayList<ArrayList<Integer>> graph) {
		System.out.println(graph);
	}

	// here index a.k.a. vertex
	static void fillorder(ArrayList<Integer> graph[], int index,
		boolean visted[], Stack stack) {

		visted[index] = true;

		for(int i = 0; i < graph[index].size(); i++) {
			if(visted[graph[index].get(i)] == false) {
				fillorder(graph, graph[index].get(i), visted, stack);
			}
		}

		stack.push(index);
	}

	static ArrayList<Integer>[] GetTranspose(ArrayList<Integer> graph[]) {
		int size = graph.length;
		ArrayList<Integer> graph_reverse[] = new ArrayList [size];

		for(int i = 0; i < size; i++ ) {
			graph_reverse[i] = new ArrayList<Integer> ();
		}

		for(int i = 0; i < size; i++) {
			if(graph[i].size() > 0) {
				for(int j = 0; j < graph[i].size(); j++) {
					graph_reverse[graph[i].get(j)].add(i);
				}
			}
		}

		return graph_reverse;
	}

	static void DFSUtil(ArrayList<Integer> graph[], boolean visted[], 
		int vertex, ArrayList<Integer> componentArray) {
		visted[vertex] = true;
		componentArray.add(vertex);

		for(int i = 0; i < graph[vertex].size(); i++) {
			if(visted[graph[vertex].get(i)] == false) {
				DFSUtil(graph, visted, graph[vertex].get(i), componentArray);
			}
		}
	}

	static void PrintComponent(ArrayList<Integer> graph[], boolean visted[],
		Stack<Integer> stk) {

	ArrayList<ArrayList<Integer>> component = 
		new ArrayList<ArrayList<Integer>> ();

		while(stk.empty() == false) {
			int top = stk.pop();

			if(visted[top] == false && graph[top].size() > 0) {
				ArrayList<Integer> temp = new ArrayList<Integer> ();
				DFSUtil(graph, visted, top, temp); 
				component.add(temp);
			}

		}

		showGraph(component); 
	}
	static void SCC(ArrayList<Integer> graph[]) {

		// visted to mark vertex is visted or not
		int size = graph.length;
		boolean visted[] = new boolean[size];

		Stack stk = new Stack();

		for(int i = 1; i < size; i++) {
			if(visted[i] == false) {
				fillorder(graph, i, visted, stk);
			}
		}

		graph = GetTranspose(graph); 

		visted = new boolean[size];

		PrintComponent(graph, visted, stk);

	}


	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of vertex");
		int vsize = sc.nextInt();

    	ArrayList<Integer> graph[] = new ArrayList [vsize+1];

		Arraylist(graph, vsize+1);
		
		System.out.println("Enter the number of edge");
		int edge = sc.nextInt();
		
		for(int i = 0; i < edge; i++) {
			System.out.println("Enter the vextex no to vertex no");
			Integer u = sc.nextInt();
			Integer v = sc.nextInt();
			addedge(graph, u, v);
		}

		SCC(graph);
		
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

