import java.util.*; 

// Print path from root to a given node in a binary tree


class PrintPath {  
    Node root;
    Vector<Integer> vec;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    PrintPath() {
        root = null;
        vec = new Vector<>();
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

    public boolean getPath(Node root, int num) {
    	if(root == null) {
    		return false;
    	}

        vec.add(root.data);

        if(root.data == num) {
            return true;
        }

        if(getPath(root.left, num) || getPath(root.right, num)) {
            return true;
        }

        vec.removeElement(root.data);
    	
        return false;
    }     

    public static void main(String[] args) {  
        PrintPath tree = new PrintPath();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        System.out.println("Enter a num from tree");
        int num = sc.nextInt();
        tree.getPath(tree.root, num);
        System.out.println(tree.vec);
    }  
};  
