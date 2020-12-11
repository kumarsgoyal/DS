import java.util.*; 

  
class SortQueue {  
    Queue<Integer> que;

    SortQueue() {
        que = new LinkedList<>();
    }

    public int getMinIndex(int sortedIndex) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        int size = que.size();
        for(int i = 0; i < size; i++) {
            int currValue = que.remove();

            // we add the condition i <= sortIndex 
            // because we don't want to traverse 
            // on the sorted part of the queue, 
            // which is the right part. 

            if(currValue < minValue && i < sortedIndex) {
                minValue  = currValue;
                minIndex = i;
            }

            que.add(currValue);
        }

        return minIndex;
    }

    public void insertToRear(int index) {
        int minValue = Integer.MAX_VALUE;
        int size = que.size();
        for(int i = 0; i < size; i++) {
            int currValue = que.remove();
            if(i != index) {
                que.add(currValue);
            }
            else {
                minValue = currValue;
            }
        }
        que.add(minValue);
    }

    public void sortQueue() {
        int size = que.size();
        for(int i = 0; i < size; i++) {
            int minIndex = getMinIndex(size - i);
            insertToRear(minIndex);
        }
    }

    public static void main(String[] args) {  
        SortQueue q = new SortQueue();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            q.que.add(num);
        }


        System.out.println(q.que.toString());
        q.sortQueue();
        System.out.println(q.que.toString());


    }  
};  
     