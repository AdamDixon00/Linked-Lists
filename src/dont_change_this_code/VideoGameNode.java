package dont_change_this_code;

/**
 * Node Class for the VideoGameLinkedList.
 */
public class VideoGameNode {
	private VideoGame game; 
	private VideoGameNode nextGame;

	/**
	 * Constructor which makes a VideoGameNode object from the given VideoGame.
	 * 
	 * @param game  The VideoGame object to encapsulate in this node.
	 */
	public VideoGameNode(VideoGame game) {
		this.game = game;
	}
	
	/**
	 * Returns the VideoGame stored in this node.
	 */
	public VideoGame getVideoGame() {
		return this.game;
	}
	
	/**
	 * This method returns the VideoGameNode object that comes after this Node.
	 * Keep in mind that this method returns the Node, NOT the VideoGame.
	 */
	public VideoGameNode getNextGameNode() {
		return this.nextGame;
	}
	
	/**
	 * This method allows you to connect this node to the node that should come
	 * after this node in sequence.
	 */
	public void setNextGameNode(VideoGameNode gameNode) {
		this.nextGame = gameNode;
	}
	
	@Override
	public String toString() {
		return "VideoGameNode(" + this.game.toString() + ")";
	}
}
