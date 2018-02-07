package project1;
import java.util.HashMap;

public class WebPage implements Comparable<WebPage> {
	private HashMap<String,Integer> sourceRanks;
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
		pageNumber = num;
	}
	
	
	public boolean addSource(String mySource, int rank)
	{
		boolean sourceExists = sourceRanks.containsKey(mySource);
		if(!sourceExists)
			sourceRanks.put(mySource, rank);
		
		return !sourceExists;
		
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
	
	public boolean setRank(String source, int rank) {
		if(sourceRanks.containsKey(source)) {
			sourceRanks.put(source,rank);
			return true;
		}
		else return false;
	}
	
}
