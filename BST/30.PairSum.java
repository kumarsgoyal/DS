import java.util.*; 

// Find pairs with given sum such that pair elements lie in same BSTs


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

    public boolean pairSumUtil(Node root, int sum) {
        if(root == null) {
            return false;
        }

        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();
        boolean done1 = false;
        boolean done2 = false;
        Node curr1 = root;
        Node curr2 = root;
        int val1 = 0, val2 = 0;


        while(true) {
            while(done1 == false) {
                if(curr1 != null) {
                    stk1.push(curr1);
                    curr1 = curr1.left;
                }
                else {
                    if(stk1.isEmpty() == true) {
                        done1 = true;
                    }
                    else {
                        curr1 = stk1.pop();
                        val1 = curr1.data;
                        curr1 = curr1.right;
                        done1 = true;
                    } 
                }
            }

            while(done2 == false) {
                if(curr2 != null) {
                    stk2.push(curr2);
                    curr2 = curr2.right;
                }
                else {
                    if(stk2.isEmpty() == true) {
                        done2 = true;
                    } 
                    else {
                        curr2 = stk2.pop();
                        val2 = curr2.data;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }   

            if(val1 >= val2) {
                return false;
            }

            if((val1 + val2) == sum) {
                System.out.println("pair (" + val1 + ", " + val2 + ")");
                done1 = false;
                done2 = false;
                // return true;
            }
            else if((val1 + val2) < sum) {
                done1 = false;
            }
            else {
                done2 = false;
            }
        }
    }

    public void pairSum(int sum) {
        if(root == null) {
            return;
        }
        
        pairSumUtil(root, sum);

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
     