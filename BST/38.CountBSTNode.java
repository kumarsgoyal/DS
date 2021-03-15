import java.util.*; 

// Count BST nodes that lie in a given range


class CountBSTNode {  

    Node root;
    Vector vec;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

    }

    CountBSTNode() {
        root = null;
        vec = new Vector();
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

    public int countBSTNodeUtil(Node root, int low, int high) {
        if(root == null) {
            return 0;
        }   

        if(root.data > low && root.data < high) {
            vec.add(root.data);
            return 1 + countBSTNodeUtil(root.left, low, high) + 
                countBSTNodeUtil(root.right, low, high);
        }

        if(root.data < low) {
            return countBSTNodeUtil(root.right, low, high);
        }
        else {
            return countBSTNodeUtil(root.left, low, high);
        }

    }

    public void countBSTNode(int x, int y) {
        if(root == null) {
            return;
        }
        
        System.out.println(countBSTNodeUtil(root, x, y));
        System.out.println(vec);
    }

    public static void main(String[] args) {  
        CountBSTNode tree = new CountBSTNode();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter range to find nodes: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        tree.countBSTNode(x, y);

    }   
};  
     