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
        q.add(null); // to watch level

        while(q.isEmpty() == false) {
            Node temp = q.remove();

            if(temp != null) {
                System.out.print(temp.data + " ");

                // if curr root is having left child add it to queue
                if(temp.left != null)
                    q.add(temp.left);
                // if curr root is having right child add it to queue
                if(temp.right != null) 
                    q.add(temp.right);
            }
            else {
                System.out.println("");

                // if curr element is null and Queue is not empty that mean
                // more level are remaining so add null to Queue
                if(q.isEmpty() == false) {
                    q.add(temp);
                }
            }
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

        System.out.println("");
        tree.levelOrderTraversal();
    }  
};  
     