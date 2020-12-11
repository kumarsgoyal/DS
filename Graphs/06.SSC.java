import java.util.*; 
  

// Strongly Connected Components
// Kosaraju’s algorithm.

/*
    1) Create an empty stack ‘S’ and do DFS traversal of a graph. In DFS 
     traversal, after calling recursive DFS for adjacent vertices of a vertex,
     push the vertex to stack. In the above graph, if we start DFS from 
     vertex 0, we get vertices in stack as 1, 2, 4, 3, 0.
    2) Reverse directions of all arcs to obtain the transpose graph.
    3) One by one pop a vertex from S while S is not empty. Let the popped 
     vertex be ‘v’. Take v as source and do DFS (call DFSUtil(v)). The DFS
     starting from v prints strongly connected component of v. In the above
     example, we process vertices in order 0, 3, 4, 2, 1 
     (One by one popped from stack).
*/

class SSC { 

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

    public SSC getTranspose() {
        SSC rev = new SSC();
        rev.intialize(V);

        for(int i = 0; i < V; i++) {
            Iterator<Integer> it = graph.get(i).iterator();
            while(it.hasNext() == true) {
                rev.graph.get(it.next()).add(i);
            }
        }

        return rev;
    }

    public void fillOrder(int u, boolean[] visited, Stack<Integer> stk) {
        visited[u] = true;

        Iterator<Integer> it = graph.get(u).iterator();

        while(it.hasNext() == true) {
            int v = it.next();
            if(visited[v] == false) 
                fillOrder(v, visited, stk);
        }

        stk.push(u);
    }

    public void DFSUtil(int u, boolean[] visited) {
        visited[u] = true;

        System.out.print(u + " "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> it = graph.get(u).iterator(); 
        while (it.hasNext() == true) 
        { 
            int n = it.next(); 
            if (visited[n] == false)  
                DFSUtil(n,visited); 
        } 
    }

    public void ssc() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stk = new Stack<> ();

        // fill stack using finish time
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) 
                fillOrder(i, visited, stk);
        }

        // get reverse graph
        SSC gr = getTranspose();

        visited = new boolean[V];

        System.out.println("");
        while(stk.isEmpty() == false) {
            int x = stk.pop();

            if(visited[x] == false) {
                gr.DFSUtil(x, visited); 
                System.out.println(":"); 
            }
        }
    }

    public static void main(String[] args) {  
        SSC g = new SSC();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.ssc();
    }  
};  
