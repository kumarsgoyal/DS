import java.util.*; 

// Write a function to Print Postorder traversal from given Preorder traversals of BST


class PostorderBSTPreorder {  
    int preIndex;

    PostorderBSTPreorder() {
        preIndex = 0;
    }

    public void postorderTreePrint(int[] pre, int min, int max, int size) {
        
        // pre order matrix finish
        if(preIndex == size) {
            return;
        }

        // this subtree doesn't belong to this range
        if(pre[preIndex] < min || pre[preIndex] > max) {
            return;
        }

        int val = pre[preIndex++];

        postorderTreePrint(pre, min, val, size);
        postorderTreePrint(pre, val, max, size);

        System.out.print(val + " ");

    } 

    public static void main(String[] args) {  
        PostorderBSTPreorder tree = new PostorderBSTPreorder();  
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

        tree.postorderTreePrint(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }  
};  
     