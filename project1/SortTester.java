package project1;

import java.util.ArrayList;

public class SortTester {

	public static void main(String[] args) {
		ArraySorterADT<String> sorter = new ArraySorterADT<>();
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("Z");
		arr.add("B5");
		arr.add("A1");
		arr.add("1");
		arr.add("E");
		arr.add("D");
		arr.add("G");
		arr.add("A");
		
		System.out.println(arr);
		System.out.println(sorter.isSorted(arr));
		sorter.sort(arr);
		System.out.println(arr);
		System.out.println(sorter.isSorted(arr));
		sorter.setDescending();
		System.out.println(sorter.isSorted(arr));
		sorter.sort(arr);
		System.out.println(arr);
		System.out.println(sorter.isSorted(arr));
		
		
		
	}

}
