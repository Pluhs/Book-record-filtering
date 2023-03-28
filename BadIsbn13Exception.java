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
 *  BadIsbn13Exception class
 * @author Mohammed Alassad
 *
 */
public class BadIsbn13Exception extends Exception{
	/**
	 * default constructor
	 */
	public BadIsbn13Exception (){
		super("Bad ISBN 13 Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public BadIsbn13Exception (String s){
		super(s);
	}
}
