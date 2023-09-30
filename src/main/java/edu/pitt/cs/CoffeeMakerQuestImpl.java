package edu.pitt.cs;

import java.util.*;

public class CoffeeMakerQuestImpl implements CoffeeMakerQuest {

	// TODO: Add more member variables and methods as needed.
	Player player;
	ArrayList<Room> rooms;
	Room currentRoom;
	int currentRoomIndex;
	boolean gameOver;
	/**
	 * Constructor. Rooms are laid out from south to north, such that the
	 * first room in rooms becomes the southernmost room and the last room becomes
	 * the northernmost room. Initially, the player is at the southernmost room.
	 *
	 * @param player Player for this game
	 * @param rooms  List of rooms in this game
	 */
	CoffeeMakerQuestImpl(Player player, ArrayList<Room> rooms) {
		// TODO
		this.player = player;
		this.rooms = rooms;
		currentRoom = rooms.get(0);
		currentRoomIndex = 0;
	}

	/**
	 * Whether the game is over. The game ends when the player drinks the coffee.
	 *
	 * @return true if the game is over, false otherwise
	 */
	public boolean isGameOver() {
		// TODO
		return gameOver;
	}

	/**
	 * The method returns success if and only if: 1) Th southernmost room has a
	 * north door only, 2) The northernmost room has a south door only, and 3) The
	 * rooms in the middle have both north and south doors. If there is only one
	 * room, there should be no doors.
	 *
	 * @return true if check successful, false otherwise
	 */
	public boolean areDoorsPlacedCorrectly() {
		// TODO

		//Check for when there is only one door
		if(rooms.size() == 1){
			Room room = rooms.get(0);
			if(room.getNorthDoor() == null && room.getSouthDoor() == null)
				return true;
			else
				return false;
		}

		//check nothernmost and southernmost room conditions
		Room south = rooms.get(0);
		Room north = rooms.get(rooms.size() - 1);

		if(northAndSouthCorrect(north, south) == false)
			return false;


		//check middle room conditions
		for(int i = 1; i < rooms.size() - 1; i++){
			Room room = rooms.get(i);
			if(room.getSouthDoor() == null || room.getNorthDoor() == null)
				return false;
		}

		//return true if all checks pass without returning false
		return true;
	}

	private boolean northAndSouthCorrect(Room northRoom, Room southRoom) {
		if(northRoom.getSouthDoor() == null || northRoom.getNorthDoor() != null)
			return false;
		if(southRoom.getSouthDoor() != null || southRoom.getNorthDoor() == null)
			return false;

		return true;
	}


	/**
	 * Checks whether each room has a unique adjective and furnishing.
	 *
	 * @return true if check successful, false otherwise
	 */

	public boolean areRoomsUnique() {
		// TODO
		ArrayList<String> adjectives = new ArrayList<String>();

		for(Room room : rooms) {
			String adjective = room.getAdjective();
			if(adjectives.contains(adjective))
				return false;
			else
				adjectives.add(adjective);
		}

		return true;
	}

	/**
	 * Returns the room the player is currently in. If location of player has not
	 * yet been initialized with setCurrentRoom, returns null.
	 *
	 * @return room player is in, or null if not yet initialized
	 */
	public Room getCurrentRoom() {
		// TODO
		if (rooms == null) 
			return null;

		return currentRoom;
	}

	/**
	 * Set the current location of the player. If room does not exist in the game,
	 * then the location of the player does not change and false is returned.
	 *
	 * @param room the room to set as the player location
	 * @return true if successful, false otherwise
	 */
	public boolean setCurrentRoom(Room room) {
		// TODO
		if (room == null || !rooms.contains(room)) 
			return false;

		currentRoom = room;
		currentRoomIndex = rooms.indexOf(room);

		return true;
	}

	/**
	 * Get the instructions string command prompt. It returns the following prompt:
	 * " INSTRUCTIONS (N,S,L,I,D,H) > ".
	 *
	 * @return comamnd prompt string
	 */
	public String getInstructionsString() {
		// TODO
		return " INSTRUCTIONS (N,S,L,I,D,H) > ";
	}

	/**
	 * Processes the user command given in String cmd and returns the response
	 * string. For the list of commands, please see the Coffee Maker Quest
	 * requirements documentation (note that commands can be both upper-case and
	 * lower-case). For the response strings, observe the response strings printed
	 * by coffeemaker.jar. The "N" and "S" commands potentially change the location
	 * of the player. The "L" command potentially adds an item to the player
	 * inventory. The "D" command drinks the coffee and ends the game. Make
	 * sure you use Player.getInventoryString() whenever you need to display
	 * the inventory.
	 *
	 * @param cmd the user command
	 * @return response string for the command
	 */
	public String processCommand(String cmd) {
		// TODO
		cmd = cmd.toLowerCase();
		switch(cmd){
			case "n":
				if (currentRoom.getNorthDoor() == null) {
					return "A door in that direction does not exist.\n";
				}
				else {
					setCurrentRoom(rooms.get(currentRoomIndex+1));
					return "";
				}
			case "s":
				if (currentRoom.getSouthDoor() == null){
					return "A door in that direction does not exist.\n";
				}
				else {
					setCurrentRoom(rooms.get(currentRoomIndex-1));
					return "";
				}
			case "l":
				Item i = currentRoom.getItem();
				if (i != null){
					player.addItem(i);
				}
				switch (i) {
					case COFFEE:
						return "There might be something here...\nYou found some caffeinated coffee!\n";
					case CREAM:
						return "There might be something here...\nYou found some creamy cream!\n";
					case SUGAR:
						return "There might be something here...\nYou found some sweet sugar!\n";
					default:
						return "You don't see anything out of the ordinary.\n";
				}
			case "i":
				return player.getInventoryString();
			case "d":
				// if you have all 3, you win
				if (player.checkCoffee() && player.checkCream() && player.checkSugar()){
					gameOver = true;
					return player.getInventoryString() + "You drink the beverage and are ready to study!\nYou win!\n";
				}
				// if you have 1, there is a special statement
				if (player.checkCoffee() || player.checkCream() || player.checkSugar()){
					gameOver = true;
					return player.getInventoryString() + "You refuse to drink this half-made sludge. You cannot study.\nYou lose!\n";
				} else {
					gameOver = true;
					return player.getInventoryString() + "You drink thin air and can only dream of coffee. You cannot study.\nYou lose!\n";
				}
			case "h":
				return "N - Go north\nS - Go south\nL - Look and collect any items in the room\nI - Show inventory of items collected\nD - Drink coffee made from items in inventory\n\n";
			default:
				return "What?\n";
		}
	}
}
