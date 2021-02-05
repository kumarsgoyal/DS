import java.util.*; 
  

// Detect Cycle in a Directed Graph


class DetectCycle { 

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


    public boolean detectCycleUtil(int v, boolean[] visited, boolean[] recStack) {
        if(recStack[v] == true) 
            return true;
        if(visited[v] == true) 
            return false;

        visited[v] = true;
        recStack[v] = true;

        for(int i : graph.get(v)) 
            if(detectCycleUtil(i, visited, recStack) == true) 
                return true;


        recStack[v] = false;

        return false;
    }

    public boolean detectCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i = 0; i < V; i++) 
            if(detectCycleUtil(i, visited, recStack) == true) 
                return true;

        return false;
    }

    public static void main(String[] args) {  
        DetectCycle g = new DetectCycle();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        if(g.detectCycle() == true) 
            System.out.println("Cycle is present");
        else 
            System.out.println("Cycle is not present");
    }  
};  
