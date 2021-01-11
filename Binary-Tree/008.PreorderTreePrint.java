import java.util.*; 

// Write a function to print preorder traversal of Binary Trees


class PreorderBinaryTrees {  
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

    PreorderBinaryTrees() {
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

    public void preorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        
        Stack<Node> stk = new Stack<>();
        stk.push(temp);

        while(stk.isEmpty() == false) {
            temp = stk.pop();
            System.out.print(temp.data + " ");

            if(temp.right != null)
                stk.push(temp.right);
            if(temp.left != null) 
                stk.push(temp.left);
        }
    }     

    public static void main(String[] args) {  
        PreorderBinaryTrees tree = new PreorderBinaryTrees();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preorderTreePrint(tree.root);
    }  
};  
     