import java.io.Serializable;
/**
 * Mohammed Alassad, 40252007
 * COMP249
 * Assignment 3
 * 3/27/2023
 */
//-----------------------------------------------------
//Assignment 3
//Question: all 3 parts
//Written by: Mohammed Alassad, 40252007
//-----------------------------------------------------
/**
 * this class is the Book class and it is there to hold the different fields of each record line
 * @author Mohammed Alassad
 *
 */
public class Book implements Serializable {
	/**
	 * title
	 */
	private String bName;
	/**
	 * name of authors
	 */
	private String bAuthor;
	/**
	 * price
	 */
	private String bPrice;
	/**
	 * isbn
	 */
	private String bISBN;
	/**
	 * genre
	 */
	private String bGenre;
	/**
	 *year
	 */
	private String bYear;

	/**
	 * default constructor
	 */
	public Book() {

	}

	/**
	 * this is a book parameterized constructor that has the checkFields(s) method
	 * as a definition
	 * 
	 * @param s the book record line input
	 * @throws TooManyFieldsException when too many fields
	 * @throws TooFewFieldsException when too few fields
	 * @throws MissingFieldException when missing field
	 * @throws UnknownGenreException when unknown genre
	 */
	public Book(String s)
			throws TooManyFieldsException, TooFewFieldsException, MissingFieldException, UnknownGenreException {
		checkFields(s);

	}

	/**
	 * this is a book parameterized constructor that has the semantics(s) method as
	 * a definition
	 * 
	 * @param s the book record line input
	 * @param t to diffentiate the other parameterized constructor
	 * @throws BadIsbn10Exception when bad 10 digit isbn
	 * @throws BadIsbn13Exception when bad 13 digit isbn
	 * @throws BadPriceException when invalid price
	 * @throws BadYearException when invalid year
	 */
	public Book(String s, boolean t)
			throws BadIsbn10Exception, BadIsbn13Exception, BadPriceException, BadYearException {
		semantics(s);
	}

	/**
	 * getter
	 * 
	 * @return bName title
	 */
	public String getbName() {
		return bName;
	}

	/**
	 * setter
	 * 
	 * @param bName title
	 */
	public void setbName(String bName) {
		this.bName = bName;
	}

	/**
	 * getter
	 * 
	 * @return bAuthor name
	 */
	public String getbAuthor() {
		return bAuthor;
	}

	/**
	 * setter
	 * 
	 * @param bAuthor name
	 */
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	/**
	 * getter
	 * 
	 * @return bPrice 
	 */
	public String getbPrice() {
		return bPrice;
	}

	/**
	 * setter
	 * 
	 * @param bPrice price
	 */
	public void setbPrice(String bPrice) {
		this.bPrice = bPrice;
	}

	/**
	 * setter
	 * 
	 * @return bISBN 
	 */
	public String getbISBN() {
		return bISBN;
	}

	/**
	 * setter
	 * 
	 * @param bISBN isbn
	 */
	public void setbISBN(String bISBN) {
		this.bISBN = bISBN;
	}

	/**
	 * getter
	 * 
	 * @return bGenre
	 */
	public String getbGenre() {
		return bGenre;
	}

	/**
	 * setter
	 * 
	 * @param bGenre genre
	 */
	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}

	/**
	 * getter
	 * 
	 * @return bYear
	 */
	public String getbYear() {
		return bYear;
	}

	/**
	 * setter
	 * 
	 * @param bYear year
	 */
	public void setbYear(String bYear) {
		this.bYear = bYear;
	}

	/**
	 * this method splits the record into the different fields, throws an exception
	 * when there's an issue
	 * 
	 * @param s
	 * @throws TooManyFieldsException when too many fields
	 * @throws TooFewFieldsException when too few fields
	 * @throws MissingFieldException when missing field
	 * @throws UnknownGenreException when unknown genre
	 */
	private void checkFields(String s)
			throws TooManyFieldsException, TooFewFieldsException, MissingFieldException, UnknownGenreException {
		int first = s.indexOf('"');
		int last = s.lastIndexOf('"');
		String[] sArray;
		// in the case where there is a "" in the title name
		if (first == 0) {
			bName = s.substring(first + 1, last);
			s = s.substring(last + 2);
			sArray = s.split(",");
			for (int i = 0; i < sArray.length; i++) {
				switch (i) {
				case 0:
					bAuthor = sArray[i];
					break;
				case 1:
					bPrice = sArray[i];
					break;
				case 2:
					bISBN = sArray[i];
					break;
				case 3:
					bGenre = sArray[i];
					break;
				case 4:
					bYear = sArray[i];
					break;
				}
				if (sArray.length > 5) {
					throw new TooManyFieldsException();
				}
				if (sArray.length < 5) {
					throw new TooFewFieldsException();
				}

			}
			for (int i = 0; i < sArray.length; i++) {
				if (sArray[i].isEmpty()) {
					switch (i) {
					case 0:
						throw new MissingFieldException("Error: Missing Author");
					case 1:
						throw new MissingFieldException("Error: Missing Price");
					case 2:
						throw new MissingFieldException("Error: Missing ISBN");
					case 3:
						throw new MissingFieldException("Error: Missing Genre");
					case 4:
						throw new MissingFieldException("Error: Missing Year");
					}
				}
			}
			if (!bGenre.equals("CCB") && !bGenre.equals("HCB") && !bGenre.equals("MTV") && !bGenre.equals("MRB")
					&& !bGenre.equals("NEB") && !bGenre.equals("OTR") && !bGenre.equals("SSM") && !bGenre.equals("TPA"))
				throw new UnknownGenreException();
			// in the case the title name doesn't have ""
		} else {
			
			sArray = s.split(",");
			if (sArray.length > 6) {
				throw new TooManyFieldsException();
			}
			if (sArray.length < 6) {
				throw new TooFewFieldsException();
			}
			for (int i = 0; i < sArray.length; i++) {
				switch (i) {
				case 0:
					bName = sArray[i];
					break;
				case 1:
					bAuthor = sArray[i];
					break;
				case 2:

					bPrice = sArray[i];
					break;
				case 3:
					bISBN = sArray[i];
					break;
				case 4:
					bGenre = sArray[i];
					break;
				case 5:
					bYear = sArray[i];
					break;

				}
			}
			for (int i = 0; i < sArray.length; i++) {
				if (sArray[i].isEmpty()) {
					switch (i) {
					case 0:
						throw new MissingFieldException("Missing book name");
					case 1:
						throw new MissingFieldException("Missing Author");
					case 2:
						throw new MissingFieldException("Missing Price");
					case 3:
						throw new MissingFieldException("Missing ISBN");
					case 4:
						throw new MissingFieldException("Missing Genre");
					case 5:
						System.out.println("here");
						throw new MissingFieldException("Missing Year");
					}
				}
			}
			if (!bGenre.equals("CCB") && !bGenre.equals("HCB") && !bGenre.equals("MTV") && !bGenre.equals("MRB")
					&& !bGenre.equals("NEB") && !bGenre.equals("OTR") && !bGenre.equals("SSM") && !bGenre.equals("TPA"))
				throw new UnknownGenreException();

		}
	}

	/**
	 * this method is used for the second parameterized constructor, which won't
	 * throw the different exceptions it is used after it was syntactically checked,
	 * meaning it will be used for the part 2
	 * 
	 * @param s book line
	 */
	private void checkFieldsv2(String s) {
		int first = s.indexOf('"');
		int last = s.lastIndexOf('"');
		if (first == 0) {
			bName = s.substring(first + 1, last);
			s = s.substring(last + 2);
			String[] sArray = s.split(",");
			for (int i = 0; i < sArray.length; i++) {
				switch (i) {
				case 0:
					bAuthor = sArray[i];
					break;
				case 1:
					bPrice = sArray[i];
					break;
				case 2:
					bISBN = sArray[i];
					break;
				case 3:
					bGenre = sArray[i];
					break;
				case 4:
					bYear = sArray[i];
					break;
				}
			}
		}

		else {
			String[] sArray = s.split(",");
			for (int i = 0; i < sArray.length; i++) {
				switch (i) {
				case 0:
					bName = sArray[i];
					break;
				case 1:
					bAuthor = sArray[i];
					break;
				case 2:

					bPrice = sArray[i];
					break;
				case 3:
					bISBN = sArray[i];
					break;
				case 4:
					bGenre = sArray[i];
					break;
				case 5:
					bYear = sArray[i];
					break;

				}
			}
		}

	}

	/**
	 * this methods checks for semantic errors and throws different exception based
	 * on the error
	 * 
	 * @param s book line
	 * @throws BadIsbn10Exception bad isbn 10 
	 * @throws BadIsbn13Exception bad isbn 13
	 * @throws BadPriceException invalid price
	 * @throws BadYearException invalid year
	 */
	private void semantics(String s)
			throws BadIsbn10Exception, BadIsbn13Exception, BadPriceException, BadYearException {
		// uses the checkFieldsv2 method to split the record line into fields
		checkFieldsv2(s);
		if (Double.parseDouble(bPrice) < 0)
			throw new BadPriceException();
		if (Integer.parseInt(bYear) < 1995 || Integer.parseInt(bYear) > 2010)
			throw new BadYearException();
		if (bISBN.length() == 10) {
			int[] Array = new int[10];
			int sum = 0;
			for (int i = 0; i < Array.length; i++) {
				if (bISBN.charAt(i) == 'X')
					Array[i] = 10;
				else
					Array[i] = Character.digit(bISBN.charAt(i),10);
				if (Array[i] == -1)
					throw new BadIsbn10Exception();
				sum += (10 - i) * Array[i];
			}
			if (sum % 11 != 0)
				throw new BadIsbn10Exception();
		}
		if (bISBN.length() == 13) {
			String test = "9780786409242";
			int[] Array = new int[13];
			int sum = 0;
			for (int i = 0; i < Array.length; i++) {
				if (bISBN.charAt(i) == 'X')
					Array[i] = 10;
				Array[i] = Character.digit(bISBN.charAt(i),10);
				if (Array[i] == -1)
					throw new BadIsbn13Exception();
				sum += (i % 2 == 0 ? 1 : 3) * Array[i];
			}
			if (sum % 10 != 0)
				throw new BadIsbn13Exception();
		}
	}
	/**
	 * equals method
	 */
	public boolean equals(Object x) {
		if (x==null || getClass() != x.getClass())
			return false;
		else {
			Book y = (Book) x;
			return y.bAuthor.equals(bAuthor) && y.bGenre.equals(bGenre) && y.bISBN.equals(bISBN) && y.bName.equals(bName) && y.bPrice.equals(bPrice) && y.bYear.equals(bYear);
		}
	}
	/**
	 * toString method
	 */
	public String toString() {
		return "Record: Book name: [" + bName + "]  Authors: [" + bAuthor + "] Book price [" + bPrice + "] ISBN ["
				+ bISBN + "] Genre [" + bGenre + "] Year [" + bYear + "]";
	}
}