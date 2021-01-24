package lab.library;

/**
 * Create a class Library from UML diagram below: <<Iterable<Book>>> Library -
 * books: Book[] + iterator(): Iterator<Book> Create a nested class LibIterator
 * from UML diagram below: <<Iterator<Book>>> LibIterator - counter: int +
 * hasNext(): boolean + next(): Book
 * 
 * @author Ivelin Gavrailov
 * @since 12.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
		Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
		Book bookThree = new Book("The Documents in the Case", 2002);

		Library library = new Library(bookOne, bookTwo, bookThree);

		for (Book book : library) {
			System.out.println(book.getTitle());
		}
	}

}
