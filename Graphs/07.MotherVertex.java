import java.util.*; 
  

// Find a Mother Vertex in a Graph using Kosaraju’s algorithm.

/*
    1) Do DFS traversal of the given graph. While doing traversal keep track of 
    last finished vertex ‘v’. This step takes O(V+E) time.
    2) If there exist mother vertex (or vertices), then v must be one 
    (or one of them). Check if v is a mother vertex by doing DFS/BFS from v.
    This step also takes O(V+E) time.
*/

class MotherVertex { 

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

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;

        Iterator<Integer> it = graph.get(v).iterator();

        while(it.hasNext() == true) {
            
            int x = it.next();
            if(visited[x] == false) 
                dfs(x, visited);
        }

    }

    public String motherVertex() {
        boolean[] visited = new boolean[V];
        int mv = -1;
        
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                dfs(i, visited);
                mv = i;
            }
        }

        visited = new boolean[V];
        dfs(mv, visited);

        for(boolean i : visited) {
            if(i == false) {
                return "No mother vertex";
            }
        }

        return "Mother vertex : " + mv;
    }

    public static void main(String[] args) {  
        MotherVertex g = new MotherVertex();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        System.out.println(g.motherVertex());
    }  
};  
