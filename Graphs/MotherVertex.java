/*
	Mother vertex in graph is vertex from which we can reach each vertex of graph.

	Case 1:- Undirected Connected Graph : In this case, all the vertices are mother vertices as we can reach to all the other nodes in the graph.
	Case 2:- Undirected/Directed Disconnected Graph : In this case, there is no mother vertices as we cannot reach to all the other nodes in the graph.
	Case 3:- Directed Connected Graph : In this case, we have to find a vertex -v in the graph such that we can reach to all the other nodes in the graph through a directed path.

	if there is more than one Strongly connected component there is no mother vertex.
*/

import java.util.*;


class MotherVertex {

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

	static void DFSUtil(ArrayList<ArrayList<Integer>> graph, boolean visted[], int index) {
		visted[index] = true;

		for(int i = 0; i < graph.get(index).size(); i++) {
			if(visted[graph.get(index).get(i)] == false) {
				DFSUtil(graph, visted, graph.get(index).get(i));
			}
		}
	}
	static int FindMotherVertex(ArrayList<ArrayList<Integer>> graph) {
		int size = graph.size();
		boolean visted[] = new boolean[size];

		int mVertex = 0;

		for(int i = 1; i < size; i++) {
			if(visted[i] == false) {
				DFSUtil(graph, visted, i);

				mVertex = i;
			}
		}

		visted = new boolean[size];
		DFSUtil(graph, visted, mVertex);

		for(int i = 1; i < size; i++) {
			if(visted[i] == false) {
				return -1;
			}
		}

		return mVertex;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of vertex");
		int vsize = sc.nextInt();

		ArrayList<ArrayList<Integer>> graph =
			 new ArrayList<ArrayList<Integer>> ();

		arrayList(graph, vsize+1);
		
		System.out.println("Enter the number of edge");
		int edge = sc.nextInt();
		
		for(int i = 0; i < edge; i++) {
			System.out.println("Enter the vextex no to vertex no");
			Integer u = sc.nextInt();
			Integer v = sc.nextInt();
			addedge(graph, u, v);
		}


		System.out.println(FindMotherVertex(graph));
		

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
