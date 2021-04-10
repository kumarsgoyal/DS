import java.util.*; 

// Print the longest leaf to leaf path in a Binary tree



class LongestPath {  
    Node root;
    Vector<Integer> vecLeft;
    Vector<Integer> vecRight;
    Node dummy;
    int len, left, right;
    boolean flag;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    LongestPath() {
        root = null;
        vecLeft = new Vector<Integer>();
        vecRight = new Vector<Integer>();
        dummy = null;
        left = right = len = Integer.MIN_VALUE;
        flag = false;
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

    public int findNode(Node root) {
        if(root == null ) {
            return 0;
        }

        int lh = findNode(root.left);
        int rh = findNode(root.right);

        if(len < (lh + rh + 1)) {
            len = lh + rh + 1;
            dummy = root;
            left = lh;
            right = rh;
        }

        return 1 + Math.max(lh,rh);
    }

    public boolean printReccurs(Node root, Vector<Integer> vec, int ln) {
        if(root == null) {
            return false;
        }
        if(flag == true) {
            return true;
        }

        vec.add(root.data);
        if(root.left == null && root.right == null) {
            if(vec.size() == ln) {
                flag = true;
                return true;
            }
        }

        boolean lf = printReccurs(root.left, vec, ln);
        boolean rh = printReccurs(root.right, vec, ln);

        if(lf == true || rh == true) {
            return true;
        }

        vec.removeElement(root.data);
        return false;
    }

    public void longestPath(Node root) {
    	if(root == null) {
    		return;
    	}

        int height = findNode(root);
        printReccurs(dummy.left, vecLeft, left);

        flag = false;
        printReccurs(dummy.right, vecRight, right);

        vecLeft.add(dummy.data);
        System.out.print(vecLeft + " " + vecRight);

    }     

    public static void main(String[] args) {  
        LongestPath tree = new LongestPath();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        tree.longestPath(tree.root);
    }  
};  
