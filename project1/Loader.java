package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Loader {
	private ArrayList<WebPage> pages;
	private Scanner scanner;
	
	
	
	//Methods
	Loader(){
		pages = new ArrayList<WebPage>();
		
	}
	
	

	public void loadAll(ArrayList<String> myFiles) throws FileNotFoundException {
		for(String f : myFiles)
		{
			load(f);
		}
		
	}
	
	
	/*
	 * Load function for an array of integer ranks. Page is defined by its position in the text.
	 */
	public void load(String filename) throws FileNotFoundException {
		
		load(new File(filename));
		
		
	}
	
	public void load(File myFile) throws FileNotFoundException {
		
		scanner = new Scanner(myFile);		//set Scanner to parse myFile for ints
		int i = 0;
		int j = 0;
		while(scanner.hasNext()) {
			j = Integer.parseInt(scanner.nextLine());
			try {
				
				pages.get(i).setRank(myFile.getName(), j);
				
			} catch (IndexOutOfBoundsException e) {
					
				pages.add(new WebPage(i));
				pages.get(i).setRank(myFile.getName(),j);
			
			}
				
			i++;
		}
		
		
		scanner.close();
	}
	public ArrayList<WebPage> getPageArray()
	{
		return pages;
		
	}
	
	public void printPage(int p) {
		System.out.println(pages.get(p));
	}
	
	public void printAllPages() {
		for(WebPage wp:pages)
			System.out.println(wp);
	}
	
	public void addPages(int numOfPages) {
		
		for(int i = 0; i < numOfPages; i++) {
			pages.add(new WebPage(i));
		}
	}
	

}
