package your_code;
/**
 * Name:        <Adam Dixon>
 * CIN:         <304772993>
 * Course:      <CS 2013-07>
 * Section:     <34334>
 **/
import java.util.Comparator;

import dont_change_this_code.VideoGame;

/**
 * Comparator to sort VideoGame objects based on their titles.
 * 
 * @author Prof. Keenan Knaur | California State University, Los Angeles | CS2013
 * @author (YOUR INFORMATION GOES HERE)
 */
public class VideoGameTitleComparator implements Comparator<VideoGame>{

	/**
	 * This method should be implemented to compare two VideoGame objects based 
	 * on the value of their Titles.
	 * 
	 * This method should have the following results:
	 * 		return 0 if the titles of both games are the same.
	 * 		return -1 if the title of game1 is lexicographically < the title of game2.
	 * 		return 1 if the title of game1 is lexicographically > the title of game2.
	 * 
	 * @param game1		The first game to compare.
	 * @param game2		The second game to compare.
	 * 
	 * @return An int to indicate how game1 compares to game2.
	 */
	@Override
		public int compare(VideoGame game1, VideoGame game2) {
			String title1 = game1.getTitle();
		String title2 = game2.getTitle();
		int result = title1.compareTo(title2);
		if (result == 0) {
			return 0;
		} else if (result < 0) {
			return -1;
		} else {
			return 1;
		}
	}
}