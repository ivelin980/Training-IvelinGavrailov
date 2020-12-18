package lab.book;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Book implements Iterable<Book>{
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
	public Iterator<Book> iterator() {
		return null;
	}
}
