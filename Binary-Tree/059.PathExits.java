import java.util.*; 

// Check if there is a root to leaf path with given sequence
// Given a binary tree and an array, the task is to find if the given 
// array sequence is present as a root to leaf path in given tree.



class PathExits {  
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

    PathExits() {
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

    public Boolean pathExits(Node root, int[] arr, int i, int size) {
        if(root == null || i == size) {
            return false;
        }

        if(root.left == null && root.right == null) {
            if(root.data == arr[i] && i == (size - 1)) {
                return true;
            }

            return false;
        }

        return (i < size) && (root.data == arr[i]) && 
            (pathExits(root.left, arr, i + 1, size) || 
            pathExits(root.right, arr, i + 1, size));
    }     

    public static void main(String[] args) {  
        PathExits tree = new PathExits();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        System.out.println("Enter size of array");
        int size1 = sc.nextInt();
        int[] arr = new int[size1];

        System.out.println("Enter array");
        for(int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        System.out.println(tree.pathExits(tree.root, arr, 0, size1));
    }  
};  
     