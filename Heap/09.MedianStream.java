import java.util.*;

// Median in a stream of integers (running integers)


class  MedianStream {

	// upper half is min heap
	// lower half is max heap
	static PriorityQueue<Integer> min = new PriorityQueue<>();
	static PriorityQueue<Integer> max = 
		new PriorityQueue<>(Collections.reverseOrder());
	static int size1 = 0; // size of max heap
	static int size2 = 0; // size of min heap

	static int median(int num) {
		// if num is less than max.peek() than it is part of lower half
		// else part of upper half
		if(size1 == 0 || max.peek() > num) {
			size1++;
			max.add(num);
		}
		else {
			size2++;
			min.add(num);
		}

		// if diff between size of heap is greater then one than balance it.
		if(Math.abs(size2 - size1) > 1) {
			if(size2 > size1) {
				max.add(min.poll());
				size1--;
				size2++;
			}
			else {
				min.add(max.poll());
				size2--;
				size1++;
			}
		}

		if((size1 + size2) % 2 == 1) {
			if(size1 > size2) {
				return max.peek();
			}
			else {
				return min.peek();
			}
		}
		else {
			return ((max.peek() + min.peek()) / 2);
		}
	}

    public static void main(String[] args) {

    	System.out.println("Start entering elements enter -1 to stop");
    	Scanner sc = new Scanner(System.in);
    	int num = sc.nextInt();

        while(num != -1) {
        	System.out.println(median(num) + " ");
        	num = sc.nextInt();
        }

    }
}