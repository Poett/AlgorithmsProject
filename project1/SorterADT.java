package project1;
import java.util.ArrayList;

public interface SorterADT<T extends Comparable<? super T>> {
	
	public void setAscending();					//set sort to ascending mode
	public void setDescending();				//set sort to descending mode
	
	public boolean isSorted(ArrayList<T> arr);
	public int sort(ArrayList<T> arr);	//sorts list and returns inversions
	
	public String sortType();					//returns sorting method of sorter
	
	
	
}
