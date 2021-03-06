import java.util.*; 

// Inorder predecessor and successor for a given key in BST


class PredecessorSuccessor {  

    Node root;
    Node pre;
    Node succ;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    PredecessorSuccessor() {
        root = pre = succ = null;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else if(root.data > num) {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void predecessorSuccessorUtil(Node root, int num) {
        if(root == null) {
            return;
        }

        if(root.data == num) {
            if(root.left != null) {
                Node temp1 = root.left;
                while(temp1 != null) {
                    pre = temp1;
                    temp1 = temp1.right;
                }
            }
            if(root.right != null) {
                Node temp2 = root.right;
                while(temp2 != null) {
                    succ = temp2;
                    temp2 = temp2.left;
                }
            }
            return;
        }

        if(root.data > num) {
            predecessorSuccessorUtil(root.left, num);
        }
        else {
            predecessorSuccessorUtil(root.right, num);
        }
    }

    public void predecessorSuccessor(int num) {
        if(root == null) {
            return ;
        }
        
        predecessorSuccessorUtil(root, num);
    }

    public static void main(String[] args) {  
        PredecessorSuccessor tree = new PredecessorSuccessor();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter value to find predecessor successor");
        int num = sc.nextInt();

        tree.predecessorSuccessor(num);

        if(tree.pre != null) {
            System.out.println("Predecessor: " + tree.pre.data);
        }

        if(tree.succ != null) {
            System.out.println("Successor: " + tree.succ.data);
        }
    }   
};  
     