import java.util.*; 

// Reverse a path in BST using queue

class ReversePath {  

    Node root;
    Queue<Integer> que;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    ReversePath() {
        root = null;
        que = new LinkedList<>();
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

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void getInorder(Node root, Vector<Integer>vec) {
        if(root == null) {
            return;
        }

        getInorder(root.left, vec);
        vec.add(root.data);
        getInorder(root.right, vec);
    }

    public boolean reversePathUtil(Node root, int x) {
        if(root == null) 
            return false;

        que.add(root.data);
        boolean flag = false;

        if(root.data == x) {
            root.data = que.remove();
            return true;
        }

        if(root.data > x) {
            flag = reversePathUtil(root.left, x);
        }
        else {
            flag = reversePathUtil(root.right, x);
        }

        if(flag == true) {
            root.data = que.remove();
        }
        return flag;
    } 

    public  void reversePath(int x) {
        if(root == null) 
            return ;

        boolean find = reversePathUtil(root, x);
    }

    public static void main(String[] args) {  
        ReversePath tree = new ReversePath();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrder(tree.root);

        System.out.println("\nEnter value to which reverse path");
        int x = sc.nextInt();

        tree.reversePath(x);

        tree.inOrder(tree.root);
    }  
};  
     