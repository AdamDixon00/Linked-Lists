package your_code;
/**
 * Author:        <Adam Dixon>
 **/
import java.util.Comparator;

import dont_change_this_code.VideoGame;

/**
 * Comparator to sort VideoGame objects based on their price values.
 */
public class VideoGamePriceComparator implements Comparator<VideoGame>{

	/**
	 * This method compares two VideoGame objects based 
	 * on the value of their Prices.
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
