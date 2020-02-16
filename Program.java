
import java.util.Scanner;
import java.io.*;

public class Program {

	
	final String PATH = "src/mm.txt";
	
	public static void main(String[] args) {
		Program prog = new Program();
		

          prog.getDirectory();    // we can run each one at a time/
		//prog.appendText();
		//prog.charCount();
		
	}
	
	
	public  void getDirectory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the absolute path of the directory.");
		String dir = scanner.nextLine();
		
		File file = new File(dir);
		
		
		if(file.exists() && file.isDirectory()) {
			for(String fileName : file.list()) {
				System.out.println(fileName);
			}
		}
		else {
			System.out.println("There is something wrong with that path");
		}		
		scanner.close();		
	}
	
	
	public void appendText() {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("What text do you want to append to mm.txt?");
		String text = scanner.nextLine();
		
		File file = new File(PATH);
		try {		
			if(file.exists()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(text);
				writer.close();				
			}
			else {
				System.out.println(file.getAbsolutePath());
				System.out.println("That file doesnt exist");
			}
		}
		catch(Exception ex) {			
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			scanner.close();
		}					
	}
	
	
	public void charCount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the char you would like to count in the file");
		char theChar = scanner.next().charAt(0);
		scanner.close();
		File file = new File(PATH);
		String text = "";
		try {
			scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				text += scanner.next();
			}
			
			int count = 0;
			for(char letter : text.toCharArray()) {
				if(letter == theChar) {
					count++;
				}
			}			
			scanner.close();	
			
			System.out.println("The char " + theChar + " appears " + count + " amount of times");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
	}
	
}