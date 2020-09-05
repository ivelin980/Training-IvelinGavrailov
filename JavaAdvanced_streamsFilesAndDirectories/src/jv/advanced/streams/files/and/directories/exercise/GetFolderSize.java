package jv.advanced.streams.files.and.directories.exercise;

import java.io.File;

public class GetFolderSize {

	public static void main(String[] args) {
		String folderPath = "src\\Exercises Resources";
		long length = 0;
		File file = new File(folderPath);
		File[] list = file.listFiles();
		int count = list.length;
		for (int i = 0; i < count; i++) {
			if(list[i].isFile()) {
				length += list[i].length();
			}
			else {
				length += getFolderSize(list[i]);
			}
		}
		System.out.println(length);
	}
	private static long getFolderSize(File folder) {
	    long length = 0;
	    File[] files = folder.listFiles();
	 
	    int count = files.length;
	 
	    for (int i = 0; i < count; i++) {
	        if (files[i].isFile()) {
	            length += files[i].length();
	        }
	        else {
	            length += getFolderSize(files[i]);
	        }
	    }
	    return length;
	}

}
