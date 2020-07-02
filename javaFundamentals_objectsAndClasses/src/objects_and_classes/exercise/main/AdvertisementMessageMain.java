package objects_and_classes.exercise.main;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that generate random fake advertisement message to extol some
 * product. The messages must consist of 4 parts: laudatory phrase + event +
 * author + city. Use the following predefined parts: • Phrases – {"Excellent
 * product.", "Such a great product.", "I always use that product.", "Best
 * product of its category.", "Exceptional product.", "I can’t live without this
 * product."} • Events – {"Now I feel good.", "I have succeeded with this
 * product.", "Makes miracles. I am happy of the results!", "I cannot believe
 * but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel
 * great!"} • Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva",
 * "Annie", "Eva"} • Cities – {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
 * The format of the output message is: {phrase} {event} {author} – {city}. As
 * an input, you take the number of messages to be generated. Print each random
 * message at a separate line.
 * 
 * @author Ivelin Gavrailov
 * @since 30.06.2020
 *
 */
public class AdvertisementMessageMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] phrases = new String[] {"Excellent product.", "Such a great product.", "I always use that product.",
				"Best product of its category.", "Exceptional product.", "I can’t live without this product."};
		String[] events = new String[] {"Now I feel good.", "I have succeeded with this product.",
				"Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
				"Try it yourself, I am very satisfied.", "I feel great!"};
		String[] authors = new String[] {"Diana","Petya","Stella","Elena","Katya","Iva","Annie","Eva"};
		String[] cities = new String[] {"Burgas","Sofia","Plovdiv","Varna","Ruse"};
		int input = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < input; i++) {
			Random rnd = new Random();
			String phrase = phrases[rnd.nextInt(phrases.length)];
			String event = events[rnd.nextInt(events.length)];
			String author = authors[rnd.nextInt(authors.length)];
			String city = cities[rnd.nextInt(cities.length)];
			String message = String.format("%s %s %s - %s", phrase,event,author,city);
			System.out.println(message);
		}
		scan.close();
	}
}
