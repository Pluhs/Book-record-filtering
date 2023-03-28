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
 * TooManyFieldsException class
 * @author Mohammed Alassad
 *
 */
public class TooManyFieldsException extends Exception{
	/**
	 * default constructor
	 */
	public TooManyFieldsException (){
		super("Too Many Fields Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */ 
	public TooManyFieldsException (String s){
		super(s);
	}
}
