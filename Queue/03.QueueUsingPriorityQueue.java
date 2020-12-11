import java.util.*; 

//How to implement queue using priority queue or heap

  
class QueueUsingPriorityQueue {  
    
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
            return a.priority - b.priority;

        }
    }

    PriorityQueue<Node> pQueue = new PriorityQueue<Node> (new NodeComparator());
    int p;

    QueueUsingPriorityQueue() {
        p = 0;
    }

    public void add(int x) { 

        pQueue.add(new Node(x, p));
        p++;
    }  
  
    // pop an item from the queue  
    public int remove() {  
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
        QueueUsingPriorityQueue s = new QueueUsingPriorityQueue();  
        s.add(1);  
        s.add(2);  
        s.add(3);
        s.add(4);
        s.add(5);
      
        System.out.println(s.remove());  
        System.out.println(s.remove()); 
        System.out.println(s.remove()); 
    }  
};  
