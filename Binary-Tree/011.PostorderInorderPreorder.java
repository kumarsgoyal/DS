import java.util.*; 

// Write a function to Print Postorder traversal from given Inorder and Preorder traversals


class PostorderInorderPreorder {  
    int preIndex;
    HashMap<Integer, Integer> hm;

    PostorderInorderPreorder() {
        preIndex = 0;
        hm = new HashMap<Integer, Integer> ();
    }

    public void postorderTreePrint(int[] in, int[] pre, int start, int end) {
        if(start > end) {
            return;
        }
        
        int inIndex = hm.get(pre[preIndex++]);

        // left tree
        postorderTreePrint(in, pre, start, inIndex - 1);

        // right tree
        postorderTreePrint(in, pre, inIndex + 1, end);

        System.out.print(in[inIndex] + " ");
        
    } 

    public void fillIndex(int[] in, int size) {
    	for(int i = 0; i < size; i++) {
    		hm.put(in[i], i);
    	}
    }    

    public static void main(String[] args) {  
        PostorderInorderPreorder tree = new PostorderInorderPreorder();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] pre = new int[size];
        int[] in = new int[size];

        System.out.println("Start entering elements of preorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            pre[i] = num;
        }

        System.out.println("Start entering elements of inorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            in[i] = num;
        }

        tree.fillIndex(in, size);
        tree.postorderTreePrint(in, pre, 0, size - 1);
    }  
};  
     