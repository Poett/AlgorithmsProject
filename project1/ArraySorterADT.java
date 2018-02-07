package project1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Comparable;

public class ArraySorterADT<T extends Comparable<? super T>> implements SorterADT<T> {

	//Data
	/*
	 * SortType is a constant String that holds the type of sort(merge,quick,etc) being used. Used in toString
	 * isAscending is used as a switch for the sorting order
	 */
	private static final String SortType = "Default sort";
	private boolean isAscending;

	
	//Methods
	//Constructor
	ArraySorterADT()
	{
		isAscending = true;
	}
	
	public boolean isSorted(ArrayList<T> arr) {
		Iterator<T> iter = arr.iterator();
		T last,n;

		if(iter.hasNext())				//determine if empty, otherwise return true (empty is sorted)
			last = iter.next();
		else return true;

		if(isAscending)
		{
			//Ascending
			while(iter.hasNext())
			{
				n = iter.next();

				if(n.compareTo(last) < 0)
					return false;
				else
					last = n;
			}
			
		}
			//Descending
		else
			while(iter.hasNext())
			{
				n = iter.next();

				if(n.compareTo(last) > 0)
					return false;
				else
					last = n;
			}

		return true;
	}

	public void setAscending() {
		isAscending = true;

	}

	public void setDescending() {
		isAscending = false;
	}

	public String sortType() {
		return SortType;
	}
	
	public int sort(ArrayList<T> arr) {
		
		if(isAscending)
			Collections.sort(arr);
		else 
			Collections.sort(arr, Collections.reverseOrder());
		
		return 0;
	}
	
	public String toString() {
		
		return SortType + " " + (isAscending?"ascending":"descending");
	}

}
