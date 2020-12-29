import java.util.*; 

// By making deQueue operation costly

// Time Complexity:
// enQueue operation: O(1).
// deQueue operation: O(N).
// Auxiliary Space: O(N) Use of stack for storing values.

  
class QueueUsingStacksdeQueue {  
    Stack<Integer> s1 = new Stack<Integer>();  
    Stack<Integer> s2 = new Stack<Integer>();  
  
    public void enQueue(int x) {  
        s1.push(x);   
    }  
  
    // Dequeue an item from the queue  
    public int deQueue() {  
        // if first stack is empty  
        if (s1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);
        }  
  
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int result = s2.pop();

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return result;
    }

    public static void main(String[] args) {  
        QueueUsingStacksdeQueue q = new QueueUsingStacksdeQueue();  
        q.enQueue(1);  
        q.enQueue(2);  
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
      
        System.out.println(q.deQueue());  
        System.out.println(q.deQueue()); 
        System.out.println(q.deQueue()); 
    }  
};  
     