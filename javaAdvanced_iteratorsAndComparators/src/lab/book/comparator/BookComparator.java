package lab.book.comparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book bookOne, Book bookTwo) {
		if (bookOne.getTitle().compareTo(bookTwo.getTitle()) == 0) {
			return Integer.compare(bookOne.getYear(), bookTwo.getYear());
		}
		return bookOne.getTitle().compareTo(bookTwo.getTitle());
	}

}
