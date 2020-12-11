import java.util.*; 
  

// Print all paths from a given source to a destination using DFS

/*
    1. The idea is to do Depth First Traversal of given directed graph.
    2. Start the DFS traversal from source.
    3. Keep storing the visited vertices in an array or HashMap say ‘path[]’.
`   4. If the destination vertex is reached, print contents of path[].
    5. The important thing is to mark current vertices in the path[] as visited
     also so that the traversal doesn’t go in a cycle.
*/




class GetPath { 

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

    public void dfs(int start, int end, Deque<Integer> path, boolean[] visited) {

        if(start == end) {
            path.addLast(start);
            System.out.println(path);
            path.pollLast();
            return;
        }

        visited[start] = true;

        path.addLast(start);

        for(int i : graph.get(start)) {
            if(visited[i] == false) {
                dfs(i, end, path, visited);
            }
        }

        path.pollLast();
        visited[start] = false;
    }

    public void getPath() {
        
        System.out.println("Enter start point");
        int start = sc.nextInt();
        System.out.println("Enterend point");
        int end = sc.nextInt();
        
        boolean[] visited = new boolean[V];
        Deque<Integer> path = new ArrayDeque<Integer> ();

        dfs(start, end, path, visited);

    }

    public static void main(String[] args) {  
        GetPath g = new GetPath();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.getPath();
    }  
};  
