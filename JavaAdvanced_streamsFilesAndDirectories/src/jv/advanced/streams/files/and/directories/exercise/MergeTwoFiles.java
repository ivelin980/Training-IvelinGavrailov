package jv.advanced.streams.files.and.directories.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Write a program that reads the contents of two text files (inputOne.txt,
 * inputTwo.txt from Resources Exercises) and merges them together into a third
 * one.
 * 
 * @author Ivelin Gavrailov
 * @since 04.09.2020
 *
 */
public class MergeTwoFiles {

	public static void main(String[] args) {
		String firstFilePath = "src\\Exercises Resources\\inputOne.txt";
		String secondFilePath = "src\\Exercises Resources\\inputTwo.txt";
		String output = "output.txt";
		try(FileInputStream firstFile = new FileInputStream(firstFilePath);FileInputStream secondFile = new FileInputStream(secondFilePath);FileOutputStream out = new FileOutputStream(output)) {
			int oneByte = firstFile.read();
			while(oneByte!=-1) {
			 out.write(oneByte);
			 oneByte = firstFile.read();
			}
			out.write('\n');
			oneByte = secondFile.read();
			while(oneByte!=-1) {
				out.write(oneByte);
				oneByte = secondFile.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
