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
		
		for(int i = 0; i<6;i++) {
			pageArr1.add(new WebPage(pageArr1.size(), i));
		}
		for(int i = 0; i<6; i++) {
			pageArr2.add(new WebPage(pageArr2.size(), 2*i));
		}
		for(int i = 0; i<6; i++) {
			pageArr3.add(new WebPage(pageArr2.size(), 3*i));
		}
		for(int i = 0; i<6; i++) {
			pageArr4.add(new WebPage(pageArr2.size(), 4*i));
		}
		for(int i = 0; i<6; i++) {
			pageArr5.add(new WebPage(pageArr2.size(), 5*i));
		}
		
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
