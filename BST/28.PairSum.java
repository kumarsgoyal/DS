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

        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();
        boolean done1 = false;
        boolean done2 = false;
        boolean done = true;
        Node curr1 = root1;
        Node curr2 = root2;
        int val1 = 0, val2 = 0;


        while(done == true) {
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

            if((val1 + val2) == sum) {
                System.out.println("pair (" + val1 + ", " + val2 + ")");
                 done1 = false;
                 done2 = false;
            }
            else if((val1 + val2) < sum) {
                done1 = false;
            }
            else {
                done2 = false;
            }

            if(stk1.isEmpty() == true && stk2.isEmpty() == true) {
                done = false;
            }
        }


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
     