package jv.advanced.streams.files.and.directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ivelin Gavrailov
 * @since 01.09.2020
 *
 */
public class SumLines {

	public static void main(String[] args) {
		String path = "src\\Exercises Resources\\input.txt";
		try(BufferedReader in = new BufferedReader(new FileReader(path))) {
			String line = in.readLine();
			while(line!=null) {
				int sum = 0;
				for (int i = 0; i < line.length(); i++) {
					sum+=line.charAt(i);
				}
				System.out.println(sum);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
