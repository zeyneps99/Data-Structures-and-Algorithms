package code;
import given.*;
/* Modify this file using the following info
 * - Caracal is a Cat breed  
 * - Caracal is considered a wild cat
 * - Caracal moves with 22 units of speed
 * - Caracal makes a "hiss" sound
 * - Caracal cats have longer ears (Hint: add this to its description)
 * 
 * */

public class Caracal extends Cat {
	
	
	public Caracal()
	{
		breed = "Caracal";	
		moveSpeed = 22;
		sound = "hiss";
		Util.NotImplementedYetSoft();
	}
	
	
	public Caracal(String sound)
	{
		this();
		if(sound.length()<3) {
			throw new IndexOutOfBoundsException();
		} else {
			this.sound = sound;
		}

		Util.NotImplementedYetSoft();
	 }
	
	public void description()
	{
	super.description();
	System.out.println("Caracal cats have longer ears");
		Util.NotImplementedYetSoft();
	}
	
	
	@Override
	public boolean isWild() {
		return true;
	}
	

}
