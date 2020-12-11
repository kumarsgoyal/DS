import java.util.*; 

// Design and Implement function to find maximum rectangle area


class LargestRectangularAreaHistogram {

    
    public void largestRectangularAreaHistogram(int[] arr, int n) { 
        Stack<Integer> stk = new Stack<>();
        int max = 0;

        for(int i = 0; i < n; i++) {
            while(stk.isEmpty() == false && arr[stk.peek()] > arr[i]) {
                int top = stk.pop();
                int dist = (stk.isEmpty() == true) ? i : i - stk.peek() - 1;
                int area = arr[top] * dist;

                if(area > max) {
                    max = area;
                }
            }

            stk.push(i);
        }

        System.out.println("maximum area : " + max);

    } 

    public static void main(String[] args) {  
        LargestRectangularAreaHistogram s = 
            new LargestRectangularAreaHistogram();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        s.largestRectangularAreaHistogram(arr, n);
    }  
};  
