import java.util.*; 

// Find if there is a triplet in a Balanced BST that adds to zero


class TripletSum {  

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

    TripletSum() {
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

    public Node findLca(Node root, int a, int b) {
        Node lca = root;

        while((a < lca.data && b < lca.data) || 
            (a > lca.data && b > lca.data)) {

            if(a < lca.data && b < lca.data) {
                lca = lca.left;
            }
            else {
                lca = lca.right;
            }
        }

        return lca;
    }

    public void fillOrder(Node root, Vector<Integer> vec) {
        if(root == null) {
            return;
        }
        fillOrder(root.left, vec);
        vec.add(root.data);
        fillOrder(root.right, vec);
    }

    public void tripletSumUtil(Vector<Integer> vec, int sum) {
        int size = vec.size();

        for(int i = 0; i < size - 2; i++) {
            int l = i + 1;
            int r = size - 1;

            while(l < r) {
                if((vec.elementAt(i) + vec.elementAt(l) + vec.elementAt(r)) == 
                    sum) {
                    System.out.println("pair ( " + vec.elementAt(i) + ", " + 
                        vec.elementAt(l) + ", " + vec.elementAt(r) + ")");
                l++;
                r--;
                }
                else if((vec.elementAt(i) + vec.elementAt(l) + vec.elementAt(r)) < sum) {
                    l++;
                }
                else {
                    r--;
                }
            }

        }
    }

    public void tripletSum(int sum) {
        if(root == null) {
            return ;
        }
        
        Vector<Integer> vec = new Vector<>();

        fillOrder(root, vec);
        tripletSumUtil(vec, sum);
    }

    public static void main(String[] args) {  
        TripletSum tree = new TripletSum();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        }

        System.out.println("Enter sum to find triplet element given sum: ");
        int sum = sc.nextInt();

        tree.tripletSum(sum);
    }   
};  
     