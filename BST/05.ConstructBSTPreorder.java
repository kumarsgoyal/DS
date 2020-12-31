import java.util.*; 

// Construct BST from given preorder traversal | Set 1


class ConstructBSTPreorder {  

    Node root;
    int preIndex;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    ConstructBSTPreorder() {
        root = null;
        preIndex = 0;
    }

    public Node constructBSTPreorderUtil(int[] pre, int min, int max) {
        if(preIndex >= pre.length) {
            return null;
        }

        Node root = null;

        if(pre[preIndex] > min && pre[preIndex] < max) {
            root = new Node(pre[preIndex++]);
            root.left = constructBSTPreorderUtil(pre, min, root.data);
            root.right = constructBSTPreorderUtil(pre, root.data, max);
        }

        return root;
    }

    public void constructBSTPreorder(int[] pre) {
        if(pre.length == 0) {
            return;
        }

        root = constructBSTPreorderUtil(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    } 

    public void printPreOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {  
        ConstructBSTPreorder tree = new ConstructBSTPreorder();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] pre = new int[size];

        System.out.println("Start entering elements of preorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            pre[i] = num;
        }

        tree.constructBSTPreorder(pre);

        tree.printPreOrder(tree.root);
    }  
};  
     