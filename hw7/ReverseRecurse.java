import java.util.Scanner;

/*
 * This program takes input from a user using the standard input stream, converts the string
 * into a char array, and reverses the char array. It then prints both results out to the standard
 * output stream.
 *
 *@creator Tanner Boysun
 *@created 10/15/2016
 *
 *
 */


public class ReverseRecurse {
	
	public static void main(String[] argv){

		Scanner scan = new Scanner(System.in);	
		System.out.print("Please enter a String: ");
		String response = scan.nextLine();

		char[] converted = convertToChar(response);
		printArray(converted);
		char[] reversed = reverse(converted, 0, converted.length - 1);
		printArray(reversed);
		
	}

	public static char[] convertToChar(String str){

		int length = str.length();
		char[] array = new char[length];
		for (int i = 0; i < length; i++){
			array[i] = str.charAt(i);
		}
		
		return array;
	}

	public static char[] reverse(char[] array, int index1, int index2){

		if (index1 < index2){
			char first = array[index1];
			array[index1] = array[index2];
			array[index2] = first;

			reverse(array, index1 + 1, index2 - 1);
			return array;// to satisfy the compiler.
		} else {
			return array;
		}

	}

	public static void printArray(char[] array){
		String print = "";

		for (int i = 0; i < array.length; i++){
			print += (" " + array[i]);
		}

		System.out.println(print);
		
	}
	
}
				

