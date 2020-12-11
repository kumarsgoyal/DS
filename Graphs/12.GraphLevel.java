import java.util.*; 
  

// Count the number of nodes at given level in a tree using BFS.


class GraphLevel { 

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

    public void traversal() {
        boolean[] visited = new boolean[V];
		Queue<Integer> que = new LinkedList<> ();

		System.out.println("Enter node of root");
		int root = sc.nextInt();
		System.out.println("Enter level to find node at given level");
		int level = sc.nextInt();

		int flag = 0;

		visited[root] = true;
		que.add(root);

		while(que.isEmpty() == false) {
			int size = que.size();

			while(size > 0) {
				size--;

				root = que.remove();

				if(flag == level) 
					System.out.print(root + " ");

				if(flag < level) 
					for(int i : graph.get(root)) 
						if(visited[i] == false) 
							que.add(i);
			} 

			flag++;
		}

    }

    public static void main(String[] args) {  
        GraphLevel g = new GraphLevel();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        g.traversal();
    }  
};  
