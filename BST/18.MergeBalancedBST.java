import java.util.*; 

// Merge Two Balanced Binary Search Trees


class MergeBalancedBST {  

    Node root1;
    Node root2;
    Node root;
    Vector<Node> vec1;
    Vector<Node> vec2;
    Vector<Node> vec;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    MergeBalancedBST() {
        root = null;
        root1 = null;
        root2 = null;
        vec = new Vector<>();
        vec1 = new Vector<>();
        vec2 = new Vector<>();
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

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void storeBst(Node root, Vector<Node> vec) {
        if(root == null) 
            return;
        storeBst(root.left, vec);
        vec.add(root);
        storeBst(root.right, vec);
    } 

    public Node balancedBST(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = vec.elementAt(mid);
        
        root.left = balancedBST(start, mid - 1);
        root.right = balancedBST(mid + 1, end);

        return root;
    }

    public void mergeBst(Vector<Node> vec1, Vector<Node> vec2) {
        int index1 = 0;
        int index2 = 0;

        while(index1 < vec1.size() && index2 < vec2.size()) {
            if(vec1.elementAt(index1).data < vec2.elementAt(index2).data) {
                vec.add(vec1.elementAt(index1));
                index1++;
            }
            else {
                vec.add(vec2.elementAt(index2));
                index2++;
            }
        }

        while(index1 < vec1.size()) {
            vec.add(vec1.elementAt(index1));
            index1++;
        }

        while(index2 < vec2.size()) {
            vec.add(vec2.elementAt(index2));
            index2++;
        }
    }

    public Node mergeBalancedBST() {
        if(root1 == null) 
            return root2;
        if(root2 == null)
            return root1;

        // store bst in vector
        storeBst(root1, vec1);
        storeBst(root2, vec2);

        // merge vector in sorted order
        mergeBst(vec1, vec2);

        vec1.clear();
        vec2.clear();

        return balancedBST(0, vec.size() - 1);

    }

    public static void main(String[] args) {  
        MergeBalancedBST tree = new MergeBalancedBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size1 = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            tree.root1 = tree.addNode(tree.root1, num);
        }


        System.out.println("Enter the total no of elements: ");
        int size2 = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size2; i++) {
            int num = sc.nextInt();
            tree.root2 = tree.addNode(tree.root2, num);
        }

        tree.preOrder(tree.root1);
        System.out.println("");
        tree.preOrder(tree.root2);
        System.out.println("");

        tree.root = tree.mergeBalancedBST();

        tree.preOrder(tree.root);
    }  
};  
     