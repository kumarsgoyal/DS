import java.util.*; 

// Write a function to print postorder traversal of Binary Trees


class PostorderBinaryTrees {  
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

    PostorderBinaryTrees() {
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

    public void postorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        
        Stack<Node> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        stk1.push(temp);

        while(stk1.isEmpty() == false) {
            temp = stk1.pop();
            stk2.push(temp.data);

            if(temp.left != null) {
                stk1.push(temp.left);
            }
            if(temp.right != null) {
                stk1.push(temp.right);
            }
        }

        while(stk2.isEmpty() == false) {
            System.out.print(stk2.pop() + " ");
        }
        
    }     

    public static void main(String[] args) {  
        PostorderBinaryTrees tree = new PostorderBinaryTrees();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.postorderTreePrint(tree.root);
    }  
};  
     