import java.util.*; 

// Write a function to Diagonal Traversal of Binary Tree


class DiagonalTraversal {  

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

    DiagonalTraversal() {
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

    public void diagonalTraversal() {
        if(root == null) {
            return;
        }
        
        Queue<Node> que = new LinkedList<>();

        que.add(root);
        que.add(null);

        while(que.size() > 0) {
            Node temp = que.remove();
            if(temp == null) {
                if(que.size() == 0) {
                    return;
                }

                System.out.println("");
                que.add(null);
            }
            else {
                while(temp != null) {
                    System.out.print(temp.data + " ");

                    if(temp.left != null) {
                        que.add(temp.left);
                    }
                    temp = temp.right;
                }
            }
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
        DiagonalTraversal tree = new DiagonalTraversal();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }


        tree.preOrderPrint(tree.root);
        System.out.println("");
        tree.diagonalTraversal();
    }  
};  
     