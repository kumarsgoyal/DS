import java.util.*; 

// Write a function to Symmetric Tree (Mirror Image of itself)


class SymmetricTree {  
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

    SymmetricTree() {
        root = null;
    }


    public void addNode(Queue<Integer> q) {
        if(q.isEmpty() == true) {
            return;
        }

        Queue<Node> que = new LinkedList<>();
        Node top = new Node(q.remove());
        que.add(top);
        root = top;

        while(q.isEmpty() == false) {
            Node temp = que.remove();
            temp.left = new Node(q.remove());
            que.add(temp.left);

            if(q.isEmpty() == false ){
                temp.right = new Node(q.remove());
                que.add(temp.right);
            }
        }
    }

    public void inorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        inorderTreePrint(temp.left);
        System.out.print(temp.data + " ");
        inorderTreePrint(temp.right);
    }    

    public boolean symmetricTreeUtil(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        return ((root1.data == root2.data) && 
                    symmetricTreeUtil(root1.left, root2.right) && 
                    symmetricTreeUtil(root1.right, root2.left));
    }  

    public boolean symmetricTree() {
        if(root == null) {
            return false;
        }

        return symmetricTreeUtil(root.left, root.right);
    }

    public static void main(String[] args) {  
        SymmetricTree tree = new SymmetricTree();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            que.add(num);
        }

        tree.addNode(que);
        tree.inorderTreePrint(tree.root);
        System.out.println(tree.symmetricTree());
    }  
};  
     