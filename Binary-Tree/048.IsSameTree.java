import java.util.*; 

// Check if given Preorder, Inorder and Postorder traversals are of same tree



class IsSameTree {  
    int preIndex;
    HashMap<Integer, Integer> hm;
    LinkedList<Integer> lt;

    IsSameTree() {
        preIndex = 0;
        hm = new HashMap<Integer, Integer> ();
        lt = new LinkedList<Integer>();
    }

    public void postorderTreePrint(int[] in, int[] pre, int start, int end, int size) {
        if(start > end) {
            return;
        }
        if(preIndex >= size) {
            return;
        }
        int inIndex = hm.get(pre[preIndex++]);

        // left tree
        postorderTreePrint(in, pre, start, inIndex - 1, size);

        // right tree
        postorderTreePrint(in, pre, inIndex + 1, end, size);

        lt.add(in[inIndex]);
        
    } 

    public void fillIndex(int[] in, int size) {
    	for(int i = 0; i < size; i++) {
    		hm.put(in[i], i);
    	}
    }  

    public boolean isOneTree(int[] post, LinkedList<Integer> lt) {
        int i = 0;
        for(; i < post.length && lt.size() > 0; i++) {
            int temp = lt.remove(i);
            if(temp != post[i]) {
                return false;
            }
        }

        if(lt.size() > 0) {
            return false;
        }
        return true;
    }  

    public static void main(String[] args) {  
        IsSameTree tree = new IsSameTree();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] pre = new int[size];
        int[] in = new int[size];
        int[] post = new int[size];

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

        System.out.println("Start entering elements of postorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            post[i] = num;
        }

        tree.fillIndex(in, size);
        tree.postorderTreePrint(in, pre, 0, size - 1, size);
        System.out.println(tree.isOneTree(post, tree.lt));
    }  
};  


     