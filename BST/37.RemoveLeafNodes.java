import java.util.*; 

// Remove all leaf nodes from the binary search tree


class RemoveLeafNodes {  

    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

        boolean isLeaf() {
            if(left == null && right == null) {
                return true;
            }
            return false;
        }
    }

    RemoveLeafNodes() {
        root = null;
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

    public Node removeLeafNodesUtil(Node root) {
        if(root == null) {
            return null;
        }   

        if(root.isLeaf() == true) {
            return null;
        }

        root.left = removeLeafNodesUtil(root.left);
        root.right = removeLeafNodesUtil(root.right);

        return root;
    }

    public Node removeLeafNodes() {
        if(root == null) {
            return null;
        }
        
        return removeLeafNodesUtil(root);
    }

    public static void main(String[] args) {  
        RemoveLeafNodes tree = new RemoveLeafNodes();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrder(tree.root);
        System.out.println("");

        tree.root = tree.removeLeafNodes();

        tree.inOrder(tree.root);
        System.out.println("");
    }   
};  
     