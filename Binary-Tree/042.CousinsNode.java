import java.util.*; 

// Check if two nodes are cousins in a Binary Tree

// Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether 
// the two nodes are cousins of each other or not.
// Two nodes are cousins of each other if they are at same level and have 
// different parents.





class CousinsNode {  

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

    CousinsNode () {
        root = null;
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

    public int find(Node root, int x, int l) {
        if(root == null) {
            return -1;
        }

        if(root.data == x) {
            return l;
        }

        int ll = find(root.left, x, l + 1);
        int rl = find(root.right, x, l + 1);

        if(ll == -1) {
            return rl;
        }

        return ll;
    }
   
    public boolean isSiblings(Node root, int a, int b) {
        if(root == null) {
            return false;
        }

        if(root.left != null && root.right != null) {
            if(root.left.data == a && root.right.data == b) {
                return true;
            }
            if(root.left.data == b && root.right.data == a) {
                return true;
            }
        }

        return isSiblings(root.left, a, b) || isSiblings(root.right, a, b);
    }

    public boolean cousinsNode(int a, int b) {
        if(root == null) {
            return true;
        } 

        // check level of element and also find present or not
        int ah = find(root, a, 1); // find level of a
        int bh = find(root, b, 1); // find level of b

        if(ah == -1 || bh == -1) {
            System.out.println("Elements not found");
            return false;
        } 
        else if(ah != bh){
            return false;
        }
        else {
            return !isSiblings(root, a, b);
        }


    }

    public static void main(String[] args) {  
        CousinsNode tree = new CousinsNode();  
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

        System.out.println("Enter vale of child a");
        int a = sc.nextInt();
        System.out.println("Enter vale of child b");
        int b = sc.nextInt();

        if(tree.cousinsNode(a, b) == true) { 
            System.out.println("Yes"); 
        } 
        else { 
            System.out.println("No"); 
        }
    }  
};  
     