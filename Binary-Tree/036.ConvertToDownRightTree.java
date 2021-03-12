import java.util.*; 

// Write a function to Convert left-right representation of a binary tree to 
// down-right


class ConvertToDownRightTree {  

    Node root;
    DownRight root1;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    class DownRight {
        int data;
        DownRight down;
        DownRight right;

        DownRight(int x) {
            data = x;
            down = right = null;
        }
    }

    ConvertToDownRightTree() {
        root = null;
        root1 = null;
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

    public DownRight convertToDownRightTreeUtil(Node root) {
    	if(root == null) {
    		return null;
    	}

        DownRight temp = new DownRight(root.data);

        if(root.left != null) {
            temp.down = convertToDownRightTreeUtil(root.left);
            temp.down.right = convertToDownRightTreeUtil(root.right);
        }
        else {
            temp.down = convertToDownRightTreeUtil(root.right);
        }

        return temp;
        
    }

    public void convertToDownRightTree() {
        if(root == null) {
            return;
        }
        
        root1 = convertToDownRightTreeUtil(root);
    }
    
    public void preOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderPrint(root.left);   
        preOrderPrint(root.right);
    }

    public void downRightPrint(DownRight root) {
        if(root == null) {
            return;
        }

        System.out.println(root.data);
        downRightPrint(root.right);
        downRightPrint(root.down);
    }

    public static void main(String[] args) {  
        ConvertToDownRightTree tree = new ConvertToDownRightTree();  
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

        tree.convertToDownRightTree();

        tree.downRightPrint(tree.root1);
        System.out.println("");
    }  
};  
     