import java.util.*; 

// Check sum of Covered and Uncovered nodes of Binary Tree

// Given a binary tree, you need to check whether sum of all covered elements 
// is equal to sum of all uncovered elements or not.

// In a binary tree, a node is called Uncovered if it appears either on left 
// boundary or right boundary. Rest of the nodes are called covered.



class CoveredUncoveredSum {  

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

    CoveredUncoveredSum () {
        root = null;
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

    public int sum(Node root) {
        if(root == null) {
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return (root.data + leftsum + rightsum);
    }

    public int rightUncoveredSum(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.right != null) {
            return root.data + rightUncoveredSum(root.right);
        }
        else {
            return root.data + rightUncoveredSum(root.left);
        }
    }

    public int leftUncoveredSum(Node root) {
        if(root == null) {
            return 0;
        }

        if(root.left != null) {
            return root.data + leftUncoveredSum(root.left);
        }
        else {
            return root.data + leftUncoveredSum(root.right);
        }
    }

    public int uncoveredSum(Node root) {
        int left = leftUncoveredSum(root.left);
        int right = rightUncoveredSum(root.right);

        return root.data + left + right;
    }

    public boolean coveredUncoveredSum() {
        if(root == null) {
            return true;
        } 

        int sumun = uncoveredSum(root);
        int sumtotal = sum(root);

        return (sumun == (sumtotal - sumun));

    }

    public static void main(String[] args) {  
        CoveredUncoveredSum tree = new CoveredUncoveredSum();  
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

        if(tree.coveredUncoveredSum() == true) { 
            System.out.println("Yes"); 
        } 
        else { 
            System.out.println("No"); 
        }
    }  
};  
     