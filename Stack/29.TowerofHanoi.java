import java.util.*; 
  
// write a Program for Tower of Hanoi

class TowerofHanoi { 
  
    public void towerofHanoi(int n, char from, char to, char aux) { 
        if(n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        towerofHanoi(n - 1, from, aux, to);
        System.out.println("Mode disk " + n + " from " + from + " to " + to);
        towerofHanoi(n - 1, aux, to, from);
    }



    public static void main(String[] args) 
    { 
    	TowerofHanoi s = new TowerofHanoi();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of disk");
        int n = sc.nextInt();

        s.towerofHanoi(n, 'A', 'B', 'C');
    } 
} 