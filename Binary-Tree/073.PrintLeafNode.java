import java.util.*; 

// Print all leaf nodes of a Binary Tree from left to right


class PrintLeafNode {  
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

    PrintLeafNode() {
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

    public void printLeafNode(Node root) {
    	if(root == null) {
    		return;
    	}

        if(root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }

        printLeafNode(root.left);
        printLeafNode(root.right);

    }     

    public static void main(String[] args) {  
        PrintLeafNode tree = new PrintLeafNode();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.printLeafNode(tree.root);
    }  
};  
