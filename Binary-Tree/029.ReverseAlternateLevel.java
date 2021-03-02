import java.util.*; 

// Write a function to Reverse alternate levels of a perfect binary tree



class ReverseAlternateLevel {  

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

    ReverseAlternateLevel() {
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

    public void reverseAlternateLevelUtil(Node root1, Node root2, int lv) {
        if(root1 == null || root2 == null) {
            return;
        }

        if(lv % 2 == 0) {
            int temp = root1.data;
            root1.data = root2.data;
            root2.data = temp;
        }

        reverseAlternateLevelUtil(root1.left, root2.right, lv + 1);
        reverseAlternateLevelUtil(root1.right, root2.left, lv + 1);
    }

    public void reverseAlternateLevel() {
        if(root == null) {
            return;
        }
        reverseAlternateLevelUtil(root.left, root.right, 2);
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
        ReverseAlternateLevel tree = new ReverseAlternateLevel();  
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
        tree.reverseAlternateLevel();
        tree.preOrderPrint(tree.root);
    }  
};  
     