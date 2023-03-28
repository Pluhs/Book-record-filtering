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
 * BadYearException class
 * @author Mohammed Alassad
 *
 */
public class BadYearException extends Exception{
	/**
	 * default constructor
	 */
	public BadYearException (){
		super("Bad year Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public BadYearException (String s){
		super(s);
	}

}
