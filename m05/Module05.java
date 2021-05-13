package m05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Brady
 *
 */
public class Module05 {

	public static void main(String[] args) {
		List<String> reciver = new ArrayList<>();
		StringBuilder reverser = new StringBuilder();
		List<String> reciver2 = new ArrayList<>();
		
		readIn(reciver, reverser, reciver2);
		
		writeHorizontal(reciver, reciver2);
		
		mirrorVertical(reciver);
	}
	/**
	 * Reads in the file and starts needed changes for mirror printing.
	 * @param reciver
	 * @param reverser
	 * @param reciver2
	 */
	private static void readIn(List<String> reciver, StringBuilder reverser, List<String> reciver2) {
		try(Scanner reader = new Scanner(new File("src/m05/Pattern.txt"));
				Scanner reader2 = new Scanner(new File("src/m05/Pattern.txt"))){
			while(reader.hasNextLine()) {
				reciver.add(reader.nextLine());		
			}
			while(reader2.hasNextLine()) {
				reverser.append(reader2.nextLine());
				reverser.reverse();
				reciver2.add(reverser.toString());
				reverser.delete(0, reverser.capacity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Prints a mirror over the vertical axis based on the last space in the 
	 * lines for the file.
	 * @param reciver
	 */
	private static void mirrorVertical(List<String> reciver) {
		try(PrintWriter writer = new PrintWriter("src/m05/Pattern2.txt")){
			for(int i = 0; i < reciver.size(); i++) {
				writer.println(reciver.get(i));
			}
			for(int i = reciver.size() - 1; i >= 0; i--) {
				writer.println(reciver.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Prints a mirror over the horizontal axis of the file, starting with the last line 
	 * and going to the first.
	 * @param reciver
	 * @param reciver2
	 */
	private static void writeHorizontal(List<String> reciver, List<String> reciver2) {
		try(PrintWriter writer = new PrintWriter("src/m05/Pattern1.txt")){
			for(int i = 0; i < reciver.size(); i++) {
				writer.println(reciver.get(i) + reciver2.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
