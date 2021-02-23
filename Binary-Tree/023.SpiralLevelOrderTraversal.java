import java.util.*; 

// Write a function to print level order traversal

class SpiralLevelOrderTraversal {  

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

    SpiralLevelOrderTraversal() {
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


    public void spiralLevelOrderTraversal() {
        if(root == null) {
            return;
        }
        
        Deque<Node> dq = new LinkedList<>();

        dq.addFirst(root);

        while(dq.size() > 0) {
            // int size = dq.size();
            // while(size > 0) {
            //     size--;
            //     Node temp = dq.removeFirst();
            //     System.out.print(temp.data + " ");

            //     if(temp.left != null)
            //         dq.addLast(temp.left);
            //     if(temp.right != null)
            //         dq.addLast(temp.right);
            // }
            // System.out.println("");
            // size = dq.size();

            // while(size > 0) {
            //     size--;
            //     Node temp = dq.removeLast();
            //     System.out.print(temp.data + " ");

            //     if(temp.right != null)
            //         dq.addFirst(temp.right);
            //     if(temp.left != null)
            //         dq.addFirst(temp.left);
            // }
            // System.out.println("");


            int size = dq.size();
            while(size > 0) {
                size--;
                Node temp = dq.removeLast();
                System.out.print(temp.data + " ");

                if(temp.right != null)
                    dq.addFirst(temp.right);
                if(temp.left != null)
                    dq.addFirst(temp.left);
            }
            System.out.println("");
            size = dq.size();
            while(size > 0) {
                size--;
                Node temp = dq.removeFirst();
                System.out.print(temp.data + " ");

                if(temp.left != null)
                    dq.addLast(temp.left);
                if(temp.right != null)
                    dq.addLast(temp.right);
            }
            System.out.println("");
        }
    } 
    

    public static void main(String[] args) {  
        SpiralLevelOrderTraversal tree = new SpiralLevelOrderTraversal();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("");
        tree.spiralLevelOrderTraversal();
    }  
};  
     