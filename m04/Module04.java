package m04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Brady
 *
 */
public class Module04 {
	public static void main(String[] args) {
		demoCollection(-25,35);
	}

	/**
	 * Finds all multiples of 6 in the range sent. Adds all one-digit numbers and removes duplicates
	 * @param low
	 * @param heigh
	 */
	public static void demoCollection(int low, int heigh) {
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = low; i <= heigh; i++) {
			if(i%6 == 0) {
				numbers.add(i);
			}
		}
		
		System.out.println(numbers);
		
		for(int i = 0; i < numbers.size(); i++) {
			numbers.set(i, numbers.get(i)/2);
		}
		
		addSingleDigits(numbers);
		
		sortAndPrint(numbers);
		
		List<Integer> temp = new ArrayList<>();
		for(int i = 0; i < numbers.size() - 1; i++) {
			if(numbers.get(i) == numbers.get(i + 1)) {
				temp.add(numbers.get(i));
			}
		}
		numbers.removeAll(temp);
		numbers.addAll(temp);
		sortAndPrint(numbers);
	}

	private static void sortAndPrint(List<Integer> numbers) {
		Collections.sort(numbers);
		Collections.reverse(numbers);
		System.out.println(numbers);
	}

	private static void addSingleDigits(List<Integer> numbers) {
		for(int i = -9; i <= 9; i++) {
			numbers.add(i);
		}
	}
}