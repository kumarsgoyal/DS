import java.util.*; 

// By making pop operation costly
// Time Complexity:
// push operation: O(1).
// pop operation: O(N).
// Auxiliary Space: O(N) Use of stack for storing values.


  
class StackUsingSingleQueue {  
    Queue<Integer> q = new LinkedList<>();
  
    public void push(int x) {  
        int size = q.size();
        
        q.add(x);

        for(int i = 0; i < size; i++) {
            q.add(q.peek());
            q.remove();
        }
    }  
  
    // pop an item from the queue  
    public int pop() {  
        // if first stack is empty  
        if (q.size() == 0)  
        {  
            System.out.println("stack is Empty");  
            System.exit(0);  
        }  
         
        int x = q.peek();
        q.remove();

        return x;
    }

    public static void main(String[] args) {  
        StackUsingSingleQueue s = new StackUsingSingleQueue();  
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
