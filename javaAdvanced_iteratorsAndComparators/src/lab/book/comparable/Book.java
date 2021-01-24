package lab.book.comparable;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
	private String title;
	private int year;
	private List<String> authors;

	public Book(String title, int year, String... authors) {
		this.setTitle(title);
		this.setYear(year);
		this.setAuthors(authors);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getAuthors() {
		return authors;
	}

	private void setAuthors(String... authors) {
		this.authors = Arrays.asList(authors);
	}

	@Override
	public String toString() {
		return "Book " + title + ", year " + year + ", authors " + authors;
	}

	@Override
	public int compareTo(Book other) {
		if(this.title.compareTo(other.title) == 0) {
		return Integer.compare(this.year, other.year);
		}
		return this.title.compareTo(other.title);
	}
}
