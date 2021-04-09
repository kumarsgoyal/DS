import java.util.*; 

// Print root to leaf paths without using recursion


class PrintAllPath {  
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

    PrintAllPath() {
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

    public void printTopToBottomPath(Node curr, HashMap<Node,Node> parent)  
    {  
        Stack<Node> stk = new Stack<>();
        while (curr != null)  
        {  
            stk.push(curr);  
            curr = parent.get(curr);  
        }  
    
        while (stk.isEmpty() == false)  
        {  
            curr = stk.pop();  
            System.out.print(curr.data + " "); 
        }  
        System.out.println(); 
    } 

    public void getPath(Node root) {
    	if(root == null) {
    		return;
    	}

        Stack<Node> stk = new Stack<>();
        stk.push(root);

        HashMap<Node,Node> parent = new HashMap<>(); 
        parent.put(root, null);

        while(stk.isEmpty() == false) {
            Node temp = stk.pop();

            if(temp.left == null && temp.right == null) {
                printTopToBottomPath(temp, parent);
            }
            if(temp.right != null) {
                parent.put(temp.right, temp);
                stk.push(temp.right);
            }
            if(temp.left != null) {
                parent.put(temp.left, temp);
                stk.push(temp.left);
            }
        }


    }     

    public static void main(String[] args) {  
        PrintAllPath tree = new PrintAllPath();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.getPath(tree.root);
    }  
};  
