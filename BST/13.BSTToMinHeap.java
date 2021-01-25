import java.util.*; 

// Convert BST to Min Heap
// Given a binary search tree which is also a complete binary tree.
// The problem is to convert the given BST into a Min Heap with the condition 
// that all the values in the left subtree of a node should be less than all 
// the values in the right subtree of the node. This condition is applied on 
// all the nodes in the so converted Min Heap.

class BSTToMinHeap {  

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

    BSTToMinHeap() {
        root = null;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else if(root.data > num) {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void getInorder(Node root, Vector<Integer>vec) {
        if(root == null) {
            return;
        }

        getInorder(root.left, vec);
        vec.add(root.data);
        getInorder(root.right, vec);
    }

    public void bstToMinHeapUtil(Node root, Vector<Integer> vec) {
        Queue<Node> que = new LinkedList<>();
        que.add(root); 
        int index = 0;

        while(que.isEmpty() == false) {
            Node temp = que.remove();
            temp.data = vec.elementAt(index++);

            if(temp.left != null) {
                que.add(temp.left);
            }
            if(temp.right != null) {
                que.add(temp.right);
            }
        }
    } 

    public  void bstToMinHeap() {
        if(root == null) 
            return ;
        Vector<Integer> vec = new Vector<>();
        getInorder(root, vec);
        bstToMinHeapUtil(root, vec);
    }

    public static void main(String[] args) {  
        BSTToMinHeap tree = new BSTToMinHeap();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrder(tree.root);
        System.out.println("");

        tree.bstToMinHeap();

        tree.inOrder(tree.root);
    }  
};  
     