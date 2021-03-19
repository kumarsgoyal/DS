import java.util.*; 

// Check if each internal node of a BST has exactly one child

/*
    Algo:
    Since all the descendants of a node must either be larger or smaller than 
    the node. We can do following for every node in a loop.
    1. Find the next preorder successor (or descendant) of the node.
    2. Find the last preorder successor (last element in pre[]) of the node.
    3. If both successors are less than the current node, or both successors 
    are greater than the current node, then continue. Else, return false.
*/

class OneChild {  

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 

    }

    OneChild() {
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

    public boolean oneChildUtil(int[] pre) {
        int size = pre.length;
        int nextDiff, lastDiff;
        for(int i = 0; i < size - 1; i++) {
            nextDiff = pre[i] - pre[i + 1];
            lastDiff = pre[i] - pre[size - 1];
            if((nextDiff * lastDiff) < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean oneChild(int[] pre) {
        if(pre.length == 0) {
            return true;
        }
        
        return oneChildUtil(pre);
        
    }

    public static void main(String[] args) {  
        OneChild tree = new OneChild();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        int[] pre = new int[size];

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt(); 
            pre[i] = num;
        }

        System.out.println(tree.oneChild(pre));
    }   
};  
     