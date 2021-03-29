import java.util.*; 

// Check if a Binary Tree (not BST) has duplicate values




class DuplicateValue {  

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

    DuplicateValue () {
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

    public boolean duplicateValueUtil(Node root, HashSet<Integer> set) {
        if(root == null) {
            return false;
        }
        if(set.contains(root.data)) {
            return true;
        }

        set.add(root.data);

        return duplicateValueUtil(root.left, set) || duplicateValueUtil(root.right, set);
    }

    public boolean duplicateValue(Node root) {
    	if(root == null) {
    		return true;
    	}
        HashSet<Integer> set = new HashSet<>();

        return duplicateValueUtil(root, set);

    }

    public static void main(String[] args) {  
        DuplicateValue tree = new DuplicateValue();  
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

        System.out.print("Tree Contain duplicate value: ");
        System.out.println(tree.duplicateValue(tree.root));
    }  
};  
     