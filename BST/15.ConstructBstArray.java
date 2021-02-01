import java.util.*; 

// Construct BST from its given level order traversal
// Input : arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}


class ConstructBstArray {  

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

    ConstructBstArray() {
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

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    } 

    public void constructBstArray(int[] arr) {
        if(arr.length == 0) 
            return ;

        for(int i = 0; i < arr.length; i++) {
            root = addNode(root, arr[i]);
        }
    }

    public static void main(String[] args) {  
        ConstructBstArray tree = new ConstructBstArray();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        tree.constructBstArray(arr);

        tree.inOrder(tree.root);
    }  
};  