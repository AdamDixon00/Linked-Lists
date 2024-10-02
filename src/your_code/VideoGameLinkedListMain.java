package your_code;
/**
 * Author:        <Adam Dixon>
 **/

import java.io.File;
import dont_change_this_code.*;

public class VideoGameLinkedListMain {
	public static void main(String[] args) {
		VideoGameLinkedList gameList = VideoGameReader.parseData(new File("src\\game_data_files\\video_game_data.csv"));
        // Print out the size of the list
        System.out.println("Size of list: " + gameList.size());

        // Print out the list of video games
        System.out.println("Video games list:");
        System.out.println(gameList);

        // Remove the first video game
        System.out.println("Removing first video game...");
        gameList.removeFirstVideoGame();

        // Print out the size of the list again
        System.out.println("Size of list: " + gameList.size());

        // Print out the list of video games again
        System.out.println("Video games list:");
        System.out.println(gameList);

        // Sort the list by title
        gameList.sort(new VideoGameTitleComparator());

        // Print out the list of video games sorted by title
        System.out.println("List sorted by title:");
        System.out.println(gameList);

        // Sort the list by price
        gameList.sort(new VideoGameTitleComparator());

        // Print out the list of video games sorted by price
        System.out.println("List sorted by price:");
        System.out.println(gameList);

        // Sort the list by peak player count
        gameList.sort(new VideoGameTitleComparator());

        // Print out the list of video games sorted by peak player count
        System.out.println("List sorted by peak player count:");
        System.out.println(gameList);

        // Remove the last video game
        System.out.println("Removing last video game...");
        gameList.removeLastVideoGame();

        // Print out the size of the list again
        System.out.println("Size of list: " + gameList.size());

        // Print out the list of video games again
        System.out.println("Video games list:");
        System.out.println(gameList);

        // Remove the video game at index 1
        System.out.println("Removing video game at index 1...");
        gameList.removeVideoGame(1);

        // Print out the size of the list again
        System.out.println("Size of list: " + gameList.size());

        // Print out the list of video games again
        System.out.println("Video games list:");
        System.out.println(gameList);

        // Get the video game at index 1
        System.out.println("Getting video game at index 1...");
        VideoGame game = gameList.getVideoGame(1);

        // Print out the video game
        System.out.println(game);

        // Check if the list is empty
        System.out.println("List empty? " + gameList.isEmpty());
    }

}
