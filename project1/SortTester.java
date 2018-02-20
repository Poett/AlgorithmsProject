package project1;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;


public class SortTester {

	public static void main(String[] args) {
		//Sets the sources
		ArrayList<String> myfiles = new ArrayList<>();
		

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

		//Loads the files into a loader
		Loader l = new Loader();
		try {
			l.loadAll(myfiles);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		//Default weights
		Map<String,Double> sourceWeights = l.getPageArray().get(0).getWeights();
		
		
		//Sorter (can switch between new MergeSorter, QuickSorter, InserstionSorter)
		SorterADT<WebPage> sorter = new MergeSorter<>();

		//Runs sorter a handful of times to approach final weight
		for(int i = 0; i < 20; i++) {
			sortPages(sorter, l, myfiles);
		}

		System.out.println("Final Weights: ");
		System.out.println(l.getPageArray().get(0).getWeights());

		
		
		


	}


	public static int findInversions(String source, SorterADT<WebPage> sorter, Loader l) {
		//Alters WebPage comparison to compare according to source's value
		WebPage.compareByCombinedRank(false);
		WebPage.setComparator(source);
		//Copies loader's list to sort separately to find inversions without changing loader's list.
		ArrayList<WebPage> list = new ArrayList<WebPage>(l.getPageArray());
		int inversions = sorter.sort(list);
		//Reverts back WebPage's comparator
		WebPage.compareByCombinedRank(true);
		return inversions;

	}



	public static void sortPages(SorterADT<WebPage> sorter, Loader l, ArrayList<String> myFiles) {

		//Declarations, gets ready to sort an array of webpages by combined rank
		ArrayList<Double> myReliabilities = new ArrayList<>();
		
		WebPage.compareByCombinedRank(true);

		//Sorts by combined rank using a QuickSorter
		sorter.sort(l.getPageArray());

		//For each source, add an inversions count by calling findInversions method
		int inversions = 0;
		double reliability;
		double totalReliability = 0.0;

		for(String source : myFiles) {
			//Inversions
			inversions = findInversions(source, sorter, l); //adds 1 in case there are no inversions
			
			//Reliability
			reliability = 1.0/((double)inversions + 1.0);
			myReliabilities.add(reliability);
			totalReliability += reliability;
			
			
		}

		
		
		//Calculates weights based on previous inversions
		Map<String,Double> sourceWeights = new LinkedHashMap<String,Double>();
		for(int i = 0; i < myReliabilities.size(); i++) {
			double weight = (myReliabilities.get(i) * 5.0)/(totalReliability);

			sourceWeights.put(myFiles.get(i), weight);

		}

		//Applies the new weights to each page in the loader
		for(WebPage pg : l.getPageArray()) {
			pg.setWeights(sourceWeights);
		}
		
		
	}
}
