/**
 * Mohammed Alassad, 40252007
 * COMP249
 * Assignment 3
 * 3/27/2023
 */
// -----------------------------------------------------
// Assignment 3
// Question: all 3 parts
// Written by: Mohammed Alassad, 40252007
// -----------------------------------------------------
/**
 * BadPriceException class
 * @author Mohammed Alassad
 *
 */
public class BadPriceException extends Exception{
	
	/**
	 * default constructor
	 */
	public BadPriceException (){
		super("Bad price Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public BadPriceException (String s){
		super(s);
	}
}
