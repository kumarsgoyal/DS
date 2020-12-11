import java.util.*; 
  

// Graph DFS traversal using stack


/*
    1) Created a stack of nodes and visited array.
    2) Insert the root in the stack.
    3) Run a loop till the stack is not empty.
    4) Pop the element from the stack and print the element.
    5) For every adjacent and unvsisted node of current node, mark the node and
        insert it in the stack.
*/

class Graphdfs { 

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

    public void dfsUtil(int v, boolean[] visited) {
        Stack<Integer> stk = new Stack<> ();

        stk.push(v);

        while(stk.isEmpty() == false) {
            v = stk.pop();

            if(visited[v] == false) {
                System.out.print(v + " ");
                visited[v] = true;

                for(int i : graph.get(v)) 
                    if(visited[i] == false) 
                        stk.push(i);
            }
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(visited[i] == false) 
                dfsUtil(i, visited);
        }
    }

    public static void main(String[] args) {  
        Graphdfs g = new Graphdfs();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.dfs();
    }  
};  
