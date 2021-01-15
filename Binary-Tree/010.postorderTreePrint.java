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
        
        Stack<Node> stk = new Stack<>();

        do {
            while(temp != null) {
                if(temp.right != null) {
                    stk.push(temp.right);
                }
                stk.push(temp);
                temp = temp.left;
            }

            temp = stk.pop();

            // if right is not preocessed 
            if(temp.right != null && stk.isEmpty() == false && stk.peek() == 
                temp.right) {
                stk.pop();
                stk.push(temp);
                temp = temp.right;
            }
            else {
                System.out.print(temp.data + " ");
                temp = null;
            }
        }while(stk.isEmpty() == false);  
    }     

    public static void main(String[] args) {  
        PostorderBinaryTrees tree = new PostorderBinaryTrees();  
        Scanner sc = new Scanner(System.in);

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
     