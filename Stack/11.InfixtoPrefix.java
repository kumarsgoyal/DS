import java.util.*; 

// Design and Implement function to convert Infix to Prefix
// input: a+b*(c^d-e)^(f+g*h)-i
// output:      -^abcde+*fgh+*^-i

/*  
    Steps for infix to prefix
    Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note 
        while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
    Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
    Step 3: Reverse the postfix expression. Hence in our example prefix is :
        +A*BC.


	Steps for infix to postfix:
	1. Scan the infix expression from left to right.
	2. If the scanned character is an operand, output it.
	3. Else,
		3.1 If the precedence of the scanned operator is greater than the 
			precedence of the operator in the stack(or the stack is empty or 
			the stack contains a ‘(‘ ), push it.
		3.2 Else, Pop all the operators from the stack which are greater than 
			or equal to in precedence than that of the scanned operator. After
			doing that Push the scanned operator to the stack. (If you 
			encounter parenthesis while popping then stop there and push the 
			scanned operator in the stack.)
	4. If the scanned character is an ‘(‘, push it to the stack.
	5. If the scanned character is an ‘)’, pop the stack and and output it 
	until a ‘(‘ is encountered, and discard both the parenthesis.
	6. Repeat steps 2-6 until infix expression is scanned.
	7. Print the output
	8. Pop and output from the stack until it is not empty.
*/
  
class InfixtoPrefix {  

    public int getPrecedence (char ch) {
    	switch (ch) { 
        	case '+': 
        	case '-': 
            	return 1; 
       
        	case '*': 
        	case '/': 
            	return 2; 
       
        	case '^': 
            	return 3; 
        } 
        return -1;
    }

    public String infixtoPostfix(String str) { 

    	String result = new String("");
    	Stack<Character> s = new Stack<>();

    	for(int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);

    		// if character is operand add it to output
    		if(Character.isLetterOrDigit(c) == true) {
    			result += c;
    		}
    		// If the scanned character is an '(', push it t
    		else if(c == '(') {
    			s.push(c);
    		}
    		//  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
    		else if(c == ')') {
    			while(s.isEmpty() == false && s.peek() != '(') {
    				result += s.pop();
    			}
    			// stack top is '('
    			if (s.isEmpty() == false && s.peek() == '(')  {
    				s.pop();
    			}
    			else {
    				return "Invalid Expression";
    			}
    		}
    		// If an operator is encountered Pop all the operators from the stack which are greater than
    		// or equal to in precedence than that of the scanned operator. 
    		//After doing that Push the scanned operator to the stack. 
    		else {
    			while(s.isEmpty() == false && getPrecedence(c) <= getPrecedence(s.peek())) {
    				result += s.pop();
    			}
    			s.push(c);
    		}
    	}

		while (s.isEmpty() == false){ 
			if(s.peek() == '(') 
				return "Invalid Expression"; 

			result += s.pop(); 
		}

    	return result;
    }  

    public String reverseString(String str) {
        String res = new String("");

        for(int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(c == '(') {
                res += ')';
            }
            else if(c == ')') {
                res += '(';
            }
            else {
                res += c;
            }
        }

        return res;
    }

    public String infixtoPrefix(String str) {
        String s1 = reverseString(str);
        System.out.println(s1);
        String s2 = infixtoPostfix(s1);

        return reverseString(s2);
    }

    public static void main(String[] args) {  
        InfixtoPrefix s = new InfixtoPrefix();  
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
     	System.out.println("Infix to postfix expression:   \t" + s.infixtoPrefix(str));
    }  
};  
