import java.util.*; 

// Find the closest element in Binary Search Tree



class ClosestElement {  

    Node root;
    int minDiff;
    int minDiffkey;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    ClosestElement() {
        root = null;
        minDiff = Integer.MAX_VALUE;
        minDiffkey = -1;
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

    public  void closestElement(Node root, int x) {
        if(root == null) {
            return;
        }

        if(root.data == x) {
            minDiffkey = x;
            return;
        }

        if (minDiff > Math.abs(root.data - x)) 
        { 
            minDiff = Math.abs(root.data - x); 
            minDiffkey = root.data; 
        } 

        if(root.data > x) {
            closestElement(root.left, x);
        }
        else {
            closestElement(root.right, x);
        }

    }

    public static void main(String[] args) {  
        ClosestElement tree = new ClosestElement();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter element to find closest");
        int x = sc.nextInt();
        tree.closestElement(tree.root, x);

        System.out.println(tree.minDiffkey);
    }   
};  
     