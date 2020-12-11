import java.util.*; 

// By making pop operation costly
// Time Complexity:
// push operation: O(1).
// pop operation: O(N).
// Auxiliary Space: O(N) Use of stack for storing values.


  
class StackUsingQueuesPop {  
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
  
    public void push(int x) {  
        // add item into q1  
        q1.add(x);  
    }  
  
    // pop an item from the queue  
    public int pop() {  
        // if first stack is empty  
        if (q1.size() == 0)  
        {  
            System.out.println("stack is Empty");  
            System.exit(0);  
        }  
            
        // move all item from q1 to q2
        while(q1.size() > 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        // Return front of q2  
        int x = q1.peek();
        q1.remove();  

        while(q2.size() > 0) {
            q1.add(q2.peek());
            q2.remove();
        }

        return x;  
    }

    public static void main(String[] args) {  
        StackUsingQueuesPop s = new StackUsingQueuesPop();  
        s.push(1);  
        s.push(2);  
        s.push(3);
        s.push(4);
        s.push(5);
      
        System.out.println(s.pop());  
        System.out.println(s.pop()); 
        System.out.println(s.pop()); 
    }  
};  
