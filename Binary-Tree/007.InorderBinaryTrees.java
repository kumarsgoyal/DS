import java.util.*; 

// Write a function to print inorder traversal of Binary Trees


class InorderBinaryTrees {  
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

    InorderBinaryTrees() {
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

    public void inorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        
        Stack<Node> stk = new Stack<>();
        Node curr = temp;

        while(curr != null || stk.isEmpty() == false) {
            // Reach the left most Node of the curr Node
            while(curr != null) { 
            // place pointer to a tree node on the stack before traversing 
            // the node's left subtree
                stk.push(curr);
                curr = curr.left;
            }

            curr = stk.pop();
            System.out.print(curr.data + " " );
            // we have visited the node and its left subtree.  Now, it's right
            // subtree's turn
            curr = curr.right;
        }
    }     

    public static void main(String[] args) {  
        InorderBinaryTrees tree = new InorderBinaryTrees();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inorderTreePrint(tree.root);
    }  
};  
     