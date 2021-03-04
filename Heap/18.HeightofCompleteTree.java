import java.util.*;

// Height of a complete binary tree (or Heap) with N nodes


class  HeightofCompleteTree {


	static int height(int N) {

		return (int)Math.ceil(Math.log(N + 1) / Math.log(2)); 
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of nodes in binary heap: ");
    	int N = sc.nextInt();

    	System.out.println(height(N));

    }
}