package project1;

import java.util.ArrayList;

public class InsertionSorter<T extends Comparable<? super T>> extends ArraySorterADT<T> {

	
	public int sort(ArrayList<T> arr) {
		int inversions = 0;
		T temp;
        for (int i = 1; i < arr.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr.get(j).compareTo(arr.get(j-1)) < 0){
                    temp = arr.get(j);
                    arr.set(j, arr.get(j-1));
                    arr.set(j-1, temp);
                    inversions++;
                }
            }
        }
        return inversions;
	}
}
