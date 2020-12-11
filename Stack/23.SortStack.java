import java.util.*; 

// Design and Implement function to sort a stack using recursion


class SortStack {

    Stack<Integer> stk = new Stack<>();

    public void pushToStack(int x) {
        if(stk.isEmpty() == false && stk.peek() > x) {
            int a = stk.pop();
            pushToStack(x);
            stk.push(a);
        }
        else {
            stk.push(x);
        }
    }

    public void sortStack() { 

        if(stk.size() > 0) {
            int a = stk.pop();
            sortStack();
            pushToStack(a);
        }

    } 

    public static void main(String[] args) {  
        SortStack s = new SortStack();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            s.stk.push(num);
        }

        System.out.println(s.stk.toString());
        s.sortStack();
        System.out.println(s.stk.toString());
    }  
};  
