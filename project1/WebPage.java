package project1;

import java.util.LinkedHashMap;
import java.util.Map;

public class WebPage implements Comparable<WebPage> {
	private Map<String,Integer> sourceRanks;
	private int pageNumber;
	
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
	}
	
	
	public void addSource(String mySource, int rank)
	{
		sourceRanks.putIfAbsent(mySource, rank);
		
	}

	
	public int compareTo(WebPage rhs) {
			return getCombinedRank()-rhs.getCombinedRank();
	}
	
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	
	public int getCombinedRank() {
		return 0;
	}
	
	public void setRank(String source, Integer rank) {
		sourceRanks.put(source, rank);
	}
	
	public String toString()
	{
		return "page: "+pageNumber+" "+sourceRanks;
	}
	
}
