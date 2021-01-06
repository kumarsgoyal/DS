import java.util.*; 

// Construct BST from given preorder traversal | Set 1


class ConstructBSTPreorder {  

    Node root;
    int preIndex;

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

    ConstructBSTPreorder() {
        root = null;
        preIndex = 0;
    }

    public void constructBSTPreorder(int[] pre) {
        if(pre.length == 0) {
            return;
        }

        root = new Node(pre[preIndex++]); 
        Stack<Node> stk = new Stack<>(); 

        stk.push(root);

        for(; preIndex < pre.length; preIndex++) {
            Node temp = null;

            while(stk.isEmpty() == false && pre[preIndex] > stk.peek().data)
                temp = stk.pop();

            if(temp == null) {
                temp = new Node(pre[preIndex]);
                stk.peek().left = temp;
                stk.push(temp);
            }
            else {
                temp.right = new Node(pre[preIndex]);
                stk.push(temp.right);
            }
        }
        
    } 

    public void printPreOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {  
        ConstructBSTPreorder tree = new ConstructBSTPreorder();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] pre = new int[size];

        System.out.println("Start entering elements of preorder: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            pre[i] = num;
        }

        tree.constructBSTPreorder(pre);

        tree.printPreOrder(tree.root);
    }  
};  
     