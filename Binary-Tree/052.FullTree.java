import java.util.*; 

// Check whether a given binary tree is full or not
// A full binary tree is defined as a binary tree in which all nodes have 
// either zero or two child nodes.



class FullTree {  

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

    FullTree () {
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

    public boolean fullTree(Node root) {
    	if(root == null) {
    		return true;
    	}

    	if(root.left == null && root.right == null) {
            return true;
    	}
    	if(root.left == null || root.right == null) {
    		return false;
    	}

    	return fullTree(root.left) && fullTree(root.right);

    }

    public boolean fullTreeItr(Node root) {
        if(root == null) {
            return true;
        }

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(que.isEmpty() == false) {
            Node node = que.remove();

            if(node.left == null && node.right == null) {
                continue;
            }
            if(node.left == null || node.right == null) {
                return false;
            }

            que.add(node.left);
            que.add(node.right);
        }

        return true;

    }

    public static void main(String[] args) {  
        FullTree tree = new FullTree ();  
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

        System.out.println(tree.fullTree(tree.root));
        System.out.println(tree.fullTreeItr(tree.root));
    }  
};  
     