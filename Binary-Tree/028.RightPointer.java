import java.util.*; 

// Write a function to Modify a binary tree to get preorder traversal using 
// right pointers only



class RightPointer {  

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

    RightPointer() {
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

    public void rightPointer() {
        if(root == null) {
            return;
        }
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        Node prev = null;

        while(stk.isEmpty() == false) {
        	Node temp = stk.pop();

        	if(temp.right != null) {
        		stk.push(temp.right);
        	}
        	if(temp.left != null) {
        		stk.push(temp.left);
        	}

        	temp.left = null;
        	temp.right = null;
        	if(prev != null) {
        		prev.right = temp;
        	}

        	prev = temp;
        }
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
        RightPointer tree = new RightPointer();  
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
        tree.rightPointer();
        tree.preOrderPrint(tree.root);
    }  
};  
     