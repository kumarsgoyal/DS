import java.util.*; 

// Check if leaf traversal of two Binary Trees is same



class LeafTraversal {  

    Node root1;
    Node root2;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

        public boolean isLeaf() {
            return ((left == null) && (right == null));
        }
    }

    LeafTraversal () {
        root1 = null;
        root2 = null;
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
    
    public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    public boolean leafTraversal(Node root1, Node root2) {
        if(root1 == null || root2 == null) {
            return false;
        }

        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        st1.push(root1);
        st2.push(root2);

        while(st1.isEmpty() == false || st2.isEmpty() == false) {
            if(st1.isEmpty() == true || st2.isEmpty() == true) {
                return false;
            }

            Node temp1 = st1.pop();
            while(temp1 != null && temp1.isLeaf() == false) {
                if(temp1.right != null)
                    st1.push(temp1.right);
                if(temp1.left != null)
                    st1.push(temp1.left);

                temp1 = st1.pop();
            }

            Node temp2 = st2.pop();
            while(temp2 != null && temp2.isLeaf() == false) {
                if(temp2.right != null) 
                    st2.push(temp2.right);
                if(temp2.left != null)
                    st2.push(temp2.left);

                temp2 = st2.pop();
            }

            if (temp1 != null && temp2 != null) 
            { 
                if (temp1.data != temp2.data) {
                    // System.out.println(temp1.data + " " + temp2.data);
                    return false; 
                }
            } 
        }

        return true;


    }

    public static void main(String[] args) {  
        LeafTraversal tree = new LeafTraversal ();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size1 = sc.nextInt();
        System.out.println("Start entering elements for First: ");
        for(int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            tree.root1 = tree.addNode(tree.root1, num);
        }

        System.out.println("Enter the total no of elements: ");
        int size2 = sc.nextInt();
        System.out.println("Start entering elements for Second: ");
        for(int i = 0; i < size2; i++) {
            int num = sc.nextInt();
            tree.root2 = tree.addNode(tree.root2, num);
        }


        tree.inOrderPrint(tree.root1);
        System.out.println("");
        tree.inOrderPrint(tree.root2);
        System.out.println("");

        System.out.println(tree.leafTraversal(tree.root1, tree.root2));
    }  
};  
     