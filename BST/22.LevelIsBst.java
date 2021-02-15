import java.util.*; 

// Check if the given array can represent Level Order Traversal of Binary Search Tree
// Input : arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}


class LevelIsBst {  

    class Node {
        int data;
        int min;
        int max;
    }

    LevelIsBst() {
    } 

    public void levelIsBst(int[] arr) {
        if(arr.length == 0) 
            return ;

        int i = 0;
        int n = arr.length;
        Queue<Node> que = new LinkedList<>();

        Node detailsNode = new Node();
        detailsNode.data = arr[0];
        detailsNode.min = Integer.MIN_VALUE;
        detailsNode.max = Integer.MAX_VALUE;
        que.add(detailsNode);

        while(i != n && que.isEmpty() == false) {
            Node temp = que.remove();

            if(i < n && (arr[i] < temp.data && temp.min < arr[i])) {
                detailsNode.data = arr[i++];
                detailsNode.min = temp.min;
                detailsNode.max = temp.data;
                que.add(detailsNode);
            }

            if(i < n && (arr[i] > temp.data && temp.max > arr[i])) {
                detailsNode.data = arr[i++];
                detailsNode.min = temp.data;
                detailsNode.max = temp.max;
                que.add(detailsNode);
            }
        }

        if(i != n) {
            System.out.println("Level order is correct");
        }
        else {
            System.out.println("Level order is not correct");
        }
    }

    public static void main(String[] args) {  
        LevelIsBst tree = new LevelIsBst();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        tree.levelIsBst(arr);

    }  
};  