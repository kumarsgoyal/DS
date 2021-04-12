import java.util.*; 

// Print middle level of perfect binary tree without finding height


class MiddleLevel {  
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

    MiddleLevel() {
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

    public void middleLevelUtil(Node a, Node b) { 
        if(a == null || b == null) { 
            return; 
        } 

        if(b.left == null && b.right == null) { 
            System.out.print(a.data + " "); 
            return; 
        } 

        middleLevelUtil(a.left, b.left.left); 
        middleLevelUtil(a.right, b.left.left); 
    }

    public void middleLevel(Node root) {
    	if(root == null) {
    		return;
    	}
        middleLevelUtil(root, root);
    }     

    public static void main(String[] args) {  
        MiddleLevel tree = new MiddleLevel();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.middleLevel(tree.root);
    }  
};  
