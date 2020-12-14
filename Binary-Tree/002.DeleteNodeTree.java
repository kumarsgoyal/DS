import java.util.*; 

// Write a function to delete given node
  
class DeleteNodeTree {  
    Node root;
    Node rightMost;
    boolean flag;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        } 
    }

    DeleteNodeTree() {
        root = null;
        rightMost = null;
        flag = true;
    }


    public void addNode(Queue<Integer> q) {
        if(q.isEmpty() == true) {
            return;
        }

        Queue<Node> que = new LinkedList<>();
        Node top = new Node(q.remove());
        que.add(top);
        root = top;

        while(q.isEmpty() == false) {
            Node temp = que.remove();
            temp.left = new Node(q.remove());
            que.add(temp.left);

            if(q.isEmpty() == false ){
                temp.right = new Node(q.remove());
                que.add(temp.right);
            }
        }
    }

    public void inorderTreePrint(Node temp) {
        if(temp == null) {
            return;
        }
        inorderTreePrint(temp.left);
        System.out.print(temp.data + " ");
        inorderTreePrint(temp.right);
    }   

    public Node findNode(Node temp, int x) {
        if(temp == null) {
            return null;
        }

        if(temp.data == x) {
            return temp;
        }

        Node left = findNode(temp.left, x);
        Node right = findNode(temp.right, x);

        if(left == null) {
            return right;
        }
        return left;
    }   

    public Node nodeRightMost(Node temp) {
        if(temp == null) {
            return null;
        }

        if(temp.right != null) {
            Node node = nodeRightMost(temp.right);
            if(node == null) {
                return temp;
            }
            if(flag == true) {
                rightMost = temp;
                flag = false;
            }
            return node;
        }
        else if(temp.left != null){
            Node node = nodeRightMost(temp.left);
            if(node == null) {
                return temp;
            }
            if(flag == true) {
                rightMost = temp;
                flag = false;
            }
            return node;
        }
        return null;
    }

    public void deleteNode(int x) {
        Node deletedNode = findNode(root, x);
        Node node = nodeRightMost(root);
        int data = 0;

        if(deletedNode != null) {
            if(node.right != null) {
                if(node.right.data == x) {
                    node.right = null;
                }
                else {
                    data = node.right.data;
                    node.right = null;
                    deletedNode.data = data;
                }
            }
            else {
                if(node.left.data == x) {
                    node.left = null;
                }
                else {
                    data = node.left.data;
                    node.left = null;
                    deletedNode.data = data;
                }
            }
        }
    }

    public static void main(String[] args) {  
        DeleteNodeTree tree = new DeleteNodeTree();  
        Scanner sc = new Scanner(System.in);
        Queue<Integer> que = new LinkedList<>();

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        System.out.println("Start entering elements: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt();
            que.add(num);
        }

        tree.addNode(que);
        tree.inorderTreePrint(tree.root);
        System.out.println("Enter value to be deleted");
        int del = sc.nextInt();
        tree.deleteNode(del);
        tree.inorderTreePrint(tree.root);

    }  
};  
     