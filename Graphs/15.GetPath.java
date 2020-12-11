import java.util.*; 
  

// Print all paths from a given source to a destination using BFS


/*
    1. create a queue which will store path(s) of type vector
    2. initialise the queue with first path starting from src

    3. Now run a loop till queue is not empty
        get the frontmost path from queue
        check if the lastnode of this path is destination
            if true then print the path
        run a loop for all the vertices connected to the
        current vertex i.e. lastnode extracted from path
            if the vertex is not visited in current path
                a) create a new path from earlier path and 
                    append this vertex
                b) insert this new path to queue
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

    public boolean visitednode(int v, List<Integer> path) {
        for(int i : path) 
            if(i == v) 
                return true;
        return false;
    }

    public void bfs(int start, int end) {
        Queue<List<Integer>> que = new LinkedList<> ();
        List<Integer> intial = new ArrayList<> ();

        intial.add(start);
        que.add(intial);
        
        while(que.isEmpty() == false) {
            List<Integer> path = que.remove();

            int last = path.get(path.size() - 1);
            if(last == end) {
                System.out.println(path);
                continue;
            }

            for(int i : graph.get(last)) {
                if(visitednode(i, path) == false) {
                    List<Integer> newPath = new ArrayList<Integer> (path);
                    newPath.add(i);
                    que.add(newPath);
                }
            }

        }
        
    }

    public void getPath() {
        
        System.out.println("Enter start point");
        int start = sc.nextInt();
        System.out.println("Enterend point");
        int end = sc.nextInt();

        bfs(start, end);

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
