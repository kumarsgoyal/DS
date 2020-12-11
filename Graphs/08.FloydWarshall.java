import java.util.*; 
  

// Floyd Warshall Algorithm 
// The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. 
// The problem is to find shortest distances between every pair of vertices in 
// a given edge weighted directed Graph.

/*
    We initialize the solution matrix same as the input graph matrix as a first
    step. Then we update the solution matrix by considering all vertices as an 
    intermediate vertex. The idea is to one by one pick all vertices and 
    updates all shortest paths which include the picked vertex as an 
    intermediate vertex in the shortest path. When we pick vertex number k as 
    an intermediate vertex, we already have considered vertices 
    {0, 1, 2, .. k-1} as intermediate vertices. For every pair (i, j) of the 
    source and destination vertices respectively, there are two possible cases.
    
    1) k is not an intermediate vertex in shortest path from i to j. We keep 
    the value of dist[i][j] as it is.
    2) k is an intermediate vertex in shortest path from i to j. We update the
    value of 
    dist[i][j] == dist[i][k] + dist[k][j] if dist[i][j] > (dist[i][k] + dist[k][j])
*/

class FloydWarshall { 

    int [][] graph;
    int V;
    Scanner sc = new Scanner(System.in);

    public void intialize(int v) {
        V = v;
        graph = new int[v][v];
    } 

    public void addEdge(int e) {
        System.out.println("Enter edges from u to v and weight");

        for(int i = 0; i < e; i++) { 
            int from = sc.nextInt(); 
            int to = sc.nextInt(); 
            int weight = sc.nextInt(); 

            graph[from][to] = weight;
        }
    }


    public void shortestPath() {

        // shortest path from i to j via k;
        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {

                    if(graph[i][k] != Integer.MAX_VALUE && 
                        graph[k][j] != Integer.MAX_VALUE) {

                        graph[i][j] = Math.min( graph[i][j], graph[i][k] + graph[k][j]); 
                    }
                }
            }
        }


        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void floydWarshall() {
        
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i != j && graph[i][j] == 0) 
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }

        shortestPath();
    }

    public static void main(String[] args) {  
        FloydWarshall g = new FloydWarshall();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.floydWarshall();
    }  
};  
