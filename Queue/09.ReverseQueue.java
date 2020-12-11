import java.util.*; 

  
class ReverseQueue {  
    Queue<Integer> que;

    ReverseQueue() {
        que = new LinkedList<>();
    }

    public void reverseQueueRecursion() {
        Stack<Integer> stk = new Stack<>();

        while(que.isEmpty() == false) {
            stk.push(que.remove());
        }

        while(stk.isEmpty() == false) {
            que.add(stk.pop());
        }
    }

    public static void main(String[] args) {  
        ReverseQueue q = new ReverseQueue();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            q.que.add(num);
        }

        System.out.println(q.que.toString());
        q.reverseQueueRecursion();
        System.out.println(q.que.toString());


    }  
};  
     