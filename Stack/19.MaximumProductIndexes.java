import java.util.*; 

// Design and Implement function to find Maximum product of indexes of next 
// greater on left and right


  
class MaximumProductIndexes {

    public void printArray(int[] l, int[] r, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print((l[i]*r[i]) + " ");
        }
    }

    public void maximumProductIndexes(int[] arr, int n) { 
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int[] l = new int[n];
        int[] r = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(stk.isEmpty() == false && arr[stk.peek()] < arr[i]) {
                r[stk.peek()] = i+1;
                stk.pop();
            }

            stk.push(i);
        }

        while(stk.isEmpty() == false) {
            r[stk.peek()] = 0;
            stk.pop();
        }

        for(int i = n-1; i >= 0; i--) {
            while(stk.isEmpty() == false && arr[stk.peek()] < arr[i]) {
                l[stk.peek()] = i+1;
                stk.pop();
            }

            stk.push(i);
        }

        while(stk.isEmpty() == false) {
            l[stk.peek()] = 0;
            stk.pop();
        }

        printArray(l, r, n);
    } 

    public static void main(String[] args) {  
        MaximumProductIndexes s = new MaximumProductIndexes();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        s.maximumProductIndexes(arr, n);
    }  
};  
