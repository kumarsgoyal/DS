import java.util.*; 
  

// Transitive Closure of a Graph using DFS


/*
    1) Create a matrix tc[V][V] that would finally have transitive closure of 
    given graph. Initialize all entries of tc[][] as 0.
    2) Call DFS for every node of graph to mark reachable vertices in tc[][].
    In recursive calls to DFS, we don’t call DFS for an adjacent vertex if it 
    is already marked as reachable in tc[][].
*/

class TransitiveClosure { 

    List<List<Integer>> graph;
    int V;
    Scanner sc = new Scanner(System.in);

    public void intialize(int v) {
        V = v;
        graph = new ArrayList<List<Integer>>();

        for(int i = 0; i < v; i++) 
            graph.add(new ArrayList<Integer> ());
    } 

    public void addEdge(int e) {
        System.out.println("Enter edges from u to v");

        for(int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.get(from).add(to);
        }
    }

    public void dfs(int s, int v, int[][] tc) {
        tc[s][v] = 1;

        for(int i : graph.get(v)) {
            if(tc[s][i] == 0) {
                dfs(s, i, tc);
            }
        }
    }

    public void transitiveClosure() {
        int[][] tc = new int [V][V];

        for(int i = 0; i < V; i++) 
            dfs(i, i, tc);

        for(int[] arr : tc) {
            for(int i : arr) 
                System.out.print(i + " ");
            System.out.println("");
        }
    }

    public static void main(String[] args) {  
        TransitiveClosure g = new TransitiveClosure();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.transitiveClosure();
    }  
};  
