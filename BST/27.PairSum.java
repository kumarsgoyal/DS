import java.util.*; 

// Find pairs with given sum such that pair elements lie in different BSTs


class PairSum {  

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

    PairSum() {
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
        else if(root.data > num) {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void fillOrder(Node root, Vector<Integer> vec) {
        if(root == null) {
            return;
        }

        fillOrder(root.left, vec);
        vec.add(root.data);
        fillOrder(root.right, vec);
    }

    public void pairSumUtil(Vector<Integer> vec1, Vector<Integer> vec2, int sum) {
        int left = 0;
        int right = vec2.size() - 1;

        while(left < vec1.size() && right >= 0) {
            if(vec1.elementAt(left) + vec2.elementAt(right) == sum)
            {
                System.out.println(vec1.elementAt(left) + ", " +
                     vec2.elementAt(right) + "\t");
                left++;
                right--;
            }
            else if((vec1.elementAt(left) + vec2.elementAt(right)) < sum) {
                left++;
            }
            else {
                right--;
            }
        }
    }

    public void pairSum(int sum) {
        if(root1 == null || root2 == null) {
            return;
        }

        Vector<Integer> vec1 = new Vector<Integer>();
        Vector<Integer> vec2 = new Vector<Integer>();
        fillOrder(root1, vec1);
        fillOrder(root2, vec2);

        pairSumUtil(vec1, vec2, sum);

    }

    public static void main(String[] args) {  
        PairSum tree = new PairSum();  
        Scanner sc = new Scanner(System.in);

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

        System.out.println("Enter sum to find pair");
        int sum = sc.nextInt();

        tree.pairSum(sum);
    }   
};  
     