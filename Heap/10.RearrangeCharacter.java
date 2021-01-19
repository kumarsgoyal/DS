import java.util.*;

// Rearrange characters in a string such that no two adjacent are same

class  RearrangeCharacter {

	static class KeyComparator implements Comparator<Key> { 
		// Overriding compare()method of Comparator 
		public int compare(Key k1, Key k2) 
		{ 
			if (k1.freq < k2.freq) 
				return 1; 
			else if (k1.freq > k2.freq) 
				return -1; 
			return 0; 
		} 
	} 

	static class Key { 
		int freq; // store frequency of character 
		char ch; 
		Key(int val, char c)  
		{ 
			freq = val;  
			ch = c; 
		} 
	} 
	static void rearrange(String str) {
		String res = "";
		int[] farr = new int[26]; // freq array to store freq. of array
		int n = str.length();

		for(int i = 0; i < n; i++) {
			farr[str.charAt(i) - 'a']++;
		}

		// Insert all characters with their frequencies 
		// into a priority_queue  
		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator()); 
		for (char c = 'a'; c <= 'z'; c++) { 
			int val = c - 'a'; 
			if (farr[val] > 0) 
				pq.add(new Key(farr[val], c)); 
		}

		Key prev = new Key(-1, '#'); 
  
		// traverse queue 
		while (pq.size() != 0) { 
                
			// pop top element from queue and add it to string. 
			Key k = pq.peek(); 
			pq.poll(); 
			res = res + k.ch; 
	  
			// If frequency of previous character is less than zero that means
			// it is useless, we  need not to push it  
			if (prev.freq > 0) 
				pq.add(prev); 
	  
			// make current character as the previous 'char' decrease frequency
			// by 'one'
			(k.freq)--; 
			prev = k; 
		} 

		// If length of the resultant string and original 
		// string is not same then string is not valid 
		if (n != res.length()) 
			System.out.println(" Not valid String "); 
		else
			System.out.println(res);
                   

	}

    public static void main(String[] args) {

    	System.out.println("Enter String");
    	Scanner sc = new Scanner(System.in);
    	String str = sc.next();

    	rearrange(str);

    }
}