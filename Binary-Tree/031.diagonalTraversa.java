import java.util.*; 
import java.util.Map.Entry; 

// Write a function to Diagonal Traversal of Binary Tree


class DiagonalTraversal {  

    Node root;
    HashMap<Integer, Vector<Integer>> mp;
    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    DiagonalTraversal() {
        root = null;
        mp = new HashMap<>();
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

    public void diagonalTraversalUtil(Node root, int d) {
        if(root == null) {
            return;
        }

        Vector<Integer> k = mp.get(d);

        if(k == null) {
            k = new Vector<>();
            k.add(root.data);
        }
        else {
            k.add(root.data);
        }

        mp.put(d, k);
        diagonalTraversalUtil(root.left, d + 1);
        diagonalTraversalUtil(root.right, d);


    }

    public void diagonalTraversal() {
        if(root == null) {
            return;
        }
        
        diagonalTraversalUtil(root, 0);

        for (Entry<Integer, Vector<Integer>> i : mp.entrySet()) 
        { 
            System.out.println(i.getValue()); 
        } 
    }
    
    public void preOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderPrint(root.left);   
        preOrderPrint(root.right);
    }

    public static void main(String[] args) {  
        DiagonalTraversal tree = new DiagonalTraversal();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }


        tree.preOrderPrint(tree.root);
        System.out.println("");
        tree.diagonalTraversal();
    }  
};  
     