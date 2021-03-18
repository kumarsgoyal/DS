import java.util.*; 

// Find k-th smallest element in BST (Order Statistics in BST)


class KthSmallestBST {  

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

    KthSmallestBST() {
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

    public void kthSmallestBSTUtil(Node root, int k) {
        if(root == null || count > k) {
            return;
        }   

        kthSmallestBSTUtil(root.left, k);

        count++;
        if(count == k) {
            res = root.data;
            return;
        }

        kthSmallestBSTUtil(root.right, k);

    }

    public void kthSmallestBST(int k) {
        if(root == null) {
            return;
        }
        
        kthSmallestBSTUtil(root, k);
        
    }

    public static void main(String[] args) {  
        KthSmallestBST tree = new KthSmallestBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter value of k to find kth smallest element");
        int k = sc.nextInt();
        tree.kthSmallestBST(k);

        if(tree.res != -1)
            System.out.println(tree.res);
    }   
};  
     