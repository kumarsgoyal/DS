import java.util.*; 

// Convert a normal BST to Balanced BST


class BalancedBST {  

    Node root;
    Vector<Node> vec;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    BalancedBST() {
        root = null;
        vec = new Vector<>();
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

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void storeBst(Node root) {
        if(root == null) 
            return;
        storeBst(root.left);
        vec.add(root);
        storeBst(root.right);
    } 

    public Node balancedBSTUtil(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = vec.elementAt(mid);
        
        root.left = balancedBSTUtil(start, mid - 1);
        root.right = balancedBSTUtil(mid + 1, end);

        return root;
    }

    public  void balancedBST() {
        if(root == null) 
            return ;

        storeBst(root);
        // send start and end index
        root = balancedBSTUtil(0, vec.size() - 1);

    }

    public static void main(String[] args) {  
        BalancedBST tree = new BalancedBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preOrder(tree.root);
        System.out.println("");
        tree.balancedBST();

        tree.preOrder(tree.root);
    }  
};  
     