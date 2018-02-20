package project1;

import java.util.ArrayList;

public class QuickSorter<T extends Comparable<? super T>> extends ArraySorterADT<T> {

	private static final String SortType = "Quick Sort";
	
	public int sort(ArrayList<T> arr) {
		
		//If array has only 1 or 0 elements, break and return 0;
		if(arr.size() <= 1) {
			return 0;
		}
		
		int inversions = 0;
		T pivot = arr.get(0);
		ArrayList<T> lessThan = new ArrayList<T>();
		ArrayList<T> equals = new ArrayList<T>();
		ArrayList<T> greaterThan = new ArrayList<T>();
		
		/*
		 * Sorting section:
		 * Uses three different arrays and compares each element to pivot
		 * Inversions are counted by how many places something is out of order
		 * When an element is added to lessThan: the size of equals + greaterThan shows how misplaced the element was
		 * When an element is added to equals: the size of greaterThan shows how misplaced the element was. 
		 */
		for(T element : arr) {
			
			//if element less than pivot
			if(element.compareTo(pivot) < 0) {
				lessThan.add(element); //add the element to lessThan ArrayList
				inversions = inversions + equals.size() + greaterThan.size(); //count how many inversions
			} 
			//if(element = pivot)
			else if(element.compareTo(pivot) == 0) {
				equals.add(element);
				inversions = inversions + greaterThan.size();
				
			} 
			//if(element > pivot)
			else {
				greaterThan.add(element);
			}
			
			
		}
		
		//combining
		inversions = inversions + sort(lessThan);
		inversions = inversions + sort(greaterThan);

		

		int x = 0;
		int y = 0;
		int z = 0;
		
		for(int i = 0; i < arr.size();i++) {
			if (x < lessThan.size()) {
				arr.set(i, lessThan.get(x));
				x++;
			}
			else if(y < equals.size()) {
				arr.set(i, equals.get(y));
				y++;
			}
			else {
				arr.set(i, greaterThan.get(z));
				z++;
			}
		}
		
		
		
		return inversions;
	}
	
}
