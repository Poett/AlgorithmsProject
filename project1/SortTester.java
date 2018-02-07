package project1;

import java.util.ArrayList;
import java.util.Iterator;

public class SortTester {

	public static void main(String[] args) {
		//SorterADT<WebPage> sorter = new ArraySorterADT<>();

		ArrayList<WebPage> pageArr1 = new ArrayList<>();
		ArrayList<WebPage> pageArr2 = new ArrayList<>();
		ArrayList<WebPage> pageArr3 = new ArrayList<>();
		ArrayList<WebPage> pageArr4 = new ArrayList<>();
		ArrayList<WebPage> pageArr5 = new ArrayList<>();
		//ArrayList<WebPage> pageArrCombined = new ArrayList<>();
		
		//ArraySorterADT<Object> sorter2 = new ArraySorterADT<>(); -> bound mismatch
		
		//broke adding of web pages, will fix soon :)
		
		Iterator<WebPage> wp = pageArr1.iterator();
		Iterator<WebPage> wp2 = pageArr1.iterator();
		Iterator<WebPage> wp3 = pageArr1.iterator();
		Iterator<WebPage> wp4 = pageArr1.iterator();
		Iterator<WebPage> wp5 = pageArr1.iterator();
		
		
		System.out.println("Page list 1:" +pageArr1);
		System.out.println("Page list 2:" +pageArr2);
		System.out.println("Page list 3:" +pageArr3);
		System.out.println("Page list 4:" +pageArr4);
		System.out.println("Page list 5:" +pageArr5);
		System.out.println();
		
		
	}

}
