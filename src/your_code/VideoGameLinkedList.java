package your_code;
/**
 * Name:        <Adam Dixon>
 * CIN:         <304772993>
 * Course:      <CS 2013-07>
 * Section:     <34334>
 **/
import java.util.Comparator;

import dont_change_this_code.VideoGame;
import dont_change_this_code.VideoGameNode;

/**
 * 
 * This is the class that you are responsible for implementing.  Please read the
 * comments very carefully. 
 * 
 * In order to correctly implement the methods, you will need to study the
 * algorithms presented in the LinkedList lecture slides.
 * 
 * Restrictions:
 * 		-You are NOT allowed to use any other data structures.  If you do, no
 * 		credit will be given for your submission.
 * 		-You are NOT allowed to change any of the method headers.
 * 		-You are NOT allowed to change any methods that are already completed.
 * 		-You are NOT allowed to add any other methods.
 * 
 * @author Prof. Keenan Knaur | California State University, Los Angeles | CS2013
 * @author (YOUR INFORMATION GOES HERE)
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
	 * You will need to complete this method so that it takes the VideoGame object
	 * and adds it to the end of the VideoGameLinkedList.
	 * 
	 * @param game The VideoGame object to be added.
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
	 * You will need to complete this method so that it takes the VideoGame object
	 * and adds it to the beginning of the VideoGameLinkedList.
	 * 
	 * @param game The VideoGame object to be added.
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
	 * You will need to complete this method so that it takes the VideoGame object
	 * and inserts it anywhere within the list. 
	 * 
	 * This method must validate that the index is within the correct bounds 
	 * and throw an IndexOutOfBoundsException if the index is not correct.
	 * 
	 * NOTE: Make sure the upper bound of the index validation is correct.  For
	 * this method the index validation must allow an index == size in order to
	 * add a new node to the end of the list.
	 * 
	 * @param game	 The VideoGame object to add.
	 * @param index  The index of where the new VideoGame object should be inserted.
	 * 		
	 * @throws IndexOutOfBoundsException Throws this exception when the index is
	 * out of bounds.
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
	 * This method must be implemented to correctly remove and return the first 
	 * VideoGame object from the list.  If the list is empty, throw an 
	 * IllegalStateException.
	 * 
	 * @return	The VideoGame object that was removed.
	 * 
	 * @throws IllegalStateException When the list is empty.
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
	 * This method must be implemented to correctly remove and return the last 
	 * VideoGame object from the list.  If the list is empty, throw an 
	 * IllegalStateException.
	 * 
	 * @return	The VideoGame object that was removed.
	 * 
	 * @throws IllegalStateException When the list is empty.
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
	 * This method must be implemented to correctly remove and return the a 
	 * VideoGame object from anywhere in the list.  If the list is empty, throw an 
	 * IllegalStateException.  If the index is out of bounds, throw an
	 * IndexOutOfBoundsException.
	 * 
	 * @return	The VideoGame object that was removed.
	 * 
	 * @throws IllegalStateException When the list is empty.
	 * @throws IndexOutOfBoundsException When the index is out of bounds.
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
	 * This method must be implemented to return the VideoGame object at the 
	 * given index.  If the index is out of bounds throw an 
	 * IndexOutOfBoundsException.  
	 * 
	 * NOTE: You are returning the VideoGame object encapsulated by the
	 * VideoGameNode.  You are NOT returning the Node itself.
	 * 
	 * @param index		The index of the VideoGame that you want to return.
	 * 
	 * @return	The VideoGame object at the given index.
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
	 * We will be able to sort the list by title of each video game, price, or
	 * peak player count depending on which comparator we give to the sort method.
	 * 
	 * Use the following sorting pseudocode to help you sort your nodes, this is
	 * the same sorting algorithm that we used in a previous assignment.
	 *		while the list is not sorted:
	 *	   		for each adjacent pair of items: 
	 *	      		if the pair of items are out of order: 
	 *	         		swap the pair of items
	 * 
	 * HINT 1: For the "swapping" part of this sorting algorithm, think of how you
	 * can interchange the positions of two nodes in this linked list by using
	 * ONLY the other methods in this class.
	 * 
	 * HINT 2: There are three general cases to consider, the list has a size of 1,
	 * the list has a size of 2, the list has any other size.
	 * 
	 * @param comparator 	A Comparator object which is used to sort this list.
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
	 * This method should be implemented to return the correct size of the list
	 * at any given time.  This method should be implemented in O(1) time.
	 * 
	 * @return	An int that is the size of the list.
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
	 * This method should return true if the list is not empty, and false if the
	 * list is empty.
	 * 
	 * @return	A boolean indicating whether or not the list is empty.
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * This method returns a String representation of this LinkedList  
	 * 
	 * DO NOT CHANGE THIS METHOD.
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