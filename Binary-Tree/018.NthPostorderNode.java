import java.util.*; 

// Write a function to find nth node in postorder

class NthPostorderNode {  

    Node root;
    int count;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    NthPostorderNode() {
        root = null;
        count = 0;
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



    public void nthPostorderNode(Node root, int n) {
        if(root == null || count > n) {
            return;
        }

        nthPostorderNode(root.left, n);
        nthPostorderNode(root.right, n);

        count++;
        if(count == n) {
            System.out.println(root.data);
        }
    } 
    

    public static void main(String[] args) {  
        NthPostorderNode tree = new NthPostorderNode();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preorderTreePrint(tree.root);

        System.out.println("\nEnter the value of n ");
        int n = sc.nextInt();
        tree.nthPostorderNode(tree.root, n);
    }  
};  
     