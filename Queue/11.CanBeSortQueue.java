import java.util.*; 

// Check if a queue can be sorted into another queue using a stack

  
class CanBeSortQueue {  
    Queue<Integer> que;

    CanBeSortQueue() {
        que = new LinkedList<>();
    }


    public boolean canBeSortQueue() {
        int size = que.size();
        int expected = 1;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < size; i++) {
            int currValue = que.remove();
            if(expected == currValue) {
                que.add(currValue);
                expected++;
            }
            else {
                if(stk.isEmpty() == false && stk.peek() < currValue) {
                    return false;
                }
                else {
                    stk.push(currValue);
                }
            }

            while (stk.isEmpty() == false && stk.peek() == expected)  
            { 
                que.add(stk.pop());
                expected++; 
            } 
        }

        if(expected - 1 == size && stk.size() == 0) {
            return true;            
        }

        return false;
    }

    public static void main(String[] args) {  
        CanBeSortQueue q = new CanBeSortQueue();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            q.que.add(num);
        }


        System.out.println(q.que.toString());

        if(q.canBeSortQueue() == true) {
            System.out.println(q.que.toString());    
        }
        else {
            System.out.println("Can not sort");
        }

    }  
};  
     