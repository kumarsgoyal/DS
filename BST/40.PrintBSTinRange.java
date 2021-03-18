import java.util.*; 

// Print BST keys in the given range


class PrintBSTinRange {  

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

    PrintBSTinRange() {
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

    public void printBSTinRangeUtil(Node root, int low, int high) {
        if(root == null) {
            return;
        }   

        printBSTinRangeUtil(root.left, low, high);

        if(root.data >= low && root.data <= high) {
            System.out.print(root.data + " ");
        }

        printBSTinRangeUtil(root.right, low, high);

    }

    public void printBSTinRange(int x, int y) {
        if(root == null) {
            return;
        }
        
        printBSTinRangeUtil(root, x, y);
        
    }

    public static void main(String[] args) {  
        PrintBSTinRange tree = new PrintBSTinRange();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter range to find bst: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        tree.printBSTinRange(x, y);

    }   
};  
     