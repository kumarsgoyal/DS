import java.util.*; 

// Design and Implement function to stock span problem

  
class StockSpanProblem { 

    public void printArray(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void stockSpanProblem(int[] arr, int n) { 
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];
            
        stk.push(0); 
        res[0] = 1; 

        for(int i = 1; i < n; i++) { 
            if(stk.isEmpty() == false && arr[stk.peek()] <= arr[i]) { 
                stk.pop();
            } 

            res[i] = (stk.isEmpty() == true) ? (i + 1) : (i - stk.peek());

            stk.push(i); 
        }

        printArray(res, n);
    } 

    public static void main(String[] args) {  
        StockSpanProblem s = new StockSpanProblem();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        s.stockSpanProblem(arr, n);
    }  
};  
