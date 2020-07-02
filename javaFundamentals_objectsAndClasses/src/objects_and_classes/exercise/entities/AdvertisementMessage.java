package objects_and_classes.exercise.entities;

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
	@Override
	public String toString() {
		return String.format("%s %s %s - %s",this.phrase,this.event,this.author,this.city);
	}
	
}
