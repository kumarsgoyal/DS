import java.util.*; 

// Check if an array represents Inorder of Binary Search tree or not


class IsInorder {  

    IsInorder() {

    }

    public boolean isInorder(int[] in) {
        if(in.length == 0) {
            return false;
        }
        
        for(int i = 1; i < in.length; i++) {
            if(in[i - 1] > in[i]) {
                return false;
            }
        }

        return true;
        
    }

    public static void main(String[] args) {  
        IsInorder tree = new IsInorder();  
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of elements: ");
        int size = sc.nextInt();

        int[] in = new int[size];

        System.out.println("Start entering elements to find is it represents" + 
            " inorder ot not: ");

        for(int i = 0; i < size; i++) {
            int num = sc.nextInt(); 
            in[i] = num;
        }

        System.out.println(tree.isInorder(in));
    }   
};  
     