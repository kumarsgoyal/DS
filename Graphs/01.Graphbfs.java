import java.util.*; 
  

// bfs for directed graph

class Graphbfs { 

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
        }
    }

    public void bfs(int u) {
        boolean[] visited = new boolean[u];
        Queue<Integer> que = new LinkedList<> ();
        
        for(int i = 0; i < u; i++) {

            if(visited[i] == false && graph.get(i).size() != 0) {
                que.add(i);
                visited[i] = true;
            
                while(que.isEmpty() == false) {
                    int x = que.remove();
                    System.out.print(x + " ");
                    
                    Iterator<Integer> it = graph.get(x).iterator();
                    
                    while(it.hasNext() == true) {
                        x = it.next();
                        if(visited[x] == false) {
                            visited[x] = true;
                            que.add(x);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {  
        Graphbfs g = new Graphbfs();  

        System.out.println("Enter no of vertex: ");
        int u = g.sc.nextInt();
        System.out.println("Enter no of edges: ");
        int v = g.sc.nextInt();

        g.intialize(u);
        g.addEdge(u, v);
        g.bfs(u);
    }  
};  
