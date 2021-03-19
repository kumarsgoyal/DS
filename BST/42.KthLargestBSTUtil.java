import java.util.*; 

// Find k-th Largest element in BST (Order Statistics in BST)


class KthLargestBST {  

    Node root;
    int count;
    int res;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

    }

    KthLargestBST() {
        root = null;
        count = 0;
        res = -1;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else if(root.data > num) {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);

        System.out.print(root.data + " ");

        inOrder(root.right);
    }

    public void kthLargestBSTUtil(Node root, int k) {
        if(root == null) {
            return;
        }   

        kthLargestBSTUtil(root.right, k);

        count++;
        if(count == k) {
            res = root.data;
        }

        kthLargestBSTUtil(root.left, k);

    }

    public void kthLargestBST(int k) {
        if(root == null) {
            return;
        }
        
        kthLargestBSTUtil(root, k);
        
    }

    public static void main(String[] args) {  
        KthLargestBST tree = new KthLargestBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter value of k to find kth largest element");
        int k = sc.nextInt();
        tree.kthLargestBST(k);

        if(tree.res != -1)
            System.out.println(tree.res);
    }   
};  
     