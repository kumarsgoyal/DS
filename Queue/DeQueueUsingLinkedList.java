import java.util.*; 

  
class DeQueueUsingLinkedList {  

    Node front, rear;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int x) {
            data = x;
            next = null;
            prev = null;
        }
    }

    DeQueueUsingLinkedList() {
        front = rear = null;
    }

    public void enQueueFront(int num) {
        Node temp = new Node(num);
        if(front == null) {
            front = temp;
            rear = temp;
        }
        else {
            temp.next = front;
            front.prev = temp;
            front = temp;
        }
    }

    public void enQueueRear(int num) {
        Node temp = new Node(num);
        if(rear == null) {
            front = temp;
            rear = temp;
        }
        else {
            temp.prev = rear;
            rear.next = temp;
            rear = temp;
        }
    }

    public int deQueueFront() {
        if(front == null) {
            return -1;
        }

        int result = front.data;
        front = front.next;
        front.prev = null;
        return result;
    }

    public int deQueueRear() {
        if(rear == null) {
            return -1;
        }

        int result = rear.data;
        rear = rear.prev;
        rear.next = null;
        return result;
    }

    public int getFront() {
        if(front == null) {
            return -1;
        }
        return front.data;
    }

    public int getRear() {
        if(rear == null) {
            return -1;
        }
        return rear.data;
    }


    public static void main(String[] args) {  
        DeQueueUsingLinkedList q = new DeQueueUsingLinkedList();  
        Scanner sc = new Scanner(System.in);

        // total no. of elements
        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        boolean flag = true;
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            if(flag == true) {
                q.enQueueFront(num);    
            }
            else {
                q.enQueueRear(num);
            }
            flag = !flag;
        }

        System.out.println("getFront(): " + q.getFront());
        System.out.println("getRear(): " + q.getRear());

        System.out.println("deQueueFront(): " + q.deQueueFront());
        System.out.println("deQueueRear(): " + q.deQueueRear());

        System.out.println("getFront(): " + q.getFront());
        System.out.println("getRear(): " + q.getRear());


    }  
};  
     
