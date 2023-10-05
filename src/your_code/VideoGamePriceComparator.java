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
 * Comparator to sort VideoGame objects based on their price values.
 * 
 * @author Prof. Keenan Knaur | California State University, Los Angeles | CS2013
 * @author (YOUR INFORMATION GOES HERE)
 */
public class VideoGamePriceComparator implements Comparator<VideoGame>{

	/**
	 * This method should be implemented to compare two VideoGame objects based 
	 * on the value of their Prices.
	 * 
	 * This method should have the following results:
	 * 		return 0 if the prices of both games are equal.
	 * 		return -1 if the price of game1 < the price of game2.
	 * 		return 1 if the price of game1 > the price of game2.
	 * 
	 * @param game1		The first game to compare.
	 * @param game2		The second game to compare.
	 * 
	 * @return An int to indicate how game1 compares to game2.
	 */
	@Override
	public int compare(VideoGame game1, VideoGame game2) {
			double price1 = game1.getPrice();
			double price2 = game2.getPrice();
			if (price1 == price2) {
				return 0;
			} else if (price1 < price2) {
				return -1;
			} else {
				return 1;
			}
		}

}
