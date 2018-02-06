package project1;

public class WebPage implements Comparable<WebPage> {
	private int rank;
	private int page_number;
	
	WebPage(int index, int r)
	{
		page_number = index;
		rank = r;
	}
	
	WebPage()
	{
		this(0,0);
	}
	
	public int getPage()
	{
		return page_number;
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public int compareTo(WebPage w) {
		return page_number-w.getPage();
	}
	
	public void add(int r)
	{
		rank+= r;
	}
	
	public boolean add(WebPage wp)
	{
		if(this.compareTo(wp)==0)
		{
			rank += wp.getRank();
			return true;
		}
		else return false;
	}
	
	
	public String toString()
	{
		return "Page " + getPage()+": "+getRank();
	}

}
