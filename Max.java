import java.util.Scanner;
import java.util.Arrays;

public class Max {
  //Returns the largest of its four arguments.
  public static int max(int a, int b, int c, int d) {
    int numbers[] = {a, b, c, d};
    Arrays.sort(numbers);
    return numbers[3];
    
  }
  
  // return minimum of four arguments
  public static int min(int a, int b, int c, int d) {
    int numbers[] = {a, b, c, d};
    Arrays.sort(numbers);
    return numbers[0];
    
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // get user input
    System.out.print("Enter 4 integers: ");
    int n1 = input.nextInt();
    int n2 = input.nextInt();
    int n3 = input.nextInt();
    int n4 = input.nextInt();
    System.out.println("Largest #: " + max(n1, n2, n3, n4));
    System.out.println("Smallest #: " + min(n1, n2, n3, n4));
  }
}


/* data used to test
432 2313 24234 23547293
1 2 2 3
55 55 55 55 
600 0 324 3
*/