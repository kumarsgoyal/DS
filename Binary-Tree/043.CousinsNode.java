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

    public boolean cousinsNode(int a, int b) {
        if(root == null) {
            return true;
        } 

        Queue<Node> que = new LinkedList<>();
        Node parA = null;
        Node parB = null;

        que.add(root);

        while(que.size() > 0) {
            Node temp = que.remove();

            if(temp.left != null) {
                que.add(temp.left);
                if(temp.left.data == a)
                    parA = temp;
                else if(temp.left.data == b) 
                    parB = temp;
            }
            if(temp.right != null){
                que.add(temp.right);
                if(temp.right.data == a)
                    parA = temp;
                else if(temp.right.data == b) 
                    parB = temp;
            }
        }

        if(parA != null && parB != null && parA != parB) {
            return true;
        }

        return false;

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
     