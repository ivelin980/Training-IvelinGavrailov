package objects.and.classes.exercise.main;

import java.util.Scanner;

import objects.and.classes.exercise.entities.Article;


/**
 * Create an article class with the following properties: • Title – a string •
 * Content – a string • Author – a string The class should have a constructor
 * and the following methods: • Edit (new content) – change the old content with
 * the new one • ChangeAuthor (new author) – change the author • Rename (new
 * title) – change the title of the article • override ToString – print the
 * article in the following format: "{title} - {content}:{author}" Write a
 * program that reads an article in the following format "{title}, {content},
 * {author}". On the next line, you will get a number n. On the next n lines,
 * you will get one of the following commands: "Edit: {new content}";
 * "ChangeAuthor: {new author}"; "Rename: {new title}". At the end, print the
 * final article.
 * 
 * @author Ivelin Gavrailov
 * @since 01.07.2020
 *
 */
public class ArticleMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(", ");
		String title = input[0];
		String content = input[1];
		String author = input[2];
		Article article = new Article(title, content, author);
		int n = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < n; i++) {
			input = scan.nextLine().split(": ");
			switch (input[0].toLowerCase()) {
			case "edit":
				article.edit(input[1]);
				break;
			case "changeauthor":
				article.changeAuthor(input[1]);
				break;
			case "rename":
				article.rename(input[1]);
				break;
			}
		}
		scan.close();
		System.out.println(article);
	}
}
