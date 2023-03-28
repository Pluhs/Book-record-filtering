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
 * TooFewFieldsException class
 * @author Mohammed Alassad
 *
 */
public class TooFewFieldsException extends Exception{
	/**
	 * default constructor
	 */
	public TooFewFieldsException (){
		super("Too Few Fields Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public TooFewFieldsException (String s){
		super(s);
	}
}
