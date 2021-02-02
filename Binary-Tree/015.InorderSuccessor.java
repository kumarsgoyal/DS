import java.util.*; 

// Write a function to find Inorder Successor for given nodes

class InorderSuccessor {  

    Node root;
    Node prev;
    int inSuccessor;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    InorderSuccessor() {
        root = null;
        prev = null;
        inSuccessor = -1;
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



    public void inorderSuccessor(Node root, int x) {
        if(root == null) {
            return;
        }

        inorderSuccessor(root.right, x);

        if(root.data == x) {
            if(prev != null) 
                inSuccessor = prev.data;
        }

        prev = root;

        inorderSuccessor(root.left, x);

    } 
    

    public static void main(String[] args) {  
        InorderSuccessor tree = new InorderSuccessor();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preorderTreePrint(tree.root);

        System.out.println("\nEnter the value to find inorder successor: ");
        int x = sc.nextInt();
        tree.inorderSuccessor(tree.root, x);
        System.out.println(tree.inSuccessor);
    }  
};  
     