import java.util.*; 
  
// Find k-cores of an undirected graph


class kCores { 

    List<List<Integer>> graph;
    int V;
    Scanner sc = new Scanner(System.in);

    public void intialize(int v) {
        V = v;
        graph = new ArrayList<List<Integer>> ();

        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer> ());
        }
    } 

    public void addEdge(int e) {
        System.out.println("Enter edges from u to v and weight");

        for(int i = 0; i < e; i++) { 
            int from = sc.nextInt(); 
            int to = sc.nextInt(); 

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }

    public boolean dfs(int u, boolean[] visited, int[] degree, int k) {
        visited[u] = true;

        for(int i : graph.get(u)) {

            if(degree[u] < k) 
                degree[i]--;

            if(visited[i] == false) {
                if(dfs(i, visited, degree, k)) 
                    degree[u]--;
            }
        }

        return degree[u] < k;
    }

    public void kCores(int k) {
        boolean[] visited = new boolean[V];
        int[] degree = new int[V];

        int ele = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < V; i++) {
            degree[i] = graph.get(i).size();

            if(degree[i] < min) {
                min = degree[i];
                ele = i;
            }
        }

        dfs(ele, visited, degree, k);

        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                dfs(i, visited, degree, k); 
  
        // PRINTING K CORES 
        System.out.println("K-Cores : "); 
        for (int i = 0; i < V; i++) { 

            // Only considering those vertices which have degree  
            if (degree[i] >= k) { 
                System.out.print(i + " -"); 
  
                // Traverse adjacency list of v and print only 
                // those adjacent which have vDegree >= k after 
                // BFS. 
                for (int v : graph.get(i)) 
                    if (degree[v] >= k) 
                        System.out.print(" -> " + v); 
            } 
        } 


    }

    public static void main(String[] args) {  
        kCores g = new kCores();  

        System.out.println("Enter no of vertex: "); 
        int v = g.sc.nextInt(); 
        System.out.println("Enter no of edges: "); 
        int e = g.sc.nextInt(); 

        g.intialize(v); 
        g.addEdge(e); 
        
        System.out.println("Enter no of cores: "); 
        int k = g.sc.nextInt();         
        g.kCores(k);
    }  
};  

/*
// test case
9

17

0
1
0
2
1
2
1
5
2
3
2
4
2
5
2
6
3
4
4
6
3
7
4
6
4
7
5
6
5
8
6
7
6
8

3
*/