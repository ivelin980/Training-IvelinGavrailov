package lab.book.comparable;

import java.util.ArrayList;
import java.util.List;

/**
 * Expand Book by implementing Comparable<Book> Book have to be compared by
 * name. When name is equal, compare them by year. Expand Book from UML diagram
 * below: <<Comparable<Book>>> Book - title: String - year: int - authors:
 * List<String> - setTitle(String) - setYear(String) - setAuthors(String…) +
 * getTitle(): String + getYear(): int + getAuthors(): List<String> +
 * compareTo(Book): int You can use only one constructor. Authors can be
 * anonymous, one or many.
 * 
 * @author Ivelin Gavrailov
 * @since 13.11.2020
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

		books.stream().sorted().forEach(System.out::println);
	}
}