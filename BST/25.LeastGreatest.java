import java.util.*; 

// Replace every element with the least greater element on its right


class LeastGreatest {  

    Node root;
    Node succ;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    LeastGreatest() {
        root = null;
        succ = null;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else if(root.data > num) {
            succ = root;
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void print(int[] arr, int size) {
        for(int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public  void leastGreatest(int[] arr, int size) {
        for(int i = size - 1; i >= 0; i--) {
            succ = null;
            root = addNode(root, arr[i]);

            if(succ == null) {
                arr[i] = -1;
            }
            else {
                arr[i] = succ.data;
            }
        }

    }

    public static void main(String[] args) {  
        LeastGreatest tree = new LeastGreatest();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        tree.leastGreatest(arr, size);

        tree.print(arr, size);
    }  
};  
     