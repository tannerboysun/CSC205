/*
* This java application prints out all the palindromic non-prime numbers
* only if their factors are all palindrome numbers.
*
* @creator Tanner Boysun
* @generated 2016.9.5
*/

public class Factors {
	public static void main(String[] args){
		
		int maxNumber = 1000000;

		for (int i = 10; i < maxNumber; i++) {
		
			if (isPalindrome(i) && isNotPrime(i)) {
				System.out.println(i + " " + getPalindromicFactors(i));
			}

		}

	}

	static boolean isPalindrome(int n){

		String forward = Integer.toString(n);
		String reverse = "";
		for (int i = forward.length(); i > 0; i--) {
			reverse+= forward.charAt((i - 1));
		}

		boolean result = (Integer.parseInt(forward) == Integer.parseInt(reverse)) ? true : false; 
		return result;
	}

	static boolean isNotPrime(int num){
		boolean prime = false;
		boolean palindromeBreak = false;

		for (int check = 2; check < num; check++){

			if (((num % check) == 0)){

				prime = true;

				if( !isPalindrome(check)) {
					palindromeBreak = true;
				}
			       
			}	 

		}
		boolean result = (!palindromeBreak && prime) ? true : false;
	       return result;
		
	}
	
	static String getPalindromicFactors(int num){

		String result = "(";

		for (int check = 1; check < num; check++){
			if (num % check == 0 && isPalindrome(check)){
				if (check == 1) {
					result += Integer.toString(check);
				} else {
					result += ("," + Integer.toString(check));
				}
			}
		}
		result += ")";
		return result;

	}

}


