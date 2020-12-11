import java.util.*; 

// Design and Implement function to find next greater element

  
class NextGreaterElement { 

    public void printArray(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void nextGreaterElement(int[] arr, int n) { 
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(stk.isEmpty() == false && arr[stk.peek()] < arr[i]) {
                res[stk.peek()] = arr[i];
                stk.pop();
            }

            stk.push(i);
        }

        while(stk.isEmpty() == false) {
            res[stk.peek()] = -1;
            stk.pop();
        }

        printArray(res, n);
    } 

    public static void main(String[] args) {  
        NextGreaterElement s = new NextGreaterElement();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        s.nextGreaterElement(arr, n);
    }  
};  
