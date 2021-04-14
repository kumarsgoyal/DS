import java.util.*; 

// Print nodes between two given level numbers of a binary tree

class PrintGivenLevels {  
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    PrintGivenLevels() {
        root = null;
    }


    public Node addNode(Node root, int num) {
        if(root == null) {
            return new Node(num);
        }
        if(root.data < num) {
            root.right = addNode(root.right, num);
        }
        else {
            root.left = addNode(root.left, num);
        }
        return root;
    }

    public void printGivenLevels(Node root, int l1, int l2) {
    	if(root == null || l1 > l2) {
    		return;
    	}

        Queue<Node> que = new LinkedList<>();
        int l = 1;

        que.add(root);
        que.add(null);

        while(que.isEmpty() == false) {
            Node temp = que.remove();

            if(temp == null) {
                if(que.isEmpty() == false) {
                    l++;
                    que.add(null);
                }
            }
            else {
                if(l >= l1 && l <= l2)
                    System.out.print(temp.data + " ");

                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }
        }

    }     

    public static void main(String[] args) {  
        PrintGivenLevels tree = new PrintGivenLevels();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");
        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            tree.root = tree.addNode(tree.root, num);
        
        }
        System.out.println("Enter level from and two");
        int l1 = sc.nextInt();
        int l2 = sc.nextInt();
        tree.printGivenLevels(tree.root, l1, l2);
    }  
};  
