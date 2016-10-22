import java.util.Scanner;

/*
 * This program gets a number and a base from the user and prints 
 * the base-10 value of the number in the entered base. Recursively
 *
 * @modifier Tanner Boysun
 * @modified 2016.10.22
 * Original credit given to gdt, I simply modified the program to use recursion instead of a loop
 *
 * @creator gdt
 * @created 02015.10.12
 * @caveat no sanity checking on inputs
 * @note program written because of 10/10 Day (and 10/11 day)
 * @edu This program could be used to introduce user defined 
 *      static methods.
 * @examples
 * inputs 512 6.... 512 base-6 = 188 (base-10)
 * inputs 314 8.... 314 base-8 = 204 (base-10)
 * inputs 1010 2... 1010 base-2 = 10 (base-10)
 */
public class BaseN {

	public static final int BASEN_ERRNO = -1;

	public static void main(String[] argv) {

		Scanner input = new Scanner(System.in);
		System.out.print("enter number followed by base (e.g. 237 8): ");
		int number = input.nextInt();
		int base = input.nextInt();

		int answer = basen(number, base, 1);
		if (BASEN_ERRNO == answer)
			System.out.println("***error: " + number + " is not a valid base-" 
					+ base + "number");
		else
			System.out.println(number + " base-" + base + " = " + answer);
	}

	public static int basen(int number, int base, int placeValue) {
		int answer = 0;
		int digit = number % 10;
		if (digit >= base) 
			return BASEN_ERRNO;

		answer += digit * placeValue;	
		
		if (number/10 > 0){
				answer += basen(number/10, base, placeValue*base);
		}	
		return answer;
	}

}
