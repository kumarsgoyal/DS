import java.util.*; 
  

// bfs for undirected graph

class Graphdfs { 

    List<List<Integer>> graph;
    Scanner sc = new Scanner(System.in);

    public void intialize(int u) {
        graph = new ArrayList<List<Integer>>();

        for(int i = 0; i < u; i++) 
            graph.add(new ArrayList<Integer> ());
    } 

    public void addEdge(int u, int v) {
        System.out.println("Enter edges from u to v");

        for(int i = 0; i < v; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }

    public void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;

        System.out.print(u + " ");

        Iterator<Integer> it = graph.get(u).iterator();

        while(it.hasNext() == true) {
            int v = it.next();
            if(visited[v] == false) {
                dfsUtil(v, visited);
            }
        }
    }

    public void dfs(int u) {
        boolean[] visited = new boolean[u];
        
        for(int i = 0; i < u; i++) {
            if(visited[i] == false) {
                dfsUtil(i, visited);
            }
        }
    }

    public static void main(String[] args) {  
        Graphdfs g = new Graphdfs();  

        System.out.println("Enter no of vertex: ");
        int u = g.sc.nextInt();
        System.out.println("Enter no of edges: ");
        int v = g.sc.nextInt();

        g.intialize(u);
        g.addEdge(u, v);
        
        g.dfs(u);
    }  
};  
