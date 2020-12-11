import java.util.*; 

// Design and Implement function to sort a stack using recursion


class SortStack {

    Stack<Integer> stk = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    
    public void sortStack() { 
        while(stk.isEmpty() == false) {
            int a = stk.pop();

            while(temp.isEmpty() == false && temp.peek() > a) {
                stk.push(temp.pop());
            }

            temp.push(a);
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
        System.out.println(s.temp.toString());
    }  
};  
