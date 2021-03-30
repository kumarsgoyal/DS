import java.util.*; 

// Check if two trees are Mirror


class MirrorTree {  

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    MirrorTree () {
    }

    static public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }


    static public boolean mirrorTree(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        return ((root1.data == root2.data) && 
            mirrorTree(root1.left, root2.right) && 
            mirrorTree(root1.right, root2.left));

    }

    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);

        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(12);
        root1.left.right = new Node(17);

        Node root2 = new Node(10);
        root2.left = new Node(15);
        root2.right = new Node(5);
        root2.right.left = new Node(17);
        root2.right.right = new Node(12);
        

        inOrderPrint(root1);
        System.out.println("");
        inOrderPrint(root2);
        System.out.println("");


        System.out.println(mirrorTree(root1, root2));
    }  
};  
     