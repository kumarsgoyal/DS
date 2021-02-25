import java.util.*; 

// Write a function to Given a tree and a node data, your task to reverse the 
// path till that particular Node.


class ReverseTreePath {  

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

    ReverseTreePath() {
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

    public int findValue(Node root, int num, Vector vec) {
        if(root == null) {
            return 0;
        }

        if(root.data == num) {
            vec.add(root.data);
            return 1;
        }

        int l = findValue(root.left, num, vec);
        int r = findValue(root.right, num, vec);

        if(l == 1 || r == 1) {
            vec.add(root.data);
            return 1;
        }

        return 0;

    }

    public void reverseTreePathUtil(Node root, Vector vec, int start, int end, int size) {
        if(root == null || start > size || end < 0) {
            return;
        }

        if(root.data == (Integer)vec.get(start)) {
            root.data = (Integer)vec.get(end);
            start++;
            end--;
        }
        else {
            return;
        }

        if(root.left != null && root.left.data == (Integer)vec.get(start)) {
            reverseTreePathUtil(root.left, vec, start, end, size);
        }
        else {
            reverseTreePathUtil(root.right, vec, start, end, size);
        }
    }

    public void reverseTreePath(int num) {
        Vector vec = new Vector();
        int i = findValue(root, num, vec);

        if(i == 1) {
            Collections.reverse(vec);
            reverseTreePathUtil(root, vec, 0, vec.size() - 1, vec.size() - 1);
        }
        else {
            System.out.println("-1");
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
        ReverseTreePath tree = new ReverseTreePath();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter value till which reverse path");
        int num = sc.nextInt();

        tree.preOrderPrint(tree.root);
        tree.reverseTreePath(num);
        System.out.println("");
        tree.preOrderPrint(tree.root);
    }  
};  
     