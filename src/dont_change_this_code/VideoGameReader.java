package dont_change_this_code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import your_code.VideoGameLinkedList;

/**
 * Node Class for the VideoGameReader.
 * 
 * DO NOT CHANGE ANY OF THIS CODE!!!
 * 
 * @author Prof. Keenan Knaur | California State University, Los Angeles | CS2013
 *
 */
public final class VideoGameReader {
	
	private VideoGameReader() {}
	
	/**
	 * The method reads a given File object using text i/o.  The File object should
	 * be a .csv file with video game data in it.  The data has the format:
	 *      Video_Game_Name,Price,Peak_Players
	 * 
	 * This method will parse the data in the file and then create a 
	 * VideoGameLinkedList object.  This list will then be returned from the 
	 * method.
	 * 			
	 * NOTE: This method will only work after the addLastVideoGame() method of
	 * your VideoGameLinkedList class is working correctly.
	 * 
	 * @param inFile	The .csv file that contains the video game data.
	 * @return	A VideoGameLinkedList object.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
	}
	
	
}
