package objects_and_classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects_and_classes.exercise.entities.Article2;

/**
 * Change the program, so you can store a list of articles. You will not need
 * the methods any more (except the ToString method). On the first line, you
 * will get a number n. On the next n lines, you will get some articles in the
 * same format as the previous task ("{title}, {content}, {author}"). Finally,
 * you will get one of the three inputs: "title", "content", "author". You need
 * to order the articles alphabetically based on the command and print them
 * sorted by the given criteria.
 * 
 * @author Ivelin Gavrailov
 * @since 01.07.2020
 *
 */
public class Articles2Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<Article2> articles = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] input = scan.nextLine().split(", ");
			String title = input[0];
			String content = input[1];
			String author = input[2];
			Article2 article = new Article2(title,content,author);
			articles.add(article);
		}
		String criteria = scan.nextLine().toLowerCase();
		switch (criteria) {
		case "title":
			articles.stream().sorted((t1,t2) -> t1.getTitle().compareTo(t2.getTitle())).forEach(a -> System.out.println(a));
			break;
		case "content":
			articles.stream().sorted((t1,t2) -> t1.getContent().compareTo(t2.getContent())).forEach(a -> System.out.println(a));	
			break;
		case "author":
			articles.stream().sorted((t1,t2) -> t1.getAuthor().compareTo(t2.getAuthor())).forEach(a -> System.out.println(a));
			break;
		}
		scan.close();
	}
}
