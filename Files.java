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
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * this is the class files where the reading and writing will be done
 * @author Mohammed Alassad
 *
 */

public class Files implements Serializable {
	/**
	 * stores the numberOfBooks to be read from
	 */
	private int numberOfBooks;
	/**
	 * the name of the file
	 */
	private String bookLine;
	/**
	 * a book object
	 */
	private Book b;
	//number of syntax errors
	private static int numberOfSyntax;
	//number of semantic errors
	private static int numberOfSemantic;
	//number of ccb entries after syntax check
	private static int ccb;
	//number of hcb entries after syntax check
	private static int hcb;
	//number of mtv entries after syntax check
	private static int mtv;
	//number of mrb entries after syntax check
	private static int mrb;
	//number of neb entries after syntax check
	private static int neb;
	//number of otr entries after syntax check
	private static int otr;
	//number of ssm entries after syntax check
	private static int ssm;
	//number of tpa entries after syntax check
	private static int tpa;
	//number of bccb entries after semantic check
	private static int bccb;
	//number of bccb entries after semantic check
	private static int bhcb;
	//number of bhcb entries after semantic check
	private static int bmtv;
	//number of bmtv entries after semantic check
	private static int bmrb;
	//number of bmrb entries after semantic check
	private static int bneb;
	//number of bneb entries after semantic check
	private static int botr;
	//number of botr entries after semantic check
	private static int bssm;
	//number of bssm entries after semantic check
	private static int btpa;
	//number of btpa entries after semantic check
	//number of toomany exceptio
	private static int toomany;
	//number of toofew exception
	private static int toofew;
	//number of missing exception
	private static int missing;
	//number of unknown exception
	private static int unknown;
	//number of bad price exception
	private static int badprice;
	//number of bad year exception
	private static int badyear;
	//number of badisbn 10 exception
	private static int bad10;
	//number of badisbn 13 exception
	private static int bad13;
	/**
	 * method to validate syntax using book constructor to validate
	 * @param pw this is the outputstream to each file partitioned file
	 * @param sc this is the inputstream to read each of the lines in each input file
	 */
	private void syntax(PrintWriter[] pw, Scanner sc) {
		String s = null;
		//reading until theres no more lines
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			//using book constructor that takes a string to validate the line syntactically
			try {
				b = new Book(s);
				String genre = b.getbGenre();
				//using the genre, will be able to partition the book records
				if (genre.equals("CCB")) {
					pw[0].println(s);
					ccb++;
				}

				else if (genre.equals("HCB")) {
					pw[1].println(s);
					hcb++;
				} else if (genre.equals("MTV")) {
					pw[2].println(s);
					mtv++;
				}

				else if (genre.equals("MRB")) {
					pw[3].println(s);
					mrb++;
				} else if (genre.equals("NEB")) {
					pw[4].println(s);
					neb++;
				}

				else if (genre.equals("OTR")) {
					pw[5].println(s);
					otr++;
				} else if (genre.equals("SSM")) {
					pw[6].println(s);
					ssm++;
				} else if (genre.equals("TPA")) {
					pw[7].println(s);
					tpa++;
				}

			} catch (TooManyFieldsException e) {
				pw[8].println("Syntax error in file: " + bookLine);
				pw[8].println("=============");
				pw[8].println(e.getMessage());
				pw[8].println(s);
				numberOfSyntax++;
				toomany++;
			} catch (TooFewFieldsException e) {
				pw[8].println("Syntax error in file: " + bookLine);
				pw[8].println("=============");
				pw[8].println(e.getMessage());
				pw[8].println(s);
				numberOfSyntax++;
				toofew++;
			} catch (MissingFieldException e) {
				pw[8].println("Syntax error in file: " + bookLine);
				pw[8].println("=============");
				pw[8].println(e.getMessage());
				pw[8].println(s);
				numberOfSyntax++;
				missing++;
			} catch (UnknownGenreException e) {
				pw[8].println("Syntax error in file: " + bookLine);
				pw[8].println("=============");
				pw[8].println(e.getMessage());
				pw[8].println(s);
				numberOfSyntax++;
				unknown++;
			}

		}
		//closing the inputstream
		sc.close();
	}
	/**
	 * this method validates the syntax, and partition book records based on genre onto new files
	 */
	public void do_part1() {
		//making file objects for each output file
		File cc = new File("src//Cartoons_Comics.csv");
		File hc = new File("src//Hobbies_Collectibles.csv");
		File mtv = new File("src//Movies_TV_Books.csv");
		File mrb = new File("src//Music_Radio_Books.csv");
		File otr = new File("src//Old_Time_Radio_Books.csv");
		File neb = new File("src//Nostalgia_Eclectic_Books.csv");
		File ssm = new File("src//Sports_Sports_Memorabilia.csv");
		File tpa = new File("src//Trains_Planes_Automobiles.csv");
		File sef = new File("src//syntax_error_file.txt");
		File[] arrayOutput = { cc, hc, mtv, mrb, otr, neb, ssm, tpa, sef };
		PrintWriter[] p = new PrintWriter[9];
		// opening outputstreams for each file
		try {
			for (int i = 0; i < arrayOutput.length; i++) {
				p[i] = new PrintWriter(new FileOutputStream(arrayOutput[i]));
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("File could not be created or be read");
		}
		Scanner sc = null;
		// opening input file name to retrieve the input files to be read
		try {
			sc = new Scanner(new FileInputStream("src\\part1_input_file_names.txt\\"));
		} catch (FileNotFoundException e) {
			System.out.println("No such file is found or the file can't be read.");
		}
		// storing number of books
		numberOfBooks = sc.nextInt();
		sc.nextLine();
		// using the same scr scanner through a loop to open a stream using the name of the book name read using sc
		Scanner scr = null;
		for (int i = 0; i < numberOfBooks; i++) {
			bookLine = sc.nextLine();
			// opening streams to read from the 16 book files
			try {
				scr = new Scanner(new FileInputStream("src\\" + bookLine));
			} catch (FileNotFoundException e) {
				System.out.println("No such file is found or the file can't be read.");
			}
			//calling the method syntax to validate syntactically
			syntax(p, scr);

		}
		//closing the inputstream that reads the name of the book files
		sc.close();
		//closing each of the outputstreams
		for (int i = 0; i < p.length; i++) {
			p[i].close();
		}
	}
	/**
	 * this method validates the semantics,read the genre files each into an array of Book objects, then serializes each .
	 */
	public void do_part2() {
		//file objects for input and output files
		File cc = new File("src//Cartoons_Comics.csv");
		File hc = new File("src//Hobbies_Collectibles.csv");
		File mtv = new File("src//Movies_TV_Books.csv");
		File mrb = new File("src//Music_Radio_Books.csv");
		File otr = new File("src//Old_Time_Radio_Books.csv");
		File neb = new File("src//Nostalgia_Eclectic_Books.csv");
		File ssm = new File("src//Sports_Sports_Memorabilia.csv");
		File tpa = new File("src//Trains_Planes_Automobiles.csv");
		File sef = new File("src//semantic_error_file.txt");
		File bcc = new File("src//Cartoons_Comics.csv.ser");
		File bhc = new File("src//Hobbies_Collectibles.csv.ser");
		File bmtv = new File("src//Movies_TV_Books.csv.ser");
		File bmrb = new File("src//Music_Radio_Books.csv.ser");
		File botr = new File("src//Old_Time_Radio_Books.csv.ser");
		File bneb = new File("src//Nostalgia_Eclectic_Books.csv.ser");
		File bssm = new File("src//Sports_Sports_Memorabilia.csv.ser");
		File btpa = new File("src//Trains_Planes_Automobiles.csv.ser");
		File[] arrayInput = { cc, hc, mtv, mrb, otr, neb, ssm, tpa };
		File[] arrayOutput = { bcc, bhc, bmtv, bmrb, botr, bneb, bssm, btpa};
		ObjectOutputStream[] oos = new ObjectOutputStream[8];
		Scanner[] sc = new Scanner[8];
		PrintWriter err = null;
		// opening files for reading and writing to
		for (int i = 0; i < arrayOutput.length; i++) {
			try {
				oos[i] = new ObjectOutputStream(new FileOutputStream(arrayOutput[i]));
				sc[i] = new Scanner(new FileInputStream(arrayInput[i]));
				err = new PrintWriter(new FileOutputStream(sef));
			}
			catch (FileNotFoundException e) {
				System.out.println("File could not be created or be read");
			}
			catch (IOException e) {
				System.out.println("File could not be created or be read");
			}

		}
		//this method checks the number of records to be written in each file, the number of semantic errors
		checkSemantic(sc,err, arrayInput, oos);
	}
	/**
	 * this method checks for the number of records to be written in each binary file
	 * @param sc all inputstreams
	 * @param err the error file outputstream
	 * @param f Files names array
	 * @param oos the object output streams
	 */
	private void checkSemantic(Scanner[] sc, PrintWriter err, File[] f, ObjectOutputStream[] oos) {
		String s = null;
		Book[] ccbArray = new Book[ccb];
		Book[] hcbArray = new Book[hcb];
		Book[] mtvArray = new Book[mtv];
		Book[] mrbArray = new Book[mrb];
		Book[] nebArray = new Book[neb];
		Book[] otrArray = new Book[otr];
		Book[] ssmArray = new Book[ssm];
		Book[] tpaArray = new Book[tpa];
		Book[][] arrays = {ccbArray, hcbArray, mtvArray, mrbArray,otrArray ,nebArray , ssmArray,tpaArray};
		for (int i = 0; i < sc.length; i++) {
			while (sc[i].hasNextLine()) {
				s = sc[i].nextLine();
				try {
					b = new Book(s, true);
					if (i == 0) {
					ccbArray[bccb] = b;
					bccb++;
					}					
					else if (i == 1) {
						hcbArray[bhcb] = b;
						bhcb++;
					}
					else if (i == 2)
					{
						mtvArray[bmtv] = b;
						bmtv++;
					}	
					else if (i == 3) {
						mrbArray[bmrb] = b;
						bmrb++;
					}
					else if (i == 4) {
						nebArray[bneb] = b;
						bneb++;
					}
						
					else if (i == 5) {
						otrArray[botr] = b;
						botr++;
					}
						
					else if (i == 6) {			
						ssmArray[bssm] = b;
						bssm++;
					}
						
					else if (i == 7) {
						tpaArray[btpa] = b;
						btpa++;
					}
						
				} catch (BadIsbn10Exception e) {
					err.println("Semantic error in file: " + f[i].getName());
					err.println("=============");
					err.println(e.getMessage());
					err.println(s);
					numberOfSemantic++;
					bad10++;
				} catch (BadIsbn13Exception e) {
					err.println("Semantic error in file: " + f[i].getName());
					err.println("=============");
					err.println(e.getMessage());
					err.println(s);
					numberOfSemantic++;
					bad13++;
				} catch (BadYearException e) {
					err.println("Semantic error in file: " + f[i].getName());
					err.println("=============");
					err.println(e.getMessage());
					err.println(s);
					numberOfSemantic++;
					badyear++;
				} catch (BadPriceException e) {
					err.println("Semantic error in file: " + f[i].getName());
					err.println("=============");
					err.println(e.getMessage());
					err.println(s);
					numberOfSemantic++;
					badprice++;
				}
			}
			sc[i].close();
			//closing the object output streams
			try {
			oos[i].writeObject(arrays[i]);
			oos[i].close();
		}
		catch (IOException e){
			System.out.println("could not write to file");
		}
		}
		//closing the error output stream when done
		err.close();
		
	}
	/**
	 * reading the binary files, deserialize the array objects in each file, and then provide an interacive program to allow the user to navigate the arrays.
	 */
	public void do_part3() {
		File bcc = new File("src//Cartoons_Comics.csv.ser");
		File bhc = new File("src//Hobbies_Collectibles.csv.ser");
		File bmtv = new File("src//Movies_TV_Books.csv.ser");
		File bmrb = new File("src//Music_Radio_Books.csv.ser");
		File botr = new File("src//Old_Time_Radio_Books.csv.ser");
		File bneb = new File("src//Nostalgia_Eclectic_Books.csv.ser");
		File bssm = new File("src//Sports_Sports_Memorabilia.csv.ser");
		File btpa = new File("src//Trains_Planes_Automobiles.csv.ser");
		File[] arrayInput = { bcc, bhc, bmtv, bmrb, botr, bneb, bssm, btpa};
		Book[][] arrays = new Book [8][];
		int lengths[] = {this.bccb, this.bhcb,this.bmtv,this.bmrb,this.botr ,this.bneb , this.bssm,this.btpa};
		ObjectInputStream[] ois = new ObjectInputStream[8];
		//opening inputstreams
		for (int i = 0; i < arrayInput.length; i++) {
			try {
				ois[i] = new ObjectInputStream(new FileInputStream(arrayInput[i]));
				try {
					while (true) {
						arrays[i] = (Book[]) ois[i].readObject();
					}
					
					
				} catch (ClassNotFoundException e) {
					System.out.println("could not read object");
				} catch (EOFException e) {
					System.out.println("finished reading");
				}
				ois[i].close();
			} catch (FileNotFoundException e) {
				System.out.println("could not open file");
			} catch (IOException e) {
				System.out.println("problem reading file");
			}
		}
		//reducing the length of the array
		Book[] temp = new Book[0];
		for(int i = 0; i< arrays.length;i++) {
			temp = new Book[lengths[i]];
			for (int j = 0; j< lengths[i];j++) {
				temp[j]= arrays[i][j];
			}
			arrays[i]=temp;
		}
		String[] arrayRecords = { "("+bccb + " records)", "("+bhcb + " records)", "("+this.bmtv + " records)", "("+this.bmrb + " records)",
				"("+this.bneb + " records)", "("+this.botr + " records)", "("+this.bssm + " records)", "("+this.btpa + " records)" };
		int i = 1;
		Scanner keyIn = new Scanner(System.in);
		System.out.println("\n\n\nHello! My name is Mohammed Alassad, welcome to my program!");
		while (true) {
			String selection = "";
			System.out.println("---------------------------");
			System.out.println("         Main Menu");
			System.out.println("---------------------------");
			System.out.println(
					"v  View the select file: " + arrayInput[i - 1].getName() + " "+ arrayRecords[i - 1]);
			System.out.println("s  Select a file to view");
			System.out.println("x  Exit");
			System.out.println("---------------------------");
			System.out.print("\nEnter Your Choice: ");
			while (true) {
				selection = keyIn.next().toUpperCase();
				keyIn.nextLine();
				if (!selection.equals("V") && !selection.equals("S") && !selection.equals("X")) {
					System.out.print("\nPlease enter one of the choices: ");
				} else
					break;
			}
			if (selection.equals("V")) {
				System.out.println("viewing: " + arrayInput[i - 1].getName() + " " +arrayRecords[i - 1]);
				int indexctr;

				// position in the array
				int actualindex = 0;
				int n = -1;
				int lengthMax = arrays[i - 1].length;
				while (true) {
					try {
						System.out.print("\nPlease enter the number of book records to display: ");
						n = keyIn.nextInt();
						indexctr = 0;
						if (n > 0) {
							if (n - 1 + actualindex > lengthMax) {
								for (int j = actualindex; j < lengthMax; j++) {
									System.out.println(arrays[i - 1][j]);
								}
								actualindex = lengthMax - 1;
								System.out.println("EOF has been reached");
							} else {
								for (int j = actualindex; j <= actualindex + (n - 1); j++) {
									System.out.println(arrays[i - 1][j]);
									indexctr++;
								}
								actualindex += indexctr - 1;
							}

						} else if (n < 0) {
							n *= -1;
							if (actualindex == 0) {
								System.out.println("BOF has been reached");
							} else if (actualindex - (n - 1) < 0) {
								for (int j = actualindex; j >= 0; j--) {
									System.out.println(arrays[i - 1][j]);
								}
								System.out.println("BOF has been reached");
								actualindex = 0;
							} else {
								for (int j = actualindex; j >= actualindex - (n - 1); j--) {
									System.out.println(arrays[i - 1][j]);
									indexctr--;
								}
							}
							actualindex += indexctr;
						} else if (n == 0) {
							break;
						}
					} catch (InputMismatchException e) {
						keyIn.nextLine();
					}
				}

			} else if (selection.equals("S")) {
				while (true) {
					System.out.println("---------------------------");
					System.out.println("       File Sub-Menu");
					System.out.println("---------------------------");
					System.out.println("1 Cartoons_Comics_Books.csv.ser       "+arrayRecords[0]);
					System.out.println("2 Hobbies_Collectibles_Books.csv.ser  "+arrayRecords[1]);
					System.out.println("3 Movies_TV.csv.ser                   "+arrayRecords[2]);
					System.out.println("4 Music_Radio_Books.csv.ser           "+arrayRecords[3]);
					System.out.println("5 Nostalgia_Eclectic_Books.csv.ser    "+arrayRecords[4]);
					System.out.println("6 Old_Time_Radio.csv.ser              "+arrayRecords[5]);
					System.out.println("7 Sports_Sports_Memorabilia.csv.ser   "+arrayRecords[6]);
					System.out.println("8 Trains_Planes_Automobiles.csv.ser   "+arrayRecords[7]);
					System.out.println("9 Exit");
					System.out.println("---------------------------");
					try {
						System.out.print("\nPlease enter an integer from 1 to 9: ");
						i = keyIn.nextInt();
						if (i >= 1 && i < 9) {
							break;
						}
						if (i == 9) {
							System.out.println("Exiting program");
							keyIn.close();
							System.exit(0);
						}

					} catch (InputMismatchException e) {
						keyIn.nextLine();
					}
				}

			} else if (selection.equals("X")) {
				System.out.println("Exiting program");
				keyIn.close();
				System.exit(0);
			}

		}
	}
	/**
	 * main method
	 * @param args main method
	 */
	//this program reads book records to sort them into categories, it also checks for semantic and syntax errors and put those records
	//in their respective error files. once sorted, it will read each sorted record in their respective array and store each array in a binary file
	//It will then display a navigation menu for the user to read from the those arrays
	public static void main(String[] args) {
		Files f = new Files();
		f.do_part1();
		f.do_part2();
		System.out.println("Number of syntax errors: " + numberOfSyntax);
		System.out.println("TooManyFieldsException: " + toomany);
		System.out.println("TooFewFieldsException: " + toofew);
		System.out.println("MissingFieldException: " + missing);
		System.out.println("UnknownGenreException: " + unknown);
		System.out.println("CCB entries: " + ccb);
		System.out.println("HCB entries: " + hcb);
		System.out.println("MTV entries: " + mtv);
		System.out.println("MRB entries: " + mrb);
		System.out.println("NEB entries: " + neb);
		System.out.println("OTR entries: " + otr);
		System.out.println("SSM entries: " + ssm);
		System.out.println("TPA entries: " + tpa);
		System.out.println("========================");
		System.out.println("Number of semantic errors: " + numberOfSemantic);
		System.out.println("BadIsbn10Exception: " + bad10);
		System.out.println("BadIsbn13Exception: " + bad13);
		System.out.println("BadYearException: " + badyear);
		System.out.println("BadPriceException: " + badprice);
		System.out.println("CCB entries: " + bccb);
		System.out.println("HCB entries: " + bhcb);
		System.out.println("MTV entries: " + bmtv);
		System.out.println("MRB entries: " + bmrb);
		System.out.println("NEB entries: " + bneb);
		System.out.println("OTR entries: " + botr);
		System.out.println("SSM entries: " + bssm);
		System.out.println("TPA entries: " + btpa);
		f.do_part3();
	}
}
