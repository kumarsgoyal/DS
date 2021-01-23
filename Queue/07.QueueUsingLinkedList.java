import java.util.*; 

  
class QueueUsingLinkedList {  

    Node front, rear;

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    QueueUsingLinkedList() {
        front = rear = null;
    }

    public void enQueue(int num) {

        Node temp = new Node(num);
        if(rear == null) {
            front = temp;
            rear = temp;
        }
        else {
            rear.next = temp;
            rear = temp;
        }
    }

    public int deQueue() {
        if(front == null) {
            return -1;
        }

        int result = front.data;
        front = front.next;

        return result;
    }
    public static void main(String[] args) {  
        QueueUsingLinkedList q = new QueueUsingLinkedList();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            q.enQueue(num);
        }

        for(int i = 0; i < size; i++) {
            System.out.println("\t" + q.deQueue());
        }

    }  
};  
     