import java.util.*; 

// Design and Implement function to find next greater frequency element

  
class NextGreaterFrequencyElement {

    public void printArray(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void nextGreaterFrequencyElement(int[] arr, int n) { 
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            if(mp.containsKey(arr[i]) == true) {
                mp.put(arr[i], (mp.get(arr[i]) + 1));
            }
            else {
                mp.put(arr[i], 1);
            }
        }
        
        for(int i = 0; i < n; i++) {
            while(stk.isEmpty() == false && mp.get(arr[stk.peek()]) < mp.get(arr[i])) {
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
        NextGreaterFrequencyElement s = new NextGreaterFrequencyElement();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements");

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        s.nextGreaterFrequencyElement(arr, n);
    }  
};  
