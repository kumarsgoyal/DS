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
        Queue<Node> que = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        boolean reverse = false;
        que.add(root);   

        while(que.size() > 0) {
            int size = que.size();

            while(size > 0) {
                size--;
                Node temp = que.remove();

                if(reverse == true) {
                    stk.push(temp.data);
                }
                else {
                    System.out.print(temp.data + " ");
                }

                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }


            // if reverse os stk is not empty mean reverse print
            while(stk.isEmpty() == false) {
                System.out.print(stk.pop() + " ");
            }

            System.out.println("");
            reverse = !reverse;
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
     