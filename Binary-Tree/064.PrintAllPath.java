import java.util.*; 

// Print root to leaf paths without using recursion


class PrintAllPath {  
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

    PrintAllPath() {
        root = null;
        vec = new Vector<Integer>();
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

    public void getPath(Node root) {
    	if(root == null) {
    		return;
    	}

        vec.add(root.data);

        if(root.left == null && root.right == null) {
            System.out.println(vec);
        }

        getPath(root.left);
        getPath(root.right);

        vec.removeElement(root.data);

    }     

    public static void main(String[] args) {  
        PrintAllPath tree = new PrintAllPath();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.getPath(tree.root);
    }  
};  
