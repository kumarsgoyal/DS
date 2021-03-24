import java.util.*; 

// Check if all leaves are at same level


class LeafLevel {  

    Node root;
    int lv;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    LeafLevel () {
        root = null;
        lv = 0;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data <= num) {
            root.right = addNode(root.right, num);
        }
        else {
            root.left = addNode(root.left, num);
        }
        return root;
    }
    
    public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    public boolean leafLevelUtil(Node root, int l) {
        if(root == null)
            return true;

        if(root.left == null && root.right == null) {
            if(lv == 0){
                lv = l;
                // return true;  
            } 
            return (lv == l);
        }

        return leafLevelUtil(root.left, l + 1) && leafLevelUtil(root.right, l + 1);

    }

    public boolean leafLevel() {
        if(root == null) {
            return true;
        } 

        return leafLevelUtil(root, 1);

    }

    public static void main(String[] args) {  
        LeafLevel tree = new LeafLevel();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrderPrint(tree.root); 
        System.out.println(""); 

        if(tree.leafLevel() == true) { 
            System.out.println("Yes"); 
        } 
        else { 
            System.out.println("No"); 
        }
    }  
};  
     