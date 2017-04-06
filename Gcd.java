
package gcd;
import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;
/**
 *
 * @author Nerys Jimenez
 * The College of Saint Rose
 * Cyber-security, Spring 2017
 * Gcd.java implements the Extended Euclidean algorithm.
 * Besides finding the greatest common divisor of integers a and b,
 * it also finds integers x and y that satisfy ax + by = gcd(a, b)
 * 
 */
public class Gcd {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        int a = 0, b = 0; //gcd(a,b)input values
        int r = 0, q; //holds remainder and quotient
        int x = 0, y = 1, x1 = 1, y1 = 0; //used to find ax + by
        int temp, temp1, temp2, aCopy, bCopy; //temp is used to swap a and b if a < b
        
        try
        {
            System.out.println("Enter 2 values to find the gcd(a,b): ");
            a = keyboard.nextInt();
            b = keyboard.nextInt();
       
            //copies of a and b, used later to output results
            aCopy = a;
            bCopy = b;
        
            //gcd(a,b) = gcd(a,-b) = gcd(-a,b) = gcd(-a,-b)
            a = Math.abs(a);
            b = Math.abs(b);
        
            do
            {
                if(a < b) //swap a and b
                {
                    temp = b;
                    b = a;
                    a = temp;
                }
                if( b == 0) break; //gcd(a,0) = | a |
            
                r = a % b;
                q = a/b; 
                a = b;
                b = r;
                
           //finds an x such that ax + by = gcd(a, b)
                temp1 = x; 
                x = x1 - q * x;
                x1 = temp1;
            
            //finds a y such that ax + by = gcd(a, b)
                temp2 = y;
                y = y1 - q * y;
                y1 = temp2;
                
            }while(r > 0);
        
        System.out.println("gcd("+aCopy+", "+bCopy+") = "+a);
        System.out.println(aCopy+"("+x1+") + "+bCopy+"("+y1+") = "+a);
        
        }catch(InputMismatchException e)
        {
            System.out.println("Invalid input...");
        }
           
    }


}
