package project1;

import java.util.LinkedHashMap;
import java.util.Map;

public class WebPage implements Comparable<WebPage> {
	private Map<String,Integer> sourceRanks;
	private int pageNumber;
	private static String sourceID;
	private static boolean combinedMode;
	
	WebPage()
	{
		this(0);
	}
	
	
	boolean isEmpty()
	{
		return sourceRanks.isEmpty();
	}
	
	
	WebPage(int num)
	{
		sourceRanks = new LinkedHashMap<String,Integer>();
		pageNumber = num;
		combinedMode=true;
	}
	
	
	public void addSource(String mySource, int rank)
	{
		sourceRanks.putIfAbsent(mySource, rank);
		
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
	
	
	public int getCombinedRank() {
		
		int comb = 0;
		for(int val:sourceRanks.values())
			comb+=val;
		return comb;
	}
	
	public void setRank(String source, Integer rank) {
		sourceRanks.put(source, rank);
	}
	
	public String toString()
	{
		return "page:\t "+pageNumber+"\t Combined rank:\t "+getCombinedRank();
	}
	
}
