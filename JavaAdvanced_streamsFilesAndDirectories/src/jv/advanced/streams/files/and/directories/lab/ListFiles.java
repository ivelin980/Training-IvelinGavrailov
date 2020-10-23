package jv.advanced.streams.files.and.directories.lab;

import java.io.File;

/**
 * You are provided a folder named "Files-and-Streams". Create a program that
 * lists the names and file sizes (in bytes) of all files that are placed
 * directly in it (do not include files in nested folders). Submit in Judge only
 * the output of the program.
 * 
 * @author Ivelin Gavrailov
 * @since 31.08.2020
 *
 */
public class ListFiles {

	public static void main(String[] args) {
		String path = "src\\Files-and-Streams";
		File file = new File(path);
		File[] array = file.listFiles();
		for (File f : array) {
			if (f.isFile()) {
				System.out.println(String.format("%s: [%d]", f.getName(), f.length()));
			}
		}
	}
}
