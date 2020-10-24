package jv.advanced.streams.files.and.directories.lab;

import java.io.File;
import java.util.ArrayList;

/**
 * You are provided a folder named "Files-and-Streams". Create a program that
 * lists the names of all directories in it (including all nested directories).
 * On the last line, print the count of all folders, including the root folder.
 * Submit in Judge only the output of the program.
 * 
 * @author Ivelin Gavailov
 * @since 31.08.2020
 *
 */
public class NestedFolders {

	public static void main(String[] args) {
		String path = "src\\Files-and-Streams";
		File file = new File(path);
		ArrayList<String> finalList = new ArrayList<>();
		File[] listFolders = file.listFiles();
		getFileNames(listFolders, finalList);
		System.out.println(file.getName());
		finalList.stream().forEach(f -> System.out.println(f));
		System.out.println(finalList.size() + 1 + " folders");
	}

	private static void getFileNames(File[] listFolders, ArrayList<String> finalList) {
		for (File file : listFolders) {
			if (file.isDirectory()) {
				finalList.add(file.getName());
				if (file.listFiles() != null) {
					getFileNames(file.listFiles(), finalList);
				}
			}
		}
	}
}