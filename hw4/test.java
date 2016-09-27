import java.io.*;
import java.util.Scanner;

/**
 * <code>public class TestExceptions</code> is an overly-complex
 * program used to demonstrate <code>Exceptions</code>.  Numerous
 * command-line options are used to cause various and sundry types
 * of exceptions.
 *
 * This program was modified to take input from the standard input stream.
 * an exception has also been created to handle any "Goofy" input from the user
 * The exception is thrown when an invalid option is entered. 
 * 
 *
 * Application originally wrote by:
 * @creator gdt
 *
 * Application modified by:
 * @editor Tanner Boysun
 *
 *
 * @created 02000.04.25
 * @updated 02016.09.25 Heavy Modifications Made
 *
 *
 * @used csc260, csc210, csc200, csc110 (fall'13)
 */

public class test {
	public static void main(String[] argv) {

		String goof_err = "Goofy user! Learn to follow instructions.";

		String ans = menu();	
		try {


			if (ans != null){
				if (ans.equals("non")){
					throw new GoofyUserException(goof_err);
				} else if (ans.substring(0,2).equals("-d")){	
					divide(Integer.parseInt((ans.substring(3))));
				} else if (ans.equals("-p")){	
					nullPointer();
				} else if (ans.equals("-r")){ 
					dummyRuntime(260);
				} else if (ans.substring(0,2).equals("-t")) {
					ThrowUp t = new ThrowUp();
					t.throwUp(ans.charAt(3));
					//new ThrowUp().throwUp(argv[1].charAt(0));
				} else {  
					System.out.println("everything is fine in the try block");

				} 
			} else {
					System.exit(0);
				}


		} catch(FloatingPointDivideByZeroException e1) {
			// getMessage() and printStackTrace() are Throwable methods
			System.out.println("getMessage(): " + e1.getMessage());
			e1.printStackTrace(System.out);
		} catch(NullPointerException e2) {
			e2.printStackTrace();  // goes to standard error
		} catch(DummyRuntimeException e3) {
			System.out.println(e3.getMessage() + "; id=" + e3.id);
		} catch (EOFException e4) {
			System.out.println("in EOFException catch block of the main()");
			e4.printStackTrace();
		} catch(Exception e) {
			System.out.print("catching everything");
			if (e instanceof IllegalArgumentException)
				System.out.print(" (IllegalArgumentException)");
			System.out.println();
			e.printStackTrace();

		} finally { System.out.println("in finally block"); }


	}

	private static void 
		divide(int denom) throws FloatingPointDivideByZeroException {
			if (denom == 0) 
				throw new FloatingPointDivideByZeroException("divide by 0");
			// floating-point divide-by-0 allowed
			System.out.println("1997.10 / 0 equals " + 1997.1 / 0d);
		}

	private static void 
		dummyRuntime(int i) /* throws DummyRuntimeException */ {
			throw new DummyRuntimeException("dummyRuntime", i);
		}

	private static void 
		nullPointer() throws Exception /* not really, but maybe in future */ {
			String s = null;
			if (s.equals("csc260")) ;
		}

	private static String menu() { 


		String menuOut = "1) force FloatingPointDivideByZeroException"
			+ "\n2) execute a floating-point divide by 0"
			+ "\n3) force a NullPointerExceptio1n"
			+ "\n4) force a DummyRuntimeException"
			+ "\n5) force a runtime exception to be thrown up"
			+ "\n6) force exception to be thrown"
			+ "\n7) force exception from finally block"
			+ "\n8) exit";

		System.out.println(menuOut);

		System.out.print("Enter a choice (1-8): ");

		Scanner scan = new Scanner(System.in);

		int result = scan.nextInt();

		switch (result) {
			case 1:
				return "-d 0";
			case 2: 
				System.out.print("Please enter an integer to test: ");
				int num = scan.nextInt();
				return ("-d " + num);
			case 3:
				return "-p";
			case 4:
				return "-r";
			case 5: 
				return "-t r";
			case 6: 
				return "-t e";
			case 7: 
				return "-t E";
			case 8:
				return null;
			default: 
				return "non";

		}






	}

}

class GoofyUserException extends Exception {
	public GoofyUserException(String m){super(m);}

}

class FloatingPointDivideByZeroException extends Exception {
	public FloatingPointDivideByZeroException(String m) { super(m); }
}

class DummyRuntimeException extends RuntimeException {
	public int id;
	public DummyRuntimeException(String m, int i) { super(m); id = i; }
}


class ThrowUp {
	public void 
		throwUp(char c) throws EOFException, Exception { 
			try { 
				if (c == 'r')
					throw new IllegalArgumentException("throw up"); 
				else
					throw new EOFException("throw up");
			} catch(EOFException e) {
				System.out.println("in ThrowUp.throwUp()");
				e.printStackTrace();
				throw e;
			} finally {
				System.out.println("in ThrowUp.throwUp().finally");
				if (c == 'E')  //cause an exception to get lost
					throw new Exception();
			}
		}
}



/*
	 Java's exception handling based on C++ (which was based on ADA)...
	 "termination" (versus resumption) exception handling model is used 
	 (error is so critical there's no way to get back to where the 
	 exeception occurred)...
	 non-RuntimeExceptions are considered "checked" exceptions -- if you
	 call a method that throws a checked exception, then you must catch
	 it or throw it (and, the method must be called from a try block)...
	 generally, you extend Exception -- not RuntimeException...
	 checked Exceptions are forced to be correct at compile-time...
	 if you override a method that throws A and B, then your override
	 method can only throw A and B (i.e. it could not also throw C)...
	 finally block used to set something other than memory back to its
	 original state (e.g. close a file)...
 */
