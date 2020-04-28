import java.util.*;


class TransitiveClosureFloydWarshallAlgo {

	static void addedge(boolean graph[][], int u, int v) {
		graph[u][v] = true;
	}

	static void ShowGraph(boolean graph[][], int size) {
		for(int i = 1 ; i < size; i++) {
			for(int j = 1; j < size; j++) {
				if(graph[i][j] == true)
					System.out.print(1 + " ");
				else 
					System.out.print(0 + " ");
			}
			System.out.print("\n");
		}
	}

	static void FindTransitive(boolean  graph[][], int size) {
		boolean trans[][] = new boolean[size][size];

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				trans[i][j] = graph[i][j];
			}
		}

		for(int k = 0; k < size; k++) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					trans[i][j] = trans[i][j] || (trans[i][k] && trans[k][j]);
				}
			}
		}

		ShowGraph(trans, size);


	}	

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of vertex");
		int vsize = sc.nextInt();
		vsize += 1;

		boolean graph[][] = new boolean[vsize][vsize];
		
		System.out.println("Enter the number of edge");
		int edge = sc.nextInt();
		
		for(int i = 0; i < edge; i++) {
			System.out.println("Enter the vextex no to vertex no");
			Integer u = sc.nextInt();
			Integer v = sc.nextInt();
			addedge(graph, u, v);
		}


		FindTransitive(graph, vsize);
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
