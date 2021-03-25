import java.util.*; 

// Check if removing an edge can divide a Binary Tree in two halves



class CutTree {  

    Node root;
    boolean flag;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    CutTree () {
        root = null;
        flag = false;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data <= num) {
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

    public int count(Node root) {
        if(root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }   

    public int cutTreeUtil(Node root, int size) {
        if(root == null) {
            return 0;
        }

        int c = cutTreeUtil(root.left, size) + cutTreeUtil(root.right, size) + 1;

        if(c == size - c) {
            flag = true;
        }

        return c;
    }

    public boolean cutTree() {
        if(root == null) {
            return true;
        } 
        int size = count(root);
        int temp = cutTreeUtil(root, size);
        return flag;

    }

    public static void main(String[] args) {  
        CutTree tree = new CutTree();  
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

        if(tree.cutTree() == true) { 
            System.out.println("Yes"); 
        } 
        else { 
            System.out.println("No"); 
        }
    }  
};  
     