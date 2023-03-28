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
 * MissingFieldException class
 * @author Mohammed Alassad
 *
 */
public class MissingFieldException extends Exception{
	/**
	 * default constructor
	 */
	public MissingFieldException (){
		super("Missing Field Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public MissingFieldException(String s) {
		super(s);
	}
}
