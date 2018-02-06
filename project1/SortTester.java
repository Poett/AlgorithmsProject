package project1;

import java.util.ArrayList;

public class SortTester {

	public static void main(String[] args) {
		SorterADT<String> sorter = new ArraySorterADT<>();
		SorterADT<Integer> sorter2 = new ArraySorterADT<>();
		SorterADT<WebPage> sorter3 = new ArraySorterADT<>();
		
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<Integer> intArr = new ArrayList<>();
		ArrayList<WebPage> pageArr = new ArrayList<>();
		
		//ArraySorterADT<Object> sorter2 = new ArraySorterADT<>(); -> bound mismatch
		intArr.add(1);
		intArr.add(1);
		intArr.add(2);
		intArr.add(2);
		intArr.add(2);
		intArr.add(3);
		
		for(int i = 0; i<6;i++) {
			pageArr.add(new WebPage(pageArr.size(), i));
		}
		
		arr.add("Z");
		arr.add("B5");
		arr.add("A1");
		arr.add("1");
		arr.add("E");
		arr.add("D");
		arr.add("G");
		arr.add("A");
		
		
		System.out.println("List of pages: "+pageArr);
		System.out.println("Expect unsorted array\t\t: "+arr);
		System.out.println(sorter +"?\t\t: " + sorter.isSorted(arr));
		sorter.sort(arr);
		System.out.println("Expect sorted array(asc)\t: "+arr);
		System.out.println(sorter +"?\t\t: " +sorter.isSorted(arr));
		sorter.setDescending();
		System.out.println(sorter +"?\t: " +sorter.isSorted(arr));
		sorter.sort(arr);
		System.out.println("Expect sorted array(desc)\t: "+arr);
		System.out.println(sorter +"?\t: " + sorter.isSorted(arr));
		
		System.out.println("Expect array of integers\t: " +intArr);
		System.out.println(sorter2 +"?\t\t: " + sorter2.isSorted(intArr));
		
		System.out.println(sorter3+"?\t\t: " + sorter3.isSorted(pageArr));
		
		
	}

}
