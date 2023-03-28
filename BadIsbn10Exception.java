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
 * BadIsbn10Exception class
 * @author Mohammed Alassad
 *
 */
public class BadIsbn10Exception extends Exception{
	/**
	 * default constructor
	 */
	public BadIsbn10Exception (){
		super("Bad ISBN 10 Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public BadIsbn10Exception (String s){
		super(s);
	}
}
