import java.util.*; 

// By making push operation costly
// Time Complexity:
// push operation: O(N).
// pop operation: O(1).
// Auxiliary Space: O(N) Use of stack for storing values.


  
class StackUsingQueuesPush {  
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
  
    public void push(int x) {  
        // Move all elements from q1 to q2  
        while (q1.size() > 0) 
        {  
            q2.add(q1.peek());
            q1.remove(); 
        }  
  
        // add item into q1  
        q1.add(x);  
  
        // Push everything back to 11  
        while (q2.size() > 0)  
        {  
            q1.add(q2.peek());  
            q2.remove();
        }  
    }  
  
    // pop an item from the queue  
    public int pop() {  
        // if first stack is empty  
        if (q1.size() == 0)  
        {  
            System.out.println("stack is Empty");  
            System.exit(0);  
        }  
  
        // Return top of s1  
        int x = q1.peek();
        q1.remove();  

        return x;  
    }

    public static void main(String[] args) {  
        StackUsingQueuesPush s = new StackUsingQueuesPush();  
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
