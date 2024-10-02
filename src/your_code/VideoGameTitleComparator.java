package your_code;
/**
 * Author:        <Adam Dixon>
 **/
import java.util.Comparator;

import dont_change_this_code.VideoGame;

/**
 * Comparator to sort VideoGame objects based on their titles.
 */
public class VideoGameTitleComparator implements Comparator<VideoGame>{

	/**
	 * This method should be implemented to compare two VideoGame objects based 
	 * on the value of their Titles.
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