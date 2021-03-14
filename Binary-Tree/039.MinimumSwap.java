import java.util.*; 

// Minimum swap required to convert binary tree to binary search tree

class MinimumSwap {  

    int swap;

    class Index {
        int data;
        int index;
        Index(int x, int i) {
            data = x;
            index = i;
        }
    }

    class SortByIndex implements Comparator<Index> {
        public int compare(Index a, Index b) 
        { 
            return a.data - b.data; 
        } 
    }

    MinimumSwap () {
        swap = 0;
    }

    public void inOrderPrint(int[] in) {
        for(int i = 0; i < in.length; i++) {
            System.out.print(in[i] + " ");
        }
        System.out.println("");
    }

    public void fillData(Vector<Index> vec, int[] in) {
        int index = 0;
        for(int i = 0; i < in.length; i++) {
            vec.add(new Index(in[i], index));
            index++;
        }
    }

    public int minimumSwap(int[] in) {
        Vector<Index> t = new Vector<>();
        fillData(t, in);

        Collections.sort(t, new SortByIndex());

        for(int i = 0; i < t.size(); i++) 
        { 
            if(i == t.get(i).index) {
                continue; 
            }
            else
            { 
                Index temp = t.get(i);
                t.set(i, t.get(t.get(i).index));
                t.set(temp.index, temp);
            } 
          
            if(i != t.get(i).index) 
                --i; 
            swap++; 

        }

        return swap;
    }

    public static void main(String[] args) {  
        MinimumSwap tree = new MinimumSwap();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int[] in = new int[size];

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            in[i] = num;
        }


        tree.inOrderPrint(in);
        System.out.println(tree.minimumSwap(in));
    }  
};  
     