import java.util.*; 
  

// Count all possible paths between two vertices

/*
    The problem can be solved using backtracking, that says take a path and 
    start walking on it and check if it leads us to the destination vertex then
     count the path and backtrack to take another path. If the path doesn’t 
    lead to the destination vertex, discard the path.
    This type of graph traversal is called Backtracking.

    Note: Solution will not work for graph having cycle. 
*/




class GetPathCount { 

    List<List<Integer>> graph;
    int V;
    Scanner sc = new Scanner(System.in);
    int count;

    public void intialize(int v) {
        count = 0;
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

    public void dfs(int start, int end) {

        if(start == end) {
            count++;
            return;
        }

        for(int i : graph.get(start)) 
            dfs(i, end);
    }

    public void getPathCount() {
        
        System.out.println("Enter start point");
        int start = sc.nextInt();
        System.out.println("Enterend point");
        int end = sc.nextInt();

        dfs(start, end);

        System.out.println(count);
    }

    public static void main(String[] args) {  
        GetPathCount g = new GetPathCount();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.getPathCount();
    }  
};  
