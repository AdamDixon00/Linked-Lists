package your_code;
/**
 * Author:        <Adam Dixon>
 **/
import java.util.Comparator;

import dont_change_this_code.VideoGame;
import dont_change_this_code.VideoGameNode;

/**
 * 
 * This is the class that you are responsible for implementing.  Please read the
 * comments very carefully. 
 */
public class VideoGameLinkedList {
	private VideoGameNode head;
	private VideoGameNode tail;

	private int size;

	public VideoGameLinkedList() {
		this.head = this.tail = null;
		this.size = 0;
	}

	/**
	 * This method takes the VideoGame object and adds it to the end of the VideoGameLinkedList.
	 */
	public void addLastVideoGame(VideoGame game) {
		VideoGameNode temp = new VideoGameNode(game);
		if (head == null) {
			head = temp;
			tail = temp;
			
		} else {
			VideoGameNode current = head;
			while (current.getNextGameNode() != null) {
				current = current.getNextGameNode();
			}
			current.setNextGameNode(temp);
			tail = temp;
		}
	}

	/**
	 * This method takes the VideoGame object and adds it to the beginning of 
	 * the VideoGameLinkedList.
	 */
	public void addFirstVideoGame(VideoGame game) {
	VideoGameNode temp = new VideoGameNode(game);
	temp.setNextGameNode(head);

	head = temp;

	if (tail == null) {
		tail = temp;
	}
}

	/**
	 * This method takes the VideoGame object and inserts it anywhere within the list. 
	 * This method validates the index within the correct bounds and throw an
	 *  IndexOutOfBoundsException if the index is not correct.
	 */
	public void insertVideoGame(VideoGame game, int index) 
			throws IndexOutOfBoundsException {

		if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    if (index == 0) {

        addFirstVideoGame(game);
    } else if (index == size) {

        addLastVideoGame(game);
    } else {
		
        VideoGameNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNextGameNode();
        }
        VideoGameNode temp = new VideoGameNode(game);
        temp.setNextGameNode(current.getNextGameNode());
        current.setNextGameNode(temp);
        size++;
    }
}


	/**
	 * This method removes and returns the first 
	 * VideoGame object from the list.  If the list is empty, throw an 
	 * IllegalStateException.
	 */
	public VideoGame removeFirstVideoGame() 
	throws IllegalStateException {

	if (size == 0) {
		throw new IllegalStateException("List is empty.");
	}

	VideoGameNode removedNode = head;
	head = head.getNextGameNode();
	size--;

	if (size == 0) {
		
		tail = null;
	}

	return removedNode.getVideoGame();
}

	/**
	 * This method removes and returns the last 
	 * VideoGame object from the list. If the list is empty, throw an 
	 * IllegalStateException.
	 */
	public VideoGame removeLastVideoGame() throws IllegalStateException {
	if (size == 0) {
		throw new IllegalStateException("The list is empty.");
	}

	VideoGameNode removedNode;
	if (size == 1) {
		// If the list only has one node, remove it and update head and tail pointers
		removedNode = head;
		head = null;
		tail = null;
	} else {
		// Traverse the list to find the second-to-last node
		VideoGameNode current = head;
		while (current.getNextGameNode() != tail) {
			current = current.getNextGameNode();
		}

		// Remove the last node and update tail pointer
		removedNode = tail;
		tail = current;
		tail.setNextGameNode(null);
	}

	size--;
	return removedNode.getVideoGame();
}

	/**
	 * This method removes and returns the a 
	 * VideoGame object from anywhere in the list.  If the list is empty, throw an 
	 * IllegalStateException. If the index is out of bounds, throw an
	 * IndexOutOfBoundsException.
	 */
	public VideoGame removeVideoGame(int index) throws IndexOutOfBoundsException, IllegalStateException {
		if (head == null) {
			throw new IllegalStateException("Can't remove from an empty list");
		}
	
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
	
		VideoGame removedGame;
		if (index == 0) {
			removedGame = removeFirstVideoGame();
		} else if (index == size - 1) {
			removedGame = removeLastVideoGame();
		} else {
			VideoGameNode current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNextGameNode();
			}
			removedGame = current.getNextGameNode().getVideoGame();
			current.setNextGameNode(current.getNextGameNode().getNextGameNode());
			size--;
		}
	
		return removedGame;
	}

	/**
	 * This method returns the VideoGame object at the 
	 * given index. If the index is out of bounds throw an 
	 * IndexOutOfBoundsException.
	 */
	public VideoGame getVideoGame(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		VideoGameNode current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNextGameNode();
		}
		return current.getVideoGame();
	}

	/**
	 * Method to sort the VideoGameLinkedList using the given comparator.
	 * Sort the list by title of each video game, price, or
	 * peak player count depending on which comparator we give to the sort method.
	 */
	public void sort(Comparator<VideoGame> comparator) {   
		// handle cases where the list has a size of 1 or 2
		if (head == null || head.getNextGameNode() == null) {
			return;
		}
		// general case
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			VideoGameNode prevNode = null;
			VideoGameNode currentNode = head;
			VideoGameNode nextNode = head.getNextGameNode();
			while (nextNode != null) {
				if (comparator.compare(currentNode.getVideoGame(), nextNode.getVideoGame()) > 0) {
					sorted = false;
					if (prevNode != null) {
						prevNode.setNextGameNode(nextNode);
					} else {
						head = nextNode;
					}
					currentNode.setNextGameNode(nextNode.getNextGameNode());
					nextNode.setNextGameNode(currentNode);
					VideoGameNode temp = nextNode;
					nextNode = currentNode;
					currentNode = temp;
				}
				prevNode = currentNode;
				currentNode = nextNode;
				nextNode = nextNode.getNextGameNode();
			}
		}
	}

	/**
	 * This method returns the correct size of the list
	 * at any given time. This method is in O(1) time.
	 */
	public int size() {
		int count = 0;
    VideoGameNode current = head;
    while (current != null) {
        count++;
        current = current.getNextGameNode();
    }
	size = count;
    return size;
}

	/**
	 * This returns true if the list is not empty, and false if the
	 * list is empty.
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * This method returns a String representation of this LinkedList  
	 */
	@Override
	public String toString() {	
		if (this.isEmpty()) {
			return "[LIST IS EMPTY]";
		}
		else if (this.size == 1) {
			return this.head.toString();
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("Head ->\t" + this.head.getVideoGame());

			VideoGameNode current = this.head.getNextGameNode();

			while (current != null) {
				if(current == this.tail) {
					sb.append("\nTail ->\t" + current.getVideoGame());
				}
				else {
					sb.append("\n\t" + current.getVideoGame());
				}

				current = current.getNextGameNode();
			}

			return sb.toString();	
		}
	}	
}