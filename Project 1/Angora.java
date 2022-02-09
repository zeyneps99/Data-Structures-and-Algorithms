package code;
import given.*;

/* Modify this file using the following info
 * - Angora is a Cat breed  
 * - Angora is not considered a wild cat
 * - Angora moves with 15 units of speed
 * - Angora makes a "meow" sound
 * - Angora cats may have differently colored eyes  (Hint: add this to its description)
 * 
 * */

public class Angora extends Cat {
	

	
	public Angora()
	{
		breed = "Angora";	
		moveSpeed = 15;
		
		Util.NotImplementedYetSoft();
	}
	
	
	public Angora(String sound)
	{
		super();
		sound = "meow";
		Util.NotImplementedYetSoft();
	 }
	
	
	public void description()
	{
	super.description();
	System.out.println("Angora cats may have differently colored eyes");
		Util.NotImplementedYetSoft();
	}
	
}

