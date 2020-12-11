import java.util.*; 
  
// write a function to Find maximum length of valid parenthesis

class FindMaximumValidParenthesis { 
  
    public int findMaximumValidParenthesis(String str) 
    { 
        int result = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        for(int i = 0; i < str.length(); i++) {
        	char ch = str.charAt(i);

        	if(ch == '(' ) {
                stk.push(i);
            }
            else {
                stk.pop();

                if(stk.isEmpty() == true) {
                    stk.push(i);
                }   
                else {
                    result = Math.max(result, i - stk.peek());
                }
            }
        }

        return result;
    }



    public static void main(String[] args) 
    { 
    	FindMaximumValidParenthesis s = new FindMaximumValidParenthesis();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(s.findMaximumValidParenthesis(str));
    } 
} 