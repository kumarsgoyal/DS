import java.util.*; 

// Print the nodes at odd levels of a tree


class OddLevelNodes {  
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

    OddLevelNodes() {
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

    public void oddLevelNodes(Node root, boolean isOdd) {
    	if(root == null) {
    		return;
    	}

    	if(isOdd == true) {
    		System.out.print(root.data + "  ");
    	}

    	oddLevelNodes(root.left, !isOdd);
    	oddLevelNodes(root.right, !isOdd);
    }     

    public static void main(String[] args) {  
        OddLevelNodes tree = new OddLevelNodes();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.oddLevelNodes(tree.root, true);
    }  
};  
