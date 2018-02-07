package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class SortTester {

	public static void main(String[] args) {
		SorterADT<WebPage> sorter = new ArraySorterADT<>();

		ArrayList<WebPage> pageArr = new ArrayList<>();
		ArrayList<String> myfiles = new ArrayList<>();
		//ArrayList<WebPage> pageArrCombined = new ArrayList<>();
		
		
		//broke adding of web pages, will fix soon :)
		
		String source1 = "source1.txt";
		String source2 = "source2.txt";
		String source3 = "source3.txt";
		String source4 = "source4.txt";
		String source5 = "source5.txt";
		
		myfiles.add(source1);
		myfiles.add(source2);
		myfiles.add(source3);
		myfiles.add(source4);
		myfiles.add(source5);
		
		pageArr.add(new WebPage(1));
		pageArr.add(new WebPage(2));
		
//		pageArr.get(0).addSource(source1, 5);
//		pageArr.get(0).addSource(source2, 10);
//		pageArr.get(0).addSource(source3, 7);
//		pageArr.get(0).addSource(source4, 3);
//		
//		pageArr.get(1).addSource(source1, 3);
//		pageArr.get(1).addSource(source2, 40);
//		pageArr.get(1).addSource(source3, 6);
//		pageArr.get(1).addSource(source4, 2);
		
		System.out.println(pageArr.get(0));
		System.out.println(pageArr.get(1));
		
		Loader l = new Loader();
		try {
			l.loadAll(myfiles);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		l.printAllPages();

		
		sorter.sort(l.getPageArray());
		
		l.printAllPages();
	}

}
