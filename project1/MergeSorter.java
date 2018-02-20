package project1;

import java.util.ArrayList;

public class MergeSorter<T extends Comparable<? super T>> extends ArraySorterADT<T> {
	
	private static final String SortType = "Merge Sort";
	
	public int sort(ArrayList<T> arr) {
		return sort(arr, 0, arr.size()-1);
		
	}
	
	public int sort(ArrayList<T> arr, int l, int r) {
		
		int inversions = 0;
		
		if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
           inversions += sort(arr, l, m);
           inversions += sort(arr , m+1, r);
 
            // Merge the sorted halves
           inversions += merge(arr, l, m, r);
           
           return inversions;
        }

		return 0;
	}
	
	private int merge(ArrayList<T> arr, int l, int m, int r) {
		
		int mark1 = m - l + 1;
		int mark2 = r - m;
		
		ArrayList<T> left = new ArrayList<T>(mark1);
		ArrayList<T> right = new ArrayList<T>(mark2);
		int inversions = 0;
		
		for(int i = 0; i < mark1; i++) {
			left.add(arr.get(l + i));
		}
		for(int j = 0; j < mark2; j++) {
			right.add(arr.get(m + 1 + j));
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		while(i < mark1 && j < mark2) {
			
			if (left.get(i).compareTo(right.get(j)) <= 0)
            {
                arr.set(k, left.get(i));
                i++;
            }
            else
            {
                arr.set(k, right.get(j));
                j++;
                inversions += mark1 - i;
            }
            k++;    
		}
		
        while (i < mark1)
        {
            arr.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < mark2)
        {
            arr.set(k, right.get(j));
            j++;
            k++;
        }
		
        return inversions;
	}
}
