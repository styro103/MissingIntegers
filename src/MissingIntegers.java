/*
 * Shaun Mbateng
 * Missing Integer
 * This program finds the minimal positive integer not occurring in a given sequence.
 * 		(ReadMe has Full Description)
 * This program has an O(N) time complexity.
 */
import java.util.Scanner;

public class MissingIntegers 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in);
		
		int [] A; //Array of Values
		int miss; //Missing Number
		int len; //Length of Array
		Counter PosInt = new Counter();
		
		//Enter and Set Array Length
		System.out.print("Enter the Length of the Array: ");
		len = cin.nextInt();
		A = new int [len];
		
		//Fill Array
		for (int i=0; i<A.length; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			A[i] = cin.nextInt();
		}
		
		cin.close(); //Close cin, No Longer Needed
		
		miss = PosInt.getMissing(A); //Get Minimal Missing Integer in Sequence
		
		//Display Missing Element
		System.out.println("");
		System.out.println("The minimal positive integer missing is "+miss+".");
	}
}
