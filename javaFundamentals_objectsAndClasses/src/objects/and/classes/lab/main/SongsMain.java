package objects.and.classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects.and.classes.lab.entities.Song;

/**
 * Define a class Song, which holds the following information about songs: Type
 * List, Name and Time. On the first line you will receive the number of songs -
 * N. On the next N-lines you will be receiving data in the following format:
 * "{typeList}_{name}_{time}". On the last line you will receive Type List /
 * "all". Print only the Names of the songs which are from that Type List / All
 * songs.
 * 
 * @author Ivelin Gavrailov
 * @since 30.06.2020
 *
 */
public class SongsMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numSongs = Integer.parseInt(scan.nextLine());
		ArrayList<Song> songs = new ArrayList<>();
		for (int i = 0; i < numSongs; i++) {
			String[] data = scan.nextLine().split("_");
			String type = data[0];
			String name = data[1];
			String time = data[2];

			Song song = new Song();

			song.setTypeList(type);
			song.setName(name);
			song.setTime(time);

			songs.add(song);
		}
		String chosenTypeList = scan.nextLine();
		if (!chosenTypeList.equals("all")) {
			for (Song song : songs) {
				if (chosenTypeList.equals(song.getTypeList())) {
					System.out.println(song);
				}
			}
			scan.close();
			return;
		}
		for (Song song : songs) {
			System.out.println(song);
		}
		scan.close();
	}
}
