
package code;

/*  Implement an interface called "iBehavior"
 *  It should have 3 methods:
 * - A method named isWild that returns true if the object implementing the interface is wild
 * - A method named run that prints out the phrase "Running with ... speed" where the ... is replaced with the moveSpeed 
 * - A method named sleep that:
 * -- takes input the number of hours to sleep as an integer
 * -- throws an exception when this input is smaller than 1 (feel free to pick an exception type)
 * -- Prints out something like "Zzz" where the number of lower case "z" is determined by the number of hours
 * -- E.g. If the method is called with 3 then it should print out "Zzzz" 
 * 
 * */

/*
 * 
 * YOUR CODE HERE
 * 
 * */


public interface iBehavior {

	
	


public void run() ;


public default void sleep(int hours) {
	String sleepStr = "Z";
	if(hours < 1) {
		throw new IndexOutOfBoundsException();
	} else {
		for (int i=0; i<hours; i++) {
			sleepStr = sleepStr.concat("z");
		}
	}
	System.out.println(sleepStr);

}


public default boolean isWild() {
	return false;
}
	
	

}
