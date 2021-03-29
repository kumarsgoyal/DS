import java.util.*; 

// Check whether a given binary tree is complete or not
// A complete binary tree is a binary tree in which every level, except 
// possibly the last, is completely filled, and all nodes are as far left as 
// possible. See the following examples.

//                10
//             /       \  
//           20         30  
//          /  \        /
//        40    50    60   <- compete

//          1
//       /    \
//      2       3
//      \     /  \   
//       4   5    6    <-  not complete perfect 



class CompleteTree {  

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

    CompleteTree () {
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
    
    public void inOrderPrint(Node root) {
        if(root == null) {
            return;
        }
        inOrderPrint(root.left);   
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    public boolean completeTree(Node root) {
    	if(root == null) {
    		return true;
    	}
        boolean flag = false;

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(que.isEmpty() == false) {
            Node node = que.remove();

            if(node.left != null) {
                if(flag == true) {
                    return false;
                }
                que.add(node.left);
            }
            else {
                flag = true;
            }

            if(node.right != null) {
                if(flag == true) {
                    return false;
                }
                que.add(node.right);
            }
            else {
                flag = true;
            }
        }

        return true;

    }

    public static void main(String[] args) {  
        CompleteTree tree = new CompleteTree ();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements for First: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrderPrint(tree.root);
        System.out.println("");

        System.out.println(tree.completeTree(tree.root));
    }  
};  
     