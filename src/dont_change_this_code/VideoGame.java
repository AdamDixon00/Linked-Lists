package dont_change_this_code;

/**
 * Simple class to store some information about a VideoGame.
 */
public class VideoGame {
	private String title;
	private double price;
	private int peakPlayers; 
	
	public VideoGame(String title, double price, int peakPlayers) {
		this.title = title;
		this.price = price;
		this.peakPlayers = peakPlayers;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getPeakPlayers() {
		return peakPlayers;
	}

	@Override
	public String toString() {
		return "{" + this.title + ", $" + this.price + ", " + peakPlayers + "}";
	}
}