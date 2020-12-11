import java.util.*; 
  
// write a function to check is balanced parentheses or not in an expression

class BalancedParanthesis { 
  
    static boolean isParanthesisBalanced(String str) 
    { 
        Stack<Character> stk = new Stack<>();
  
        for (int i = 0; i < str.length(); i++) { 
            char c = str.charAt(i); 
  
            if (c == '(' || c == '[' || c == '{') { 
                stk.push(c); 
            }
            else {
                if (stk.isEmpty() == true) 
                    return false; 
                
                char x = stk.pop();
                switch (c) { 
                    case ')': 
                        if (x == '{' || x == '[') 
                            return false; 
                        break; 
  
                    case '}': 
                        if (x == '(' || x == '[') 
                            return false; 
                        break; 
  
                    case ']': 
                        if (x == '(' || x == '{') 
                            return false; 
                        break; 
                }
            }
        } 
  
        return (stk.isEmpty()); 
    } 


    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        String str = "[{}])()()()({[]}";

        if (isParanthesisBalanced(str) == true) {
            System.out.println("Balanced paranthesis");
        }
        else {
            System.out.println("Not balanced paranthesis");
        }
    } 
} 