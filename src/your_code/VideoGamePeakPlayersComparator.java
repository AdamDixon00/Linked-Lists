package your_code;
/**
 * Author:        <Adam Dixon>
 **/
import java.util.Comparator;

import dont_change_this_code.VideoGame;

/**
 * Comparator to sort VideoGame objects based on their Peak Players value.
 */
public class VideoGamePeakPlayersComparator implements Comparator<VideoGame>{

	/**
	 * This method compares two VideoGame objects based 
	 * on the value of their Peak Players.
	 */
	@Override
	public int compare(VideoGame game1, VideoGame game2) {
		int peakPlayers1 = game1.getPeakPlayers();
		int peakPlayers2 = game2.getPeakPlayers();
		if (peakPlayers1 == peakPlayers2) {
			return 0;
		} else if (peakPlayers1 < peakPlayers2) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
