import java.util.*; 

// Write a function to delete element
// 1. Node to be deleted is leaf:
// Simply remove from the tree.
// 2. Node to be deleted has only one child:
// Copy the child to the node and delete the child
// 3. Node to be deleted has two children:
// Find inorder successor of the node. Copy contents of the inorder successor 
// to the node and delete the inorder successor. Note that inorder predecessor 
// can also be used.


class DeleteNode {  

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

    DeleteNode() {
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

    public void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public Node delete(Node root, int ele) {
        if(root == null) {
            return null;
        }

        // recursive call to find element
        if(root.data > ele) {
            root.left = delete(root.left, ele);
            return root;
        }
        else if(root.data < ele) {
            root.right = delete(root.right, ele);
            return root;
        }

        // if element found we reach here.

        // if one child is null return another child
        // or this can be leaf node
        if(root.left == null) {
            return root.right;
        }
        else if(root.right == null) {
            return root.left;
        }
        // if both child are present
        else {
            Node succParent = root;
            Node succ = root.right;

            while(succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if(succParent != root) {
                succParent.left = succ.right;
            }
            else {
                succParent.right = succ.right;
            }

            root.data = succ.data;
            return root;
        }

    }

    public static void main(String[] args) {  
        DeleteNode tree = new DeleteNode();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.preOrder(tree.root);
        System.out.println("");

        System.out.println("Enter node to delete");
        int ele = sc.nextInt();
        tree.root = tree.delete(tree.root, ele);

        tree.preOrder(tree.root);
        System.out.println("");
    }  
};  
     