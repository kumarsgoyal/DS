import java.util.*; 

//How to implement queue using Deque

  
class QueueUsingdeQueue {  

	Deque<Integer> deQue = new LinkedList<Integer>(); 

    public void add(int x) { 
        deQue.addLast(x);
    }  
  
    // pop an item from the queue  
    public int remove() {  
        // if first stack is empty  
        if (deQue.size() == 0)  
        {  
            System.out.println("stack is Empty");  
            System.exit(0);  
        }  
         
        int x = deQue.peekFirst(); // or deQue.removeLast()
        deQue.removeFirst();

        return x;
    }

    public static void main(String[] args) {  
        QueueUsingdeQueue q = new QueueUsingdeQueue();  
        q.add(1);  
        q.add(2);  
        q.add(3);
        q.add(4);
        q.add(5);
      
        System.out.println(q.remove());  
        System.out.println(q.remove()); 
        System.out.println(q.remove()); 
    }  
};  
