import java.util.*; 

// Write a function to Convert a given tree to its Sum Tree


class ConvertToSumTree {  

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

    ConvertToSumTree() {
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

    public int convertToSumTreeUtil(Node root) {
    	if(root == null) {
    		return 0;
    	}

    	int temp = root.data;
    	int l = convertToSumTreeUtil(root.left);
    	int r = convertToSumTreeUtil(root.right);

    	root.data = l + r;
    	return temp + root.data;
    	// return temp + l + r;
    }

    public void convertToSumTree() {
        if(root == null) {
            return;
        }
        
        int result = convertToSumTreeUtil(root);
    }
    
    public void preOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderPrint(root.left);   
        preOrderPrint(root.right);
    }

    public static void main(String[] args) {  
        ConvertToSumTree tree = new ConvertToSumTree();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }


        tree.preOrderPrint(tree.root);
        System.out.println("");

        tree.convertToSumTree();

        tree.preOrderPrint(tree.root);
        System.out.println("");
    }  
};  
     