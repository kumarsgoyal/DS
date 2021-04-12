import java.util.*; 

// Print all root to leaf paths with there relative positions
// We do Preorder traversal of the given Binary Tree. While traversing the tree,
// we can recursively calculate horizontal distances or HDs.
// We initially pass the horizontal distance as 0 for root.
// For left subtree, we pass the Horizontal Distance as Horizontal distance of 
// root minus 1. For right subtree, we pass the Horizontal Distance as 
// Horizontal Distance of root plus 1. For every HD value, we maintain a list
// of nodes in a ArrayList (” that will store information of current node 
// horizontal distance and key value of root “).we also maintain the order of 
// node (order in which they appear in path from root to leaf). for maintaining
// the order,here we used ArrayList. While we reach to leaf node during 
// traverse we print that path with underscore “_”

class PrintAllPathRelative {  
    Node root;
    ArrayList<Path> arr;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    class Path {
        int hd;
        int data;

        Path(int d, int num) {
            hd = d;
            data = num;
        }
    }

    PrintAllPathRelative() {
        root = null;
        arr = new ArrayList<Path> ();
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

    public void print() {
        int md = Integer.MAX_VALUE;
        Path temp = null;
        for(int i = 0; i < arr.size(); i++) {
            temp = arr.get(i);
            md = Math.min(md, temp.hd);
        }

        for(int i = 0; i < arr.size(); i++) {
            temp = arr.get(i);

            int underscore = Math.abs(temp.hd - md);

            for(int j = 0; j < underscore; j++) 
                System.out.print("_ ");
            System.out.println(temp.data);
        }
        System.out.println("------------------------------------------------");
    }

    public void printAllPathRelativeUtil(Node root, int d) {
        if(root == null) {
            return;
        }

        Path p = new Path(d, root.data);
        arr.add(p);

        if(root.left == null && root.right == null) {
            print();
            arr.remove(p);
            return;
        }

        printAllPathRelativeUtil(root.left,  d - 1);
        printAllPathRelativeUtil(root.right, d + 1);

        arr.remove(p);
    }

    public void printAllPathRelative(Node root) {
    	if(root == null) {
    		return;
    	}

        printAllPathRelativeUtil(root, 0);
    }     

    public static void main(String[] args) {  
        PrintAllPathRelative tree = new PrintAllPathRelative();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.printAllPathRelative(tree.root);
    }  
};  
