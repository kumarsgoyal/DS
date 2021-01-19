import java.util.*; 

// Write a function to Replace each node in binary tree with the sum of its 
// inorder predecessor and successor



class InorderPredecessorSuccessor {  

    Node root;
    Vector vec;
    int inIndex;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    InorderPredecessorSuccessor() {
        root = null;
        inIndex = 1;
        vec = new Vector();
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

    public void preorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        System.out.print(temp.data + " ");
        preorderTreePrint(temp.left);
        preorderTreePrint(temp.right);
    }

    public void storeInorder(Node root) {
        if(root == null) {
            return;
        }
        storeInorder(root.left);
        vec.add(root.data);
        storeInorder(root.right);
    }

    public void replacePredecessorSuccessor(Node root) {
        if(root == null) {
            return;
        }

        replacePredecessorSuccessor(root.left);
        root.data = (Integer)vec.get(inIndex - 1) + (Integer)vec.get(inIndex + 1);
        inIndex++;
        replacePredecessorSuccessor(root.right);
    }

    public void inorderPredecessorSuccessor() {
        if(root == null) {
            return;
        }

        vec.add(0);
        storeInorder(root);
        vec.add(0);

        replacePredecessorSuccessor(root);
    } 
    

    public static void main(String[] args) {  
        InorderPredecessorSuccessor tree = new InorderPredecessorSuccessor();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preorderTreePrint(tree.root);
        System.out.println("");
        tree.inorderPredecessorSuccessor();
        tree.preorderTreePrint(tree.root);
    }  
};  
     