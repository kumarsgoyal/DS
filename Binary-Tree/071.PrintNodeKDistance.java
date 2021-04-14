import java.util.*; 

// Print nodes at k distance from root

class PrintNodeKDistance {  
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

    PrintNodeKDistance() {
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

    public void printNodeKDistance(Node root, int d, int hd) {
    	if(root == null || hd > d) { 
    		return; 
    	} 

        if(hd == d) { 
            System.out.print(root.data + " "); 
            return; 
        } 

        printNodeKDistance(root.left, d, hd + 1); 
        printNodeKDistance(root.right, d, hd + 1); 
    }     

    public static void main(String[] args) {  
        PrintNodeKDistance tree = new PrintNodeKDistance();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        System.out.println("Enter distance from root to print elements");
        int d = sc.nextInt();
        tree.printNodeKDistance(tree.root, d, 0);
    }  
};  
