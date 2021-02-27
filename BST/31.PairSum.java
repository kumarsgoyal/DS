import java.util.*; 

// Find pairs with given sum such that pair elements lie in same BSTs
// set based approach

class PairSum {  

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

    PairSum() {
        root = null;
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

    public boolean pairSumUtil(Node root, Set<Integer> hs, int sum) {
        if(root == null) {
            return false;
        }

        if(pairSumUtil(root.left, hs, sum) == true) {
            return true;
        }

        if(hs.contains(sum - root.data) == true) {
            System.out.println("Pair found (" + root.data + ", " + 
                (sum - root.data) + ")");

            return true;
        }
        else {
            hs.add(root.data);
        }


        return pairSumUtil(root.right, hs, sum);
    }

    public void pairSum(int sum) {
        if(root == null) {
            return;
        }

        Set<Integer> hs = new HashSet<Integer>();
        
        if(pairSumUtil(root, hs, sum) == false) {
            System.out.println("pair not found");
        }

    }

    public static void main(String[] args) {  
        PairSum tree = new PairSum();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter sum to find pair");
        int sum = sc.nextInt();

        tree.pairSum(sum);
    }   
};  
     