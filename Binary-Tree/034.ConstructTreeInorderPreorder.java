import java.util.*; 

// Write a function to Construct Tree from given Inorder and Preorder traversals


class ConstructTreeInorderPreorder {  
    Node root;
    int preIndex;
    HashMap<Integer, Integer> hm;

    class Node {
        int data;
        Node left, right;
        
        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    ConstructTreeInorderPreorder() {
        root = null;
        preIndex = 0;
        hm = new HashMap<Integer, Integer> ();
    }

    public Node constructTreeInorderPreorder(int[] in, int[] pre, int start, int end) {
        if(start > end) {
            return null;
        }

        int data = pre[preIndex++];
        Node temp = new Node(data);
        

        if(start != end) {
            // index in inorder array
            int inIndex = hm.get(data);
            // left tree
            temp.left = constructTreeInorderPreorder(in, pre, start, inIndex - 1);
            // right tree
            temp.right = constructTreeInorderPreorder(in, pre, inIndex + 1, end);
        }
        return temp;
    } 

    public void fillIndex(int[] in, int size) {
        for(int i = 0; i < size; i++) {
            hm.put(in[i], i);
        }
    } 

    public void printPostOrder(Node root) {
        if(root == null) {
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }   

    public static void main(String[] args) {  
        ConstructTreeInorderPreorder tree = 
            new ConstructTreeInorderPreorder();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] pre = new int[size];
        int[] in = new int[size];

        System.out.println("Start entering elements of preorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            pre[i] = num;
        }

        System.out.println("Start entering elements of inorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            in[i] = num;
        }

        tree.fillIndex(in, size);
        tree.root = tree.constructTreeInorderPreorder(in, pre, 0, size - 1);
        tree.printPostOrder(tree.root);
    }  
};  
     