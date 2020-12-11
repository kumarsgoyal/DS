import java.util.*; 

//How to implement Stack using Deque

  
class StackUsingdeQueue {  

	Deque<Integer> deQue = new LinkedList<Integer>(); 

    public void push(int x) { 
        deQue.addLast(x);
    }  
  
    // pop an item from the queue  
    public int pop() {  
        // if first stack is empty  
        if (deQue.size() == 0)  
        {  
            System.out.println("stack is Empty");  
            System.exit(0);  
        }  
         
        int x = deQue.peekLast(); // or deQue.removeLast()
        deQue.removeLast();

        return x;
    }

    public static void main(String[] args) {  
        StackUsingdeQueue s = new StackUsingdeQueue();  
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
