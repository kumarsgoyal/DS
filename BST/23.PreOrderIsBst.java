import java.util.*; 

// Check if a given array can represent Preorder Traversal of Binary Search Tree


class PreOrderIsBst {  

    PreOrderIsBst() {

    } 

    public Boolean preOrderIsBst(int[] pre) {
        if(pre.length == 0) 
            return false;

        Stack<Integer> stk = new Stack<>();

        int root = Integer.MIN_VALUE;

        for(int i = 0; i < pre.length; i++) {

            if(root > pre[i]) {
                return false;
            }

            while(stk.isEmpty() == false && stk.peek() < pre[i]) {
                root = stk.pop();
            }

            stk.push(pre[i]);
        }

        return true;
    }

    public static void main(String[] args) {  
        PreOrderIsBst tree = new PreOrderIsBst();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        System.out.println(tree.preOrderIsBst(arr));

    }  
};  