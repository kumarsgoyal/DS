import java.util.*; 

// Design and Implement function to Reverse a stack using recursion


class ReverseStack {

    Stack<Integer> stk = new Stack<>();

    public void pushToStack(int x) {
        if(stk.isEmpty() == true) {
            stk.push(x);
        }
        else {
            int a = stk.pop();
            pushToStack(x);
            stk.push(a);
        }
    }

    public void reverseStack() { 

        if(stk.size() > 0) {
            int a = stk.pop();
            reverseStack();
            pushToStack(a);
        }

    } 

    public static void main(String[] args) {  
        ReverseStack s = new ReverseStack();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            s.stk.push(num);
        }

        System.out.println(s.stk.toString());
        s.reverseStack();
        System.out.println(s.stk.toString());
    }  
};  
