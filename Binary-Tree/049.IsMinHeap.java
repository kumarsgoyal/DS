import java.util.*; 

// Given level order traversal of a Binary Tree, check if the Tree is a Min-Heap



class IsMinHeap {  

    IsMinHeap() {
    }

    public boolean isMinHeap(int[] level, int n) {
  
        // First non leaf node is at index (n/2-1). 
        // Check whether each parent is greater than child 
        for (int i = (n / 2 - 1); i >= 0; i--) { 
            // Left child will be at index 2*i+1 
            // Right child will be at index 2*i+2 
            if (level[i] > level[2 * i + 1]) 
                return false; 
  
            if ((2 * i + 2) < n) { 
                // If parent is greater than right child 
                if (level[i] > level[2 * i + 2]) 
                    return false; 
            } 
        } 
        return true;
        
    }  

    public static void main(String[] args) {  
        IsMinHeap tree = new IsMinHeap();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] level = new int[size];

        System.out.println("Start entering elements of level order: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            level[i] = num;
        }

        System.out.println(tree.isMinHeap(level, size));
    }  
};  
     