package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * The printer queue is a simple way to control the order of files sent to a
 * printer device. We know that a single printer can be shared between multiple
 * devices. So to preserve the order of the files sent, we can use queue. Write
 * down a program which takes filenames until "print" command is received. Then
 * as output print the filenames in the order of printing. Some of the tasks may
 * be canceled if you receive "cancel" you have to remove the first file to be
 * printed. If there is no current file to be printed print "Printer is on
 * standby".
 * 
 * @author Ivelin Gavrailov
 * @since 30.07.2020
 *
 */
public class PrinterQueue {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayDeque<String> queue = new ArrayDeque<>();
		while (!"print".equalsIgnoreCase(input)) {
			if (!"cancel".equalsIgnoreCase(input)) {
				queue.offer(input);
			} else {
				if (!queue.isEmpty()) {
					String element = queue.poll();
					System.out.print(String.format("Canceled %s%n", element));
				} else {
					System.out.println("Printer is on standby");
				}
			}
			input = scan.nextLine();
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		scan.close();
	}
}
