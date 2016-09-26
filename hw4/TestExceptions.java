import java.io.*;

/**
 * <code>public class TestExceptions</code> is an overly-complex
 * program used to demonstrate <code>Exceptions</code>.  Numerous
 * command-line options are used to cause various and sundry types
 * of exceptions.
 *
 * @creator gdt
 * @created 02000.04.25
 * @updated 02013.11.20  no code was changed
 * @used csc260, csc210, csc200, csc110 (fall'13)
 */

public class TestExceptions {
   public static void main(String[] argv) {
      String m =  "\n-d 0   force FloatingPointDivideByZeroException" +
                  "\n-d n   execute a floating-point divide by 0" +
                  "\n-p     force a NullPointerException" +
                  "\n-r     force a DummyRuntimeException" +
                  "\n-t r   force a runtime exception to be thrown up" +
                  "\n-t e   force exception to be thrown up" +
                  "\n-t E   force exception from finally block";

      try {
         if (argv.length == 0) 
            throw new NeedsHelpException(m);
         if (argv[0].equals("-d")) 
            divide(Integer.parseInt(argv[1]));
         else if (argv[0].equals("-p")) 
            nullPointer();
         else if (argv[0].equals("-r")) 
            dummyRuntime(260);
         else if (argv[0].equals("-t")) {
            ThrowUp t = new ThrowUp();
            t.throwUp(argv[1].charAt(0));
            //new ThrowUp().throwUp(argv[1].charAt(0));
         }
         else 
            System.out.println("everything is fine in the try block");
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
}

class FloatingPointDivideByZeroException extends Exception {
   public FloatingPointDivideByZeroException(String m) { super(m); }
}

class DummyRuntimeException extends RuntimeException {
   public int id;
   public DummyRuntimeException(String m, int i) { super(m); id = i; }
}

class NeedsHelpException extends Exception {
   public NeedsHelpException(String m) { super(m); }
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
