import java.util.*; 

// Write Code to Determine if Two Trees are Identical


class IdenticalTrees {  
    Node root1;
    Node root2;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    IdenticalTrees() {
        root1 = null;
        root2 = null;
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

    public Boolean identicalTrees(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        while(true) {
            while(root1 != null && root2 != null) {
                if(root1.data != root2.data) {
                    return false;
                }
                st1.push(root1);
                st2.push(root2);

                root1 = root1.left;
                root2 = root2.left;
            }

            if((root1 == null && root2 == null) == false) {
                return false;
            }

            if(st1.isEmpty() == false && st2.isEmpty() == false) {
                root1 = st1.pop();
                root2 = st2.pop();

                root1 = root1.right;
                root2 = root2.right;
            }
            else {
                break;
            }
        }

        return true;
    }     

    public static void main(String[] args) {  
        IdenticalTrees tree = new IdenticalTrees();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size1 = sc.nextInt();
        System.out.println("Start entering elements: ");
        for(int i = 0; i < size1; i++) {
            int num = sc.nextInt();
            tree.root1 = tree.addNode(tree.root1, num);
        }

        System.out.println("Enter the total no of elements: ");
        int size2 = sc.nextInt();
        System.out.println("Start entering elements: ");
        for(int i = 0; i < size2; i++) {
            int num = sc.nextInt();
            tree.root2 = tree.addNode(tree.root2, num);
        }

        System.out.println(tree.identicalTrees(tree.root1, tree.root2));
    }  
};  
     