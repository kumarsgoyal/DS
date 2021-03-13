import java.util.*; 

// Change a Binary Tree so that every node stores sum of all nodes in left 
// subtree



class NodeLeftSum {  

    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    NodeLeftSum() {
        root = null;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else {
            root.left = addNode(root.left, num);
        }
        return root;
    }
    
    public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    public int nodeLeftSumUtil(Node root) {
        if(root == null){
            return 0;
        }

        int leftSum = nodeLeftSumUtil(root.left);
        int rightSum = nodeLeftSumUtil(root.right);

        root.data = leftSum + root.data;
        return root.data + rightSum; // root.data + left sum + right sum
    }

    public void nodeLeftSum() {
        int sum = nodeLeftSumUtil(root);
    }

    public static void main(String[] args) {  
        NodeLeftSum tree = new NodeLeftSum();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }


        tree.inOrderPrint(tree.root);
        System.out.println("");
        tree.nodeLeftSum();
        tree.inOrderPrint(tree.root);
    }  
};  
     