import java.util.*; 

  
class StackUsingLinkedList {  

    int size;
    Node front;

    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    StackUsingLinkedList() {
        front = null;
        size = 0;
    }

    public void push(int num) {
        Node temp = new Node(num);
        size++;

        if(front == null) {
            front = temp;

        }
        else {
            temp.next = front;
            front = temp;
        }
    }   

    public int peek() {
        if(front == null) {
            return -1;
        }
        return front.data;
    }

    public int pop() {
        if(front == null) {
            return -1;
        }

        int result = front.data;
        front = front.next;

        return result;
    }
    public static void main(String[] args) {  
        StackUsingLinkedList s = new StackUsingLinkedList();  
        Scanner sc = new Scanner(System.in);

        // total no. of elements
        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        // array to store pages squence
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            s.push(num);
        }

        System.out.println("Peek() fruntion " + s.peek());

        for(int i = 0; i < size; i++) {
            System.out.println("pop() frunction " + s.pop());
        }

    }  
};  
     