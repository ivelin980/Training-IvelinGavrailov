package objects.and.classes.exercise.entities;

public class AdvertisementMessage {
	private String phrase;
	private String event;
	private String author;
	private String city;

	public AdvertisementMessage(String phrase, String event, String author, String city) {
		this.phrase = phrase;
		this.event = event;
		this.author = author;
		this.city = city;
	}

	public String getPhrase() {
		return phrase;
	}

	public String getEvent() {
		return event;
	}

	public String getAuthor() {
		return author;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s - %s", phrase, event, author, city);
	}
}
