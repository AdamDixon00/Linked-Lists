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
 * Comparator to sort VideoGame objects based on their Peak Players value.
 * 
 * @author Prof. Keenan Knaur | California State University, Los Angeles | CS2013
 * @author (YOUR INFORMATION GOES HERE)
 */
public class VideoGamePeakPlayersComparator implements Comparator<VideoGame>{

	/**
	 * This method should be implemented to compare two VideoGame objects based 
	 * on the value of their Peak Players.
	 * 
	 * This method should have the following results:
	 * 		return 0 if the peak players of both games are equal.
	 * 		return -1 if the peak players of game1 < the peak players of game2.
	 * 		return 1 if the peak players of game1 > the peak players of game2.
	 * 
	 * @param game1		The first game to compare.
	 * @param game2		The second game to compare.
	 * 
	 * @return An int to indicate how game1 compares to game2.
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
