import java.util.*; 

// Write a function to Reverse alternate levels of a perfect binary tree


/*
    Another is to do two inorder traversals. Following are steps to be followed
    1) Traverse the given tree in inorder fashion and store all odd level nodes
    in an auxiliary array. For the above example given tree, contents of array 
    become {h, i, b, j, k, l, m, c, n, o}

    2) Reverse the array. The array now becomes {o, n, c, m, l, k, j, b, i, h}
    
    3) Traverse the tree again inorder fashion. While traversing the tree, one 
    by one take elements from array and store elements from array to every odd level traversed node.
    For the above example, we traverse ‘h’ first in above array and replace ‘h’
    with ‘o’. Then we traverse ‘i’ and replace it with n.
*/


class ReverseAlternateLevel {  

    Node root;
    Vector vec;
    int i;
    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    ReverseAlternateLevel() {
        root = null;
        vec = new Vector();
        i = 0;
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

    public void getInorder(Node root, int lv) {
        if(root == null) {
            return;
        }

        getInorder(root.left, lv + 1);

        if(lv % 2 == 0)
            vec.add(root.data);

        getInorder(root.right, lv + 1);
    }

    public void putInorder(Node root, int lv) {
        if(root == null) {
            return;
        }

        putInorder(root.left, lv + 1);

        if(lv % 2 == 0) {
            root.data = (Integer)vec.get(i);
            i++;
        }

        putInorder(root.right, lv + 1);
    }

    public void reverseAlternateLevel() {
        if(root == null) {
            return;
        }
        
        getInorder(root, 1);
        System.out.println(vec);
        Collections.reverse(vec);
        System.out.println(vec);
        putInorder(root, 1);
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
        ReverseAlternateLevel tree = new ReverseAlternateLevel();  
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
        tree.reverseAlternateLevel();
        tree.preOrderPrint(tree.root);
    }  
};  
     