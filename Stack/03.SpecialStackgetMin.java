import java.util.*; 

// Design and Implement Special Stack Data Structure that give min value in O(1)

  
class SpecialStack {  
    Stack<Integer> s1 = new Stack<Integer>();  
  
    public void push(int x) { 
        if(s1.isEmpty()) {
            s1.push(x);
            s1.push(x);
        }
        else {
            int min = s1.peek();
            if(x < min) {
                min = x;
            }

            s1.push(x);
            s1.push(min);
        }
    }  
  
    // pop an item from the stack  
    public int pop() {  
        // if first stack is empty  
        if (s1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);
        } 

        s1.pop();

        return s1.pop();
    }

    public int getMin() {
        return s1.peek();
    }

    public static void main(String[] args) {  
        SpecialStack q = new SpecialStack();  
        q.push(1);  
        q.push(2);  
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(1);  
        q.push(2);  
        q.push(3);
      
        System.out.println("pop() : " + q.pop());  
        System.out.println("min : " + q.getMin());
    }  
};  
     