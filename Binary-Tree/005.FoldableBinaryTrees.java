import java.util.*; 

// Write a function to Foldable Binary Trees


class FoldableBinaryTrees {  
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

    FoldableBinaryTrees() {
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

    public void inorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        inorderTreePrint(temp.left);
        System.out.print(temp.data + " ");
        inorderTreePrint(temp.right);
    }     

    public boolean foldableBinaryTreesUtil(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        return (foldableBinaryTreesUtil(root1.left, root2.right) && 
        	foldableBinaryTreesUtil(root1.right, root2.left));
    }  

    public boolean foldableBinaryTrees() {
        // if(root == null) {
        //     return false;
        // }

        // return foldableBinaryTreesUtil(root.left, root.right);

        if(root == null) {
            return false;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(q.isEmpty() == false) {
        	System.out.println("a");
            Node left = q.remove();
            Node right = q.remove();
            System.out.println(left);
            System.out.println(right);

            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);  
        }

        return true;
    }

    public static void main(String[] args) {  
        FoldableBinaryTrees tree = new FoldableBinaryTrees();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inorderTreePrint(tree.root);
        System.out.println(tree.foldableBinaryTrees());
    }  
};  
     