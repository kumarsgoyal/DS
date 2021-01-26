import java.util.*; 

// Write a function to Populate Inorder Successor for all nodes

class PopulateInorderSuccessor {  

    Node root;
    Node prev;
    Vector vec;
    int inIndex;

    class Node {
        int data;
        Node left;
        Node right;
        Node next;

        Node(int x) {
            data = x;
            left = right = next = null;
        } 
    }

    PopulateInorderSuccessor() {
        root = null;
        prev = null;
        vec = new Vector();
        inIndex = 1;
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

    public void preorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        System.out.print(temp.data + " ");
        preorderTreePrint(temp.left);
        preorderTreePrint(temp.right);
    }

    public void preorderTreePrintNext(Node temp) {
        if(temp == null) {
            return;
        }
        System.out.print(temp.data + "->");
        if(temp.next != null) 
            System.out.print(temp.next.data + "   ");
        else 
            System.out.print("-1   ");
        preorderTreePrintNext(temp.left);
        preorderTreePrintNext(temp.right);
    }

    public void storeInorder(Node root) {
        if(root == null) {
            return;
        }
        storeInorder(root.left);
        vec.add(root);
        storeInorder(root.right);
    }

    public void replaceNextSuccessor(Node root) {
        if(root == null) {
            return;
        }

        replaceNextSuccessor(root.left);
        root.next = (Node)vec.get(inIndex);
        inIndex++;
        replaceNextSuccessor(root.right);
    }

    public void populateInorderSuccessor(Node root) {
        if(root == null) {
            return;
        }

        storeInorder(root);
        vec.add(null);
        replaceNextSuccessor(root);

    } 
    

    public static void main(String[] args) {  
        PopulateInorderSuccessor tree = new PopulateInorderSuccessor();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preorderTreePrint(tree.root);
        System.out.println("");
        tree.populateInorderSuccessor(tree.root);
        tree.preorderTreePrintNext(tree.root);
    }  
};  
     