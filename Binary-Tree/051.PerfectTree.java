import java.util.*; 

// Check whether a given binary tree is perfect or not
// A Binary tree is Perfect Binary Tree in which all internal nodes have two 
// children and all leaves are at same level. (2^h-1) node where h is hieght.
//                10
//			   /       \  
// 			 20         30  
// 			/  \        /  \
// 		  40    50    60   70.  <- perfect 

//                10
//			   /       \  
// 			 20         30  
// 			/  \        /  
// 		  40    50    60     <-  not perfect perfect 




class PerfectTree {  

    Node root;
    int lv = 0;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    PerfectTree () {
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
    
    public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    public boolean perfectTree(Node root, int l) {
    	if(root == null) {
    		return true;
    	}

    	if(root.left == null && root.right == null) {
    		if(lv == 0) {
    			lv = l;
    			return true;
    		}
    		else {
    			return (lv == l);
    		}
    	}
    	if(root.left == null || root.right == null) {
    		return false;
    	}

    	return perfectTree(root.left, l + 1) && perfectTree(root.right, l + 1);

    }

    public static void main(String[] args) {  
        PerfectTree tree = new PerfectTree ();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements for First: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrderPrint(tree.root);
        System.out.println("");

        System.out.println(tree.perfectTree(tree.root, 1));
    }  
};  
     