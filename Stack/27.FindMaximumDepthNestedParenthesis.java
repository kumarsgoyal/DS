import java.util.*; 
  
// write a function to Find maximum depth of nested parenthesis in a string

class FindMaximumDepthNestedParenthesis { 
  
    public int findMaximumDepthNestedParenthesis(String str) 
    { 
        int result = 0;
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);

        	if(ch != '(' && ch != ')') {
        		continue;
        	}
        	else if(ch == '('){
        		stk.push(ch);

        		if(stk.size() > result) {
        			result = stk.size();
        		}
        	}
        	else { // ')'
        		if(stk.size() > 0) {
        			stk.pop();	
        		}
        		else {
        			return -1;
        		}
        	}
        }

        if(stk.isEmpty() == true) {
        	return result;	
        }

        return -1;
    }

/*
    public int findMaximumDepthNestedParenthesis(String str) 
    { 
        int result = 0;
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);

        	if(ch != '(' && ch != ')') {
        		continue;
        	}
        	else if(ch == '('){
        		count++;

        		if(count > result) {
        			result = count;
        		}
        	}
        	else { // ')'
        		if(count > 0) {	
        			count--;
        		}
        		else {
        			return -1;
        		}
        	}
        }

        if(count == 0) {
        	return result;
        }

        return -1;
    }
*/



    public static void main(String[] args) 
    { 
    	FindMaximumDepthNestedParenthesis s = new FindMaximumDepthNestedParenthesis();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(s.findMaximumDepthNestedParenthesis(str));
    } 
} 