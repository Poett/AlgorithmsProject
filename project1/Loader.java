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
	
	
	/*
	 * Load function for an array of integer ranks. Source is defined by its position in the text.
	 */
	public void load(String myFile) {
		scanner = new Scanner(myFile);
		int i = 0;
		int j = 0;
		String source;
		
		while(scanner.hasNext()) {
			pages.add(new WebPage());
			
			source = "Source" + i;
			
			pages.get(i).addSource(source, scanner.nextInt());
			
			
		}
		
		
		scanner.close();
	}
	

}
