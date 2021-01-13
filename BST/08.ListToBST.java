import java.util.*; 

// Sorted Linked List to Balanced BST



class ListToBST {  

    Node root;
    List head;
    List temp;

    // linked-list
    class List {
        int data;
        List next;

        List(int x) {
            data = x;
            next = null;
        }
    }

    // tree
    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    ListToBST() {
        root = null;
        head = null;
        temp = null;
    }

    public int size(List head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public List addElement(List head, int num) {
        List temp = new List(num);
        temp.next = head;

        return temp;
    }

    public Node listToBSTUtil(int n) {
        if(n <= 0) 
            return null;

        Node left = listToBSTUtil(n/2);
        Node root = new Node(temp.data);
        temp = temp.next;

        root.left = left;
        root.right = listToBSTUtil(n - n/2 -1);

        return root;

    }

    public Node listToBST() {
        temp = head;
        int n = size(head);
        System.out.println("Size: " + n);
        return listToBSTUtil(n);
    }


    public void printInOrder(Node root) {
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {  
        ListToBST tree = new ListToBST();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int size = sc.nextInt();
        System.out.println("Start enter elements in sorted order");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.head = tree.addElement(tree.head, num);
        }

        tree.root = tree.listToBST();
        tree.printInOrder(tree.root);


    }  
};  
     