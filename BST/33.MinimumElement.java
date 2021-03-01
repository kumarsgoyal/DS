import java.util.*; 

// Minimum element between two nodes of BST
// nodes are present in tree

class MinimumElement {  

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

    MinimumElement() {
        root = null;
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

    public Node findLca(Node root, int a, int b) {
        Node lca = root;

        while((a < lca.data && b < lca.data) || 
            (a > lca.data && b > lca.data)) {

            if(a < lca.data && b < lca.data) {
                lca = lca.left;
            }
            else {
                lca = lca.right;
            }
        }

        return lca;
    }

    public int minimumElementUtil(Node root, int x) {
        int min = Integer.MAX_VALUE;

        while(root != null && root.data != x) {
            min = Math.min(root.data, min);
            if(root.data > x) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return Math.min(min, x);
    }

    public int minimumElement(int a, int b) {
        if(root == null) {
            return 0;
        }
        
        Node lca = findLca(root, a, b);
        return Math.min(minimumElementUtil(lca, a), minimumElementUtil(lca, b));

    }

    public static void main(String[] args) {  
        MinimumElement tree = new MinimumElement();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter elements to find maximum elements between");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Maximum element: " + tree.minimumElement(a, b));
    }   
};  
     