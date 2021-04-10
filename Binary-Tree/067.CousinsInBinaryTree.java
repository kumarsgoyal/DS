import java.util.*; 

// Print cousins of a given node in Binary Tree


class CousinsInBinaryTree {  
    Node root;
    Node dummy;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    CousinsInBinaryTree() {
        root = null;
        dummy = null;
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

    public int getHeight(Node root, int x, int lv) {
        if(root == null) {
            return 0;
        }

        if(root.data == x) {
            dummy = root;
            return lv;
        }

        int h = getHeight(root.left, x, lv + 1);
        if(h != 0) {
            return h;
        }
        h = getHeight(root.right, x, lv + 1);
        return h;
    }

    public void print(Node root, int lv) {
        if(root == null || lv < 2) {
            return;
        }
        
        if(lv == 2) {
            if(root.left == dummy || root.right == dummy) {
                return;
            }
            if(root.left != null) 
                System.out.print(root.left.data + " ");
            if(root.right != null)
                System.out.print(root.right.data + " ");
        }
        if(lv > 2) {
            print(root.left, lv - 1);
            print(root.right, lv - 1);
        }
    }

    public void cousinsInBinaryTree(Node root, int x) {
    	if(root == null) {
    		return;
    	}

        int l = getHeight(root, x, 1);
        print(root, l);
    }     

    public static void main(String[] args) {  
        CousinsInBinaryTree tree = new CousinsInBinaryTree();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }

        System.out.println("Enter element to print cousins : ");
        int x = sc.nextInt();
        tree.cousinsInBinaryTree(tree.root, x);
    }  
};  
