package dont_change_this_code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import your_code.VideoGameLinkedList;

/**
 * Node Class for the VideoGameReader.
 */
public final class VideoGameReader {
	
	private VideoGameReader() {}
	
	/**
	 * The method reads a given File object using text i/o.
	 * This method will parse the data in the file and then create a 
	 * VideoGameLinkedList object.  This list will then be returned from the 
	 * method.
	 */
	public static VideoGameLinkedList parseData(File inFile) {
		VideoGameLinkedList list = new VideoGameLinkedList();
		try {
			Scanner reader = new Scanner(inFile);
			while(reader.hasNext()) {
				String[] tokens = reader.nextLine().split(",");
				VideoGame nextGame = new VideoGame(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]));
				list.addLastVideoGame(nextGame);
			}		
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	
}
