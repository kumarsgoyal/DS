import java.util.*; 

// Check if given sorted sub-sequence exists in binary search tree


class SequenceExists {  

    Node root;
    int index;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

    }

    SequenceExists() {
        root = null;
        index = 0;
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

    public void sequenceExistsUtil(Node root, int[] arr) {
        if(root == null) {
            return;
        }   

        sequenceExistsUtil(root.left, arr);

        if(arr[index] == root.data) {
            index++;
        }

        sequenceExistsUtil(root.right, arr);

    }

    public void sequenceExists(int[] arr, int size) {
        if(root == null || size == 0) {
            return;
        }
        
        sequenceExistsUtil(root, arr);
        
        if(index == size) {
            System.out.println("Exists");
        }
        else {
            System.out.println("Doesn't Exists");
        }
        
    }

    public static void main(String[] args) {  
        SequenceExists tree = new SequenceExists();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter size and enter values of sorted sequence " + 
            "exist in arr or not: ");

        int n =sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        tree.sequenceExists(arr, n);

    }   
};  
     