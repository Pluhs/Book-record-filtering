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
 * UnknownGenreException class
 * @author Mohammed Alassad
 *
 */
public class UnknownGenreException extends Exception{
	/**
	 * default constructor
	 */
	public UnknownGenreException (){
		super("Unknown Genre Exception");
	}
	/**
	 * parameterized constructor, custom exception message
	 * @param s custom exception message
	 */
	public UnknownGenreException (String s){
		super(s);
}}
