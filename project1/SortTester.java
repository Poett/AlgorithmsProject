package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class SortTester {

	public static void main(String[] args) {
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

		//		System.out.println(pageArr.get(0));
		//		System.out.println(pageArr.get(1));

		Loader l = new Loader();
		try {
			l.loadAll(myfiles);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		System.out.println(l.getPageArray().get(0).getWeights());

		SorterADT<WebPage> sorter = new QuickSorter<>();

		//Runs sorter a handful of times to approach final weight
		for(int i = 0; i < 10; i++) {
			sortPages(sorter, l, myfiles);
			System.out.println(l.getPageArray().get(0).getWeights());
		}


	}


	public static int findInversions(String source, SorterADT<WebPage> sorter, Loader l) {
		WebPage.compareByCombinedRank(false);
		WebPage.setComparator(source);
		return sorter.sort(l.getPageArray());
		WebPage.compareByCombinedRank(true);

	}



	public static void sortPages(SorterADT<WebPage> sorter, Loader l, ArrayList<String> myFiles) {

		//Declarations, gets ready to sort an array of webpages by combined rank
		ArrayList<Integer> myInversions = new ArrayList<>();
		WebPage.compareByCombinedRank(true);

		//Sorts by combined rank using a QuickSorter
		sorter.sort(l.getPageArray());

		//For each source, add an inversions count by calling findInversions method
		double totalInversions = 0;
		int inversions = 0;

		for(String source : myFiles) {
			inversions = findInversions(source, sorter, l) + 1; //adds 1 in case there are no inversions
			myInversions.add(inversions);
			totalInversions += inversions;
		}

		//Calculates weights based on previous inversions
		Map<String,Double> sourceWeights = new LinkedHashMap<String,Double>();
		for(int i = 0; i < myInversions.size(); i++) {
			double weight = myInversions.get(i)/totalInversions;

			sourceWeights.put(myFiles.get(i), weight);

		}

		//Applies the new weights to each page in the loader
		for(WebPage pg : l.getPageArray()) {
			pg.setWeights(sourceWeights);
		}
		
		
	}
}
