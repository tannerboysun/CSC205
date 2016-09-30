

import java.util.Scanner;

public class TestBitOperators implements BitOperators {

	public static void main(String[] argv){

		/* Configurations */

		// Dependent on Bit Processing. 
		// Sets intervals
		final byte MIN_RANGE = -128;
		final byte MAX_RANGE = 127;
		final byte SHIFT_MIN = 0;
		final byte SHIFT_MAX = 7;
		final byte EXIT_NUM = -1;
		boolean willRun = true;
		boolean first = true;

		String printMsg = "Enter a and b numbers in the interval [" + MIN_RANGE + "," + MAX_RANGE + "] (" + EXIT_NUM + " " + EXIT_NUM + " to exit): ";
		String shiftInterval = "[" + SHIFT_MIN + "," + SHIFT_MAX + "]";

		System.out.print(printMsg);
		Scanner scan = new Scanner(System.in);

		/* Start of user Prompts */

		String response = scan.nextLine();
		String[] strSplit = response.split(" ");
		byte[] parsedResponse = new byte[strSplit.length];

		for (int i = 0; i < strSplit.length; i++){

			try{
				parsedResponse[i] = Byte.parseByte(strSplit[i]);
			}
			catch(NumberFormatException e1) {
				System.out.println("ERROR: Data not within range");
			}

		}


		byte a, b, l, r; // input variables

		try {

			while(!(parsedResponse[0] == EXIT_NUM) && !(parsedResponse[1] == EXIT_NUM)){
				willRun = true;

				if(!(first)){

					scan.nextLine(); // Clearing the Scanner Buffer
					System.out.print("\n"+printMsg);
					response = scan.nextLine();
					strSplit = response.split(" ");
					parsedResponse = new byte[strSplit.length];

					for (int i = 0; i < strSplit.length; i++){
						parsedResponse[i] = Byte.parseByte(strSplit[i]);
					}

				} else {

					first = false;

				}


				a = parsedResponse[0];
				b = parsedResponse[1];
				if (willRun && (!(b == EXIT_NUM) && !(a == EXIT_NUM))) {
					System.out.print("Enter #left-shift bits in the interval " + shiftInterval + ": ");
					l = scan.nextByte(); 

					System.out.print("Enter #right-shift bits in the interval " + shiftInterval + ": ");
					r = scan.nextByte();

					if ( ( (l > SHIFT_MAX) || (l < SHIFT_MIN) ) || ( ( r > SHIFT_MAX) || (r < SHIFT_MIN) ) ) {

						System.out.println("\nERROR: Shift data not within rage");
						willRun = false;

					} else {

						new TestBitOperators().and(a,b).or(a,b).xor(a,b).shift(a,l,r).comp(a);


					}
				}

			}

		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("ERROR: Wrong amount of Arguments entered");
			willRun = false;
		} catch (NumberFormatException e2) {
			System.out.println("ERROR: Data not within range");
			willRun = false;
		}// catch (InputMismatchException e3) {
		//	System.out.println("ERROR: Invalid input, please enter bytes");
		//	willRun = false;
		//}


	}

	public BitOperators and(byte a, byte b){
		System.out.println( a & b);
		return this;
	}

	public BitOperators or(byte a, byte b){
		System.out.println("Or works");
		return this;
	}

	public BitOperators xor(byte a, byte b){
		System.out.println("xor works");
		return this;
	}

	public BitOperators shift(byte n, byte l, byte r){
		System.out.println("shift works");
		return this;
	}

	public BitOperators comp(byte n){
		System.out.println("com works");
		return this;
	}


}


interface BitOperators {

	BitOperators and(byte a, byte b);
	BitOperators or(byte a, byte b);
	BitOperators xor(byte a, byte b);
	BitOperators shift(byte n, byte l, byte r);
	BitOperators comp(byte n);
}
