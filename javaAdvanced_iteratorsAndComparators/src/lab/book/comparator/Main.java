package lab.book.comparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a class BookComparator from UML diagram below: <<Comparator<Book>>>
 * BookComparator + compare(Book, Book): int BookComparator have to compare two
 * books by: 1. Book title 2. Year of publishing a book
 * 
 * @author Ivelin Gavrailov
 * @since 17.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
		Book bookThree = new Book("The Documents in the Case", 2002);
		Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

		List<Book> books = new ArrayList<>();
		books.add(bookOne);
		books.add(bookTwo);
		books.add(bookThree);

		books.sort(new BookComparator());

		for (Book book : books) {
			System.out.println(book.getTitle() + " " + book.getYear());
		}
	}
}