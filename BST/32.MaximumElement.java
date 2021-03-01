import java.util.*; 

// Maximum element between two nodes of BST
// nodes are present in tree

class MaximumElement {  

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

    MaximumElement() {
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

    public int maximumElementUtil(Node root, int x) {
        int max = -1;

        while(root != null && root.data != x) {
            max = Math.max(root.data, max);
            if(root.data > x) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return Math.max(max, x);
    }

    public int maximumElement(int a, int b) {
        if(root == null) {
            return 0;
        }
        
        Node lca = findLca(root, a, b);
        return Math.max(maximumElementUtil(lca, a), maximumElementUtil(lca, b));

    }

    public static void main(String[] args) {  
        MaximumElement tree = new MaximumElement();  
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

        System.out.println("Maximum element: " + tree.maximumElement(a, b));
    }   
};  
     