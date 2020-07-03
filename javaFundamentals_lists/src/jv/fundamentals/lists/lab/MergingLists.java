package jv.fundamentals.lists.lab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * You are going to receive two lists with numbers. Create a result list which
 * contains the numbers from both of the lists. The first element should be from
 * the first list, the second from the second list and so on. If the length of
 * the two lists are not equal, just add the remaining elements at the end of
 * the list.
 * 
 * @author Ivelin Gavrailov
 * @since 21.06.2020
 *
 */
public class MergingLists {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] firstArr = scan.nextLine().split(" ");
		String[] secondArr = scan.nextLine().split(" ");
		ArrayList<String> firstList = new ArrayList<>();
		ArrayList<String> secondList = new ArrayList<>();
		for (String number : firstArr) {
			firstList.add(number);
		}
		for (String number : secondArr) {
			secondList.add(number);
		}
		for (String element : mergeLists(firstList, secondList)) {
			System.out.print(element + " ");
		}
		scan.close();
	}

	private static ArrayList<String> mergeLists(ArrayList<String> firstList, ArrayList<String> secondList) {
		ArrayList<String> resultList = new ArrayList<>();
		for (int i = 0; i < Math.min(firstList.size(), secondList.size()); i++) {
			resultList.add(firstList.get(i));
			resultList.add(secondList.get(i));
		}
		for (int i = Math.min(firstList.size(), secondList.size()); i < Math.max(firstList.size(),
				secondList.size()); i++) {
			if (firstList.size() > secondList.size()) {
				resultList.add(firstList.get(i));
			} else {
				resultList.add(secondList.get(i));
			}
		}
		return resultList;
	}
}
