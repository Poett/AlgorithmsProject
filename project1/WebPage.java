package project1;

import java.util.LinkedHashMap;
import java.util.Map;

public class WebPage implements Comparable<WebPage> {
	private Map<String,Integer> sourceRanks;
	private Map<String,Double> sourceWeights;
	private int pageNumber;
	private static String sourceID;
	private static boolean combinedMode;
	
	WebPage()
	{
		this(0);
		
	}
	
	
	WebPage(int num)
	{
		sourceRanks = new LinkedHashMap<String,Integer>();
		sourceWeights = new LinkedHashMap<String,Double>();
		pageNumber = num;
		combinedMode=true;
		
	}
	
	boolean isEmpty()
	{
		return sourceRanks.isEmpty();
		
		
		
	}
	
	public void setWeights( Map<String,Double> weights)
	{
		if(weights.keySet().equals(sourceWeights.keySet())) {
			sourceWeights = weights;
		}
		
	}
	public void addSource(String mySource, int rank)
	{
		double numSources;
		sourceRanks.putIfAbsent(mySource, rank);
		numSources = sourceRanks.size();
		
		for(String src: sourceRanks.keySet()) {
			sourceWeights.put(src, 1.0/numSources);
		}
		
	}

	public int getValue(String source) {
		return sourceRanks.get(source);
	}
	
	public int compareTo(WebPage rhs) {
		if(combinedMode)
			return getCombinedRank()-rhs.getCombinedRank();
		else
			return this.getValue(sourceID)-rhs.getValue(sourceID);
	}
	
	public static void compareByCombinedRank(boolean comb) {
		combinedMode = comb;
	}
	
	public int comparator()
	{
		return 0;
	}
	
	public static void setComparator(String source)
	{
		sourceID = source;
	}
	
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	
	public int getCombinedRank() {		//combined rank = weights(initially 1/no_of_sources)*rank from source
										//this definition lets us change weights by altering sourceWeights
		double comb = 0;
		for(String source:sourceWeights.keySet())
		{
			comb+= sourceWeights.get(source)*sourceRanks.get(source);
			
		}
		return ((int)comb);
	}
	
	public void setRank(String source, Integer rank) {
		if(!sourceRanks.containsKey(source)) {
			addSource(source,rank);
		}
		else
			sourceRanks.put(source, rank);
	}
	
	public String toString()
	{
		return "page:\t "+pageNumber+"\t Combined rank:\t "+getCombinedRank();
	}
	
}
