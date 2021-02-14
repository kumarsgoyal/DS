import java.util.*; 

// Write a function to print level order traversal

class LevelOrderTraversal {  

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

    LevelOrderTraversal() {
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


    public void levelOrderTraversal() {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.isEmpty() == false) {
            Node temp = q.remove();

            System.out.print(temp.data + " ");

            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null) 
                q.add(temp.right);
        }
    } 
    

    public static void main(String[] args) {  
        LevelOrderTraversal tree = new LevelOrderTraversal();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.levelOrderTraversal();
    }  
};  
     