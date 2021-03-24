import java.util.*; 

// Check if all leaves are at same level


class LeafLevel {  

    Node root;
    int lv;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    LeafLevel () {
        root = null;
        lv = 0;
    }

    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data <= num) {
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

    public boolean leafLevel() {
        if(root == null) {
            return true;
        } 

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // to watch level
        lv++;
        int l = 0;

        while(q.isEmpty() == false) {
            Node temp = q.remove();

            if(temp != null) {

                // if curr root is having left child add it to queue
                if(temp.left != null)
                    q.add(temp.left);
                // if curr root is having right child add it to queue
                if(temp.right != null) 
                    q.add(temp.right);

                if(temp.left == null && temp.right == null) {
                    if(l == 0){
                        l = lv;
                    }
                    if(l != lv) {
                        return false;
                    }
                }
                // System.out.println(temp.data + "  lv:" + lv + "    l:" + l);

            }
            else {
                System.out.println("");

                // if curr element is null and Queue is not empty that mean
                // more level are remaining so add null to Queue
                if(q.isEmpty() == false) {
                    q.add(temp);
                }
                lv++;
            }
        }

        return true;

    }

    public static void main(String[] args) {  
        LeafLevel tree = new LeafLevel();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        tree.inOrderPrint(tree.root); 
        System.out.println(""); 

        if(tree.leafLevel() == true) { 
            System.out.println("Yes"); 
        } 
        else { 
            System.out.println("No"); 
        }
    }  
};  
     