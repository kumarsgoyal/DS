import java.util.*; 

// Sum of k smallest elements in BST


class SumKSmallestElement {  

    Node root;
    int k;
    int sum;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    SumKSmallestElement() {
        root = null;
        k = sum = 0;
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

    public void sumKSmallestElementUtil(Node root, int kth) {
        if(root == null) {
            return;
        }

        sumKSmallestElementUtil(root.left, kth);

        if(k < kth) {
            k++;
            sum += root.data;
        }

        sumKSmallestElementUtil(root.right, kth);

        
    }

    public void sumKSmallestElement(int kth) {
        if(root == null) {
            return ;
        }
        
        sumKSmallestElementUtil(root, kth);
    }

    public static void main(String[] args) {  
        SumKSmallestElement tree = new SumKSmallestElement();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter value to find predecessor successor");
        int kth = sc.nextInt();

        tree.sumKSmallestElement(kth);
        System.out.println("Sum: " + tree.sum);
    }   
};  
     