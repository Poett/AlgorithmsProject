package project1;
import java.util.ArrayList;
import java.util.Scanner;


public class Loader {
	ArrayList<WebPage> pages;
	String filename;
	Scanner scanner;
	
	
	
	//Methods
	Loader(){
		pages = new ArrayList<WebPage>();
		filename = "";
		
	}
	
	

	public void loadAll(String myFiles[]) {
		for(String file : myFiles)
			load(file);
		
	}
	
	
	/*
	 * Load function for an array of integer ranks. Page is defined by its position in the text.
	 */
	public void load(String myFile) {
		
		int i = 0;

		while(scanner.hasNext()) {
			try {
				pages.get(i).addSource(myFile, scanner.nextInt());
			} catch (IndexOutOfBoundsException e) {
				pages.add(new WebPage(i));
				pages.get(i).addSource(myFile, scanner.nextInt());
			}
				
			i++;
		}
		
		
		scanner.close();
	}
	
	public void addPages(int numOfPages) {
		
		for(int i = 0; i < numOfPages; i++) {
			pages.add(new WebPage(i));
		}
	}
	

}
