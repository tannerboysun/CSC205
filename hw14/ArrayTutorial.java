public class ArrayTutorial{
	public static void main(String[] argv){
/* =========================
 * How To Use Arrays in Java
 * =========================
 *
 * Welcome to this document, which should hopefully explain what an array structure
 * is and how you can properly implement them into your programs.
 *
 *=================
 *What is an Array?
 *=================

 * An Array in java is a basic data structure that can store a pre-defined list of
 * data in sections called indices. When you create an array, just like normal variables
 * you need to also declare the type of data you store inside the array. After it's 
 * instantiated, you cannot grow or shrink the array size easily, so keep this in mind
 * when instantiating arrays. 
 *
 * Well, that's great but is there a way to visualize an array?
 * --> Yes. The best way to visualize the array data structure is to picture a long
 *  rectangle, divided into however many sections you define. Each section is called 
 *  an index, and each index stores whatever you place into them. 
 *
 *  -------------------------------------
 *  |   |   |   |   |   |   |   |   |   |
 *  |   |   |   |   |   |   |   |   |   |
 *  -------------------------------------
 *
 *  Above is an array instantiated with a size of 9. This means we can store 9 things in
 *  this array. When you instantiate an array, it reserves a bit of memory according to
 *  the array data type you instantiate and the size of the array. 
 *
 * Let's now talk about Array Indexing.
 *  -------------------------------------
 *  |   |   |   |   |   |   |   |   |   |
 *  |   |   |   |   |   |   |   |   |   |
 *  -------------------------------------
 *    0   1   2   3   4   5   6   7   8 
 *    
 *    Indexes are just references to the "squares" or "slots" in the array. If you put 
 *    something in index 2, you can then reference index 2 later in your program.
 *
 *    Interesting, this array has a size of 9, but only has a maximum index of 8. This is 
 *    because Array Indexing starts at 0. This is an important concept because improper
 *    indexing may lead to an ArrayOutOfBounds Exception which may be caused from an index
 *    that isn't defined in this array.
 *
 *    =======================
 *    Instantiating The Array
 *    ======================= 
 *    
 *    So let's dive deep into creating an array. Before creating an array you should have
 *    an idea of a couple of factors:
 *
 *    1.) What type of data you will be working with
 *    2.) How many indexes you may need. 
 *
 *    So lets dive into instantiation: 
 *    Just a quick note, at any point you need to see any form of output, just compile
 *    this application and run it. All code blocks will be outside the comment blocks.
 *
 *    The syntax for instantiation is similar to normal variable instantiation. In fact, 
 *    an array variable is just a bunch of pointers. 
 *
 *    We need a few basic components, Data type, variable name, and instantiation statement.
 *
 *    Let's start with Data Type, for this example we will use the primative data type int.
 *
 *    Normally if we want to declare a variable, we would say:
 *    int age = 2;
 *    
 *    Array declarations are a bit different. 
 *    For comparison, here is a valid array declaration:
 */

       int[] grades; 
       System.out.println("grades array declared");
 /*
 *     So we see here that we have an extra element to this declaration.
 *     There are [] brackets! The best way to explain this is to think of array whenever you
 *     see the square brackets. In english you should read int array grades. This tells the 
 *     compiler that not only are you declaring an integer, but that you will have an array
 *     of integers!
 *
 *     So now we have an empty array, how do we use it?
 *     Good Question!
 *
 *     We can't quite yet, we need to instantiate it with something called the new operator.
 *     This isn't the only way to instantiate an array, but it is the most common. We have
 *     already answered the question of "What type of data we are storing", now we need to
 *     answer "How Much?"
 *
 *     We can do that by setting our declared variable = to a new int array. Let's see what
 *     this process looks like.
 */
       grades = new int[5];
       System.out.println("grades array initialized");
 /*
 *     Interesting, so we can read that statement as our int array variable equals a new int
 *     array, but what does the 5 mean? Well, it turns out you need to pass in the size of
 *     the array when initializing it! 5 is the size of our array (it'll have index's 0-4).
 *	
 *     Well, that is just a primative data type, what about Objects?
 *     --> Good Question! Same process!
 *
 *     This time instead of declaring our array variable, we are going to declare and 
 *     instantiate on the same line! We will use the array with the size of 9 as shown 
 *     in the explanation of an array example.
 *
 */
       String[] names = new String[9];
       System.out.println("names array initialized");
 /*
 *
 *     Looks identicle! Now we know how to instantiate an array with both primative data
 *     types and objects!
 *
 *     so picture the above code generated the following in memory:
 *
 *     -------------------------------------
 *     |   |   |   |   |   |   |   |   |   |
 *     |   |   |   |   |   |   |   |   |   |
 *     -------------------------------------
 *       0   1   2   3   4   5   6   7   8 
 *
 *     Granted it doesn't actually look like this, but this is a good visual representation.
 *
 *     So how do we add stuff to the array?
 *
 *     Well using the index numbers we can add in our data.
 *     Most of the times functions may mathmatically determine which index to drop your
 *     data into, or you may do it by going from 0 - 8 in our example. 
 *
 *     To add data to our array, we need to use the array index we want to add data into and
 *     use our array variable.
 *
 *     by using bracket notation we can specify the index in the square brackets, and 
 *     set that index "equal" to the value in which we want to store in that index.
 *     For Example:
 *
 */
      names[0] = "Tanner Boysun";
      System.out.println("Set 0 index in names to Tanner Boysun");
/*    
 *    We can see in this example we want to make the value "Tanner Boysun" which is a
 *    string value populate the zeroth index. This is how we can add data into our array, 
 *    and using the same process we can retrieve data.
 *
 */
      System.out.println("names[0] = " + names[0]);
/*    
 *    We see here we can reference the data in the index by using the array variable in 
 *    bracket notation. 
 *
 *    Our array should look like the following (theoretically)
 *
 *     -------------------------------------
 *     |   |   |   |   |   |   |   |   |   |
 *     | V |   |   |   |   |   |   |   |   |
 *     --V----------------------------------
 *       0   1   2   3   4   5   6   7   8 
 *       V
 *       V
 *"Tanner Boysun"
 *
 *     We can see here that in the index '0' that it is pointing to a String object
 *     with the data "Tanner Boysun", so every time we reference index zero we should
 *     get "Tanner Boysun" unless we change the value inside the index.
 *
 *     Using the same concept you can populate all the index spots. 
 *
 *     ===============
 *     Array Traversal
 *     ===============
 *
 *     So what if we want to traverse an array? Or print it out to the console?
 *     We can easily do this with a property of arrays called length.
 *
 *     The idea here is to create a for loop that iterates the same amount of times as
 *     the length of your array. Because we know that an array will always have index numbers
 *     0 - array.length, we can build a for loop to print out each index using this model.
 *
 *     Take a look at this code snippit:
 */
       for (int i = 0; i < names.length; i++){
	      System.out.println("i = " + i + " and names[i] = " + names[i]); 
       }
       System.out.println("Complete");
/*     
 *     We see here that this also printed Tanner Boysun to the console!
 *     In fact, if we run this program again, and add more to our array, it should
 *     print out the entirety of the array! Note, the prints may contain blank
 *     spaces because nothing has been initialized in that array index.
 *
 *     To demonstrate this i'm going to quickly populate the array:
 */
       names[1] = "Joe";
       names[2] = "Rick";
       names[3] = "Sally";
       names[4] = "Joanne";
       names[5] = "Jessie";
       System.out.println("End of Name Population");
/*
 *     So let's run our loop again and take a look at the output.
 */
       for (int i = 0; i < names.length; i++){
	     System.out.println("i = " + i + " and names[i] = " + names[i]);
       }
/* 
 *     Now we see a more populated array!
 *
 *     Next, using the same concept we can print the array backwards!
 *     By simply modifying the for loop to say that we start at the length,
 *     then we go down to zero, we can print out every index starting at the very last index.
 *     I'm going to finish populating the array, then i'll demonstrate this idea.
 */
       
       names[6] = "Bob";
       names[7] = "John";
       names[8] = "Sue";

       for (int i = names.length; i <=0; i--){
	       System.out.println("i = " + i + " and names[i] = " + names[i]);
       }
/*
 *     So we see here in addition from starting at the length of the array, we have to
 *     decrement i instead of increment it. 
 *
 *     ===================
 *     Initialization List
 *     ===================
 *
 *     Let's say you are a tutor wanting to keep track of your students, and you only have
 *     4 students to manage, it would kind of be annoying to initizalize the data by index
 *     i.e. names[6] =, names[7] =;
 *     but it would also be pointless to initialize it within a loop.
 *
 *     Well, we can initialize an array where we declare and initialize all of the data on 
 *     the same line.
 *
 *     This is called a Initialization list.
 *     Here is an example:
 */
       String[] students = {"Tanner", "Bob", "Julia", "Frank"};
       System.out.println("Initialized using an Initialization list.");
/*     
 *     The array will take shape around the list you set it equal to.
 *
 *     ========
 *     Swapping
 *     ========
 *
 *     The idea of swapping data indexes in an array is a unique but rather simple one.
 *     Please understand that because this tutorial is working in the main method, 
 *     we won't create a method that does it, But for ease of use it is highly reccomended
 *     you create a function/method that takes 2 parameters and swaps them. I will talk about
 *     the concept of swapping. 
 *
 *     So we cannot just do students[0] = students[2] and students[2] = students[0],
 *     let's take a look why.
 *     
 *     Here is what our current array looks like (pseudocode)
 *     students = "Tanner", "Bob", "Julia", "Frank"
 *
 *     students[0] = students[2];
 *     here is what our current array looks like after the previous line:
 *
 *     students = "Julia", "Bob", "Julia", "Frank"
 *     
 *     Now we see doing students[2] = students[0] won't mean anything!
 *
 *     So we need to store one of them in a variable
 */
       System.out.println("Swapping Elements");
       String prev = students[0];
       students[0] = students[2];
       students[2] = prev;
       
       for (int i = 0; i < students.length; i++){
	    System.out.println("students[i] = " + students[i]);
       }
 /* 
 *     We can see that our elements have been sucessfully swapped! Once again I advise
 *     created a method, but because of the limitations of this document I have 
 *     omitted that.
 *
 *     ======
 *     Search
 *     ======
 *
 *     This section requires a function to really have an effective search, so I
 *     will write that out in this section, but won't be able to see it working.
 *     Either way, to effectively learn the content it is reccomended you try 
 *     these concepts on your own, so I, the Author, challenge you to write this
 *     function on your own!
 *
 *     Search is a combination of comparison, and iteration.
 *     The idea behind searching is to literally iterate through the array, 
 *     and for each iteration do a comparison. Once when the check condition
 *     matches the current value from the index, you want to return the index value
 *
 *     So i'm going to write the function in the commend block, I emplore you to 
 *     try writing this on your own in a seperate document!
 *
 *     Public int search(String case){
 *         for (int i = 0; i < students.length; i++){
 *		if (students[i] == case)
 *		     return i;
 *         }
 *
 *         return null;
 *     } 
 *
 *     We see this loop will iterate through each index in the students array, and search
 *     for the case. If it finds a match (you might actually want to use compareTo), it'll 
 *     return the index for future use. If it doesn't find it, the method will return null.
 *     It's up to the user to handle null returns.
 *
 *     int find = search("Tanner");
 *     students[find] will bring you to the exact index where it found "Tanner"!
 *
 *
 *     I hope this information was useful, there is infinitely many different things you
 *     can do with arrays, these were just some of the most important functions of the array
 *     data structure. 
 *
 *     Now go out and play with arrays!
 *
 *     
 *
 *
 *
 *
 */
	}
}
