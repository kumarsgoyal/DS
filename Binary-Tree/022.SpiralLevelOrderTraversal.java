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
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(s1.isEmpty() == false) {
            while(s1.isEmpty() == false) {
                Node temp = s1.pop();
                System.out.print(temp.data + " ");
                
                if(temp.left != null) {
                    s2.push(temp.left);
                }
                if(temp.right != null) {
                    s2.push(temp.right);
                }
            }

            System.out.println("");

            while(s2.isEmpty() == false) {
                Node temp = s2.pop();
                System.out.print(temp.data + " ");
                
                if(temp.right != null) {
                    s1.push(temp.right);
                }
                if(temp.left != null) {
                    s1.push(temp.left);
                }
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
     