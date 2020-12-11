import java.util.*; 

//How to implement stack using priority queue or heap

  
class StackUsingPriorityQueue {  
    
    class Node {
        int data;
        int priority;

        Node(int a, int b) {
            data = a;
            priority = b;
        }

    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return b.priority - a.priority;

        }
    }

    PriorityQueue<Node> pQueue = new PriorityQueue<Node> (new NodeComparator());
    int p;

    StackUsingPriorityQueue() {
        p = 0;
    }

    public void push(int x) { 

        pQueue.add(new Node(x, p));
        p++;
    }  
  
    // pop an item from the queue  
    public int pop() {  
        // if first stack is empty  
        if (pQueue.size() == 0)  
        {  
            System.out.println("stack is Empty");  
            System.exit(0);  
        }  
         
        Node x = pQueue.peek();
        pQueue.remove();

        p--; // decrease priority

        return x.data;
    }

    public static void main(String[] args) {  
        StackUsingPriorityQueue s = new StackUsingPriorityQueue();  
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
