import java.util.*; 

// Count BST subtrees that lie in given range


class CountBST {  

    Node root;
    int count;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

    }

    CountBST() {
        root = null;
        count = 0;
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

    public boolean countBSTUtil(Node root, int low, int high) {
        if(root == null) {
            return true;
        }   

        boolean l = countBSTUtil(root.left, low, high);
        boolean r = countBSTUtil(root.right, low, high);

        if(l == true && r == true && (root.data >= low && root.data <= high)) {
            count++;
            return true;
        }

        return false;
    }

    public void countBST(int x, int y) {
        if(root == null) {
            return;
        }
        
        countBSTUtil(root, x, y);
        
    }

    public static void main(String[] args) {  
        CountBST tree = new CountBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter range to find bst: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        tree.countBST(x, y);

        System.out.println("count: " + tree.count);
    }   
};  
     