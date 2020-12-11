import java.util.*; 

  
class ReverseQueueRecursion {  
    Queue<Integer> que = new LinkedList<>();

    public void reverseQueueRecursion() {
        if(que.isEmpty() == true) {
            return;
        }

        int data = que.remove();
        reverseQueueRecursion();
        que.add(data);
    }

    public static void main(String[] args) {  
        ReverseQueueRecursion q = new ReverseQueueRecursion();  
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
     