package edu.pitt.cs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CoffeeMakerQuestTest {

	CoffeeMakerQuest cmq;
	Player player;
	ArrayList<Room> rooms;

	@Before
	public void setup() throws FileNotFoundException {
		// 0. Turn on bug injection for Player and Room.
		Config.setBuggyPlayer(true);
		Config.setBuggyRoom(true);

		// TODO: 1. Create a Player with no items (no coffee, no cream, no sugar)
		// and assign to player.
        player = Mockito.mock(Player.class);

		// TODO: 2. Create 6 rooms as specified in rooms.config and add to rooms list.
		rooms = new ArrayList<Room>();
		//Room1
        Room room1 = Mockito.mock(Room.class);
		Mockito.when(room1.getFurnishing()).thenReturn("Quaint sofa");
		Mockito.when(room1.getAdjective()).thenReturn("Small");
		Mockito.when(room1.getItem()).thenReturn(Item.CREAM);
		Mockito.when(room1.getNorthDoor()).thenReturn("Magenta");
		Mockito.when(room1.getSouthDoor()).thenReturn(null);
		rooms.add(room1);

		//Room2
        Room room2 = Mockito.mock(Room.class);
		Mockito.when(room2.getFurnishing()).thenReturn("Sad record player");
		Mockito.when(room2.getAdjective()).thenReturn("Funny");
		Mockito.when(room2.getItem()).thenReturn(Item.NONE);
		Mockito.when(room2.getNorthDoor()).thenReturn("Beige");
		Mockito.when(room2.getSouthDoor()).thenReturn("Massive");
		rooms.add(room2);

		//Room3
        Room room3 = Mockito.mock(Room.class);
		Mockito.when(room3.getFurnishing()).thenReturn("Tight Pizza");
		Mockito.when(room3.getAdjective()).thenReturn("Refinanced");
		Mockito.when(room3.getItem()).thenReturn(Item.COFFEE);
		Mockito.when(room3.getNorthDoor()).thenReturn("Dead");
		Mockito.when(room3.getSouthDoor()).thenReturn("Smart");
		rooms.add(room3);

		//Room4
        Room room4 = Mockito.mock(Room.class);
		Mockito.when(room4.getFurnishing()).thenReturn("Flat energy drink");
		Mockito.when(room4.getAdjective()).thenReturn("Dumb");
		Mockito.when(room4.getItem()).thenReturn(Item.NONE);
		Mockito.when(room4.getNorthDoor()).thenReturn("Vivacious");
		Mockito.when(room4.getSouthDoor()).thenReturn("Slim");
		rooms.add(room4);

		//Room5
        Room room5 = Mockito.mock(Room.class);
		Mockito.when(room5.getFurnishing()).thenReturn("Beautiful bag of money");
		Mockito.when(room5.getAdjective()).thenReturn("Bloodthirsty");
		Mockito.when(room5.getItem()).thenReturn(Item.NONE);
		Mockito.when(room5.getNorthDoor()).thenReturn("Purple");
		Mockito.when(room5.getSouthDoor()).thenReturn("Sandy");
		rooms.add(room5);

		//Room6
        Room room6 = Mockito.mock(Room.class);
		Mockito.when(room6.getFurnishing()).thenReturn("Perfect air hockey table");
		Mockito.when(room6.getAdjective()).thenReturn("Rough");
		Mockito.when(room6.getItem()).thenReturn(Item.SUGAR);
		Mockito.when(room6.getNorthDoor()).thenReturn(null);
		Mockito.when(room6.getSouthDoor()).thenReturn("Minimalist");
		rooms.add(room6);

		// 3. Create Coffee Maker Quest game using player and rooms, and assign to cmq.
		cmq = CoffeeMakerQuest.createInstance(player, rooms);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test case for String getInstructionsString().
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.getInstructionsString().
	 * Postconditions: Return value is " INSTRUCTIONS (N,S,L,I,D,H) > ".
	 * </pre>
	 */
	@Test
	public void testGetInstructionsString() {
		// TODO
        String result = cmq.getInstructionsString();
        String message = "The method getInstructionsString() did not return the correct value";
        assertEquals(message , " INSTRUCTIONS (N,S,L,I,D,H) > ", result);
	}

	/**
	 * Test case for Room getCurrentRoom().
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.getCurrentRoom().
	 * Postconditions: Return value is rooms.get(0).
	 * </pre>
	 */
	@Test
	public void testGetCurrentRoom() {
		// TODO
		String message = "getCurrentRoom() did not return the correct room";
		assertEquals(message, rooms.get(0), cmq.getCurrentRoom());
	}

	/**
	 * Test case for void setCurrentRoom(Room room) and Room getCurrentRoom().
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.setCurrentRoom(rooms.get(2)).
	 *                  Call cmq.getCurrentRoom().
	 * Postconditions: Return value of cmq.setCurrentRoom(rooms.get(2)) is true. 
	 *                 Return value of cmq.getCurrentRoom() is rooms.get(2).
	 * </pre>
	 */
	@Test
	public void testSetCurrentRoom() {
		// TODO
		String message1 = "setCurrentRoom(rooms.get(2)) returned false";
		String message2 = "getCurrentRoom() did not return the correct room";
		Boolean setResult = cmq.setCurrentRoom(rooms.get(2));
		Room getResult = cmq.getCurrentRoom();

		assertTrue(message1, setResult);
		assertEquals(message2, rooms.get(2), getResult);
	}

	/**
	 * Test case for boolean areDoorsPlacedCorrectly() when check succeeds.
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.areDoorsPlacedCorrectly().
	 * Postconditions: Return value of cmq.areDoorsPlacedCorrectly() is true.
	 * </pre>
	 */
	@Test
	public void testAreDoorsPlacedCorrectly() {
		// TODO
		String message = "areDoorsPlacedCorrectly returned false";
		assertTrue(message, cmq.areDoorsPlacedCorrectly());
	}

	/**
	 * Test case for boolean areDoorsPlacedCorrectly() when check fails.
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 *                rooms.get(3) is modified so that it has no south door.
	 * Execution steps: Call cmq.areDoorsPlacedCorrectly().
	 * Postconditions: Return value of cmq.areDoorsPlacedCorrectly() is false.
	 * </pre>
	 */
	@Test
	public void testAreDoorsPlacedCorrectlyMissingSouthDoor() {
		// TODO
		Room room3 = rooms.get(3);
		Mockito.when(room3.getSouthDoor()).thenReturn(null);

		String message = "areDoorsPlacedCorrectly returned true when it should have returned false";
		assertFalse(message, cmq.areDoorsPlacedCorrectly());
	}

	/**
	 * Test case for boolean areRoomsUnique() when check fails.
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 *                rooms.get(2) is modified so that its adjective is modified to "Small".
	 * Execution steps: Call cmq.areRoomsUnique().
	 * Postconditions: Return value of cmq.areRoomsUnique() is false.
	 * </pre>
	 */
	@Test
	public void testAreRoomsUniqueDuplicateAdjective() {
		// TODO
		Room room2 = rooms.get(2);
		Mockito.when(room2.getAdjective()).thenReturn("Small");

		String message = "areRoomsUnique() returns true when the rooms are not unique";
		assertFalse(message, cmq.areRoomsUnique());
	}

	/**
	 * Test case for String processCommand("I").
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 *                Player has no items.
	 * Execution steps: Call cmq.processCommand("I").
	 * Postconditions: Return value is "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n".
	 * </pre>
	 */
	@Test
	public void testProcessCommandI() {
		// TODO
		Mockito.when(player.getInventoryString()).thenReturn("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n");
		String actual = cmq.processCommand("I");
		
		String message = "Command 'I' did not return expected value.";
		String expected = "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n";
		
		assertEquals(message, expected, actual);
	}

	/**
	 * Test case for String processCommand("l").
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.processCommand("l").
	 * Postconditions: Return value is "There might be something here...\nYou found some creamy cream!\n".
	 *                 Item.CREAM has been added to the Player.
	 * </pre>
	 */
	@Test
	public void testProcessCommandLCream() {
		// TODO
		String actual = cmq.processCommand("l");
		String message = "Command 'l' did not return expected value.";
		String expected = "There might be something here...\nYou found some creamy cream!\n";
		
		assertEquals(message, expected, actual);
		Mockito.verify(player).addItem(Item.CREAM);
	}

	/**
	 * Test case for String processCommand("n").
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 *                cmq.setCurrentRoom(rooms.get(3)) has been called.
	 * Execution steps: Call cmq.processCommand("n").
	 *                  Call cmq.getCurrentRoom().
	 * Postconditions: Return value of cmq.processCommand("n") is "".
	 *                 Return value of cmq.getCurrentRoom() is rooms.get(4).
	 * </pre>
	 */
	@Test
	public void testProcessCommandN() {
		// TODO
		cmq.setCurrentRoom(rooms.get(3));
		
		String actual = cmq.processCommand("n");
		Room room = cmq.getCurrentRoom();
		
		String message1 = "Command 'n' did not return expected value";
		String message2 = "Current room is incorrect (expected 4)";
		
		assertEquals(message1, "", actual);
		assertEquals(message2, rooms.get(4), room);
	}

	/**
	 * Test case for String processCommand("s").
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.processCommand("s").
	 *                  Call cmq.getCurrentRoom().
	 * Postconditions: Return value of cmq.processCommand("s") is "A door in that direction does not exist.\n".
	 *                 Return value of cmq.getCurrentRoom() is rooms.get(0).
	 * </pre>
	 */
	@Test
	public void testProcessCommandS() {
		// TODO
		String actual = cmq.processCommand("s");
		Room room = cmq.getCurrentRoom();
		
		String message1 = "Command 's' did not return expected value";
		String message2 = "Current room is incorrect (expected 0)";
		String expected = "A door in that direction does not exist.\n";
		
		assertEquals(message1, expected, actual);
		assertEquals(message2, rooms.get(0), room);
	}

	/**
	 * Test case for String processCommand("D").
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 * Execution steps: Call cmq.processCommand("D").
	 *                  Call cmq.isGameOver().
	 * Postconditions: Return value of cmq.processCommand("D") is "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n\nYou drink thin air and can only dream of coffee. You cannot study.\nYou lose!\n".
	 *                 Return value of cmq.isGameOver() is true.
	 * </pre>
	 */
	@Test
	public void testProcessCommandDLose() {
		// TODO
		Mockito.when(player.getInventoryString()).thenReturn("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n");
		
		String commandResult = cmq.processCommand("D");
		boolean gameResult = cmq.isGameOver();
		
		String message1 = "Command 'D' did not return expected value";
		String message2 = "Game should be over, but it is not";
		String expected = "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n\nYou drink thin air and can only dream of coffee. You cannot study.\nYou lose!\n";
		
		assertEquals(message1, expected, commandResult);
		assertTrue(message2, gameResult);
	}

	/**
	 * Test case for String processCommand("D").
	 * 
	 * <pre>
	 * Preconditions: Player, rooms, and cmq test fixture has been created.
	 *                Player has all 3 items (coffee, cream, sugar).
	 * Execution steps: Call cmq.processCommand("D").
	 *                  Call cmq.isGameOver().
	 * Postconditions: Return value of cmq.processCommand("D") is "You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.\n\nYou drink the beverage and are ready to study!\nYou win!\n".
	 *                 Return value of cmq.isGameOver() is true.
	 * </pre>
	 */
	@Test
	public void testProcessCommandDWin() {
		// TODO
		Mockito.when(player.checkCoffee()).thenReturn(true);
		Mockito.when(player.checkCream()).thenReturn(true);
		Mockito.when(player.checkSugar()).thenReturn(true);
		Mockito.when(player.getInventoryString()).thenReturn("You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.\n");

		String commandResult = cmq.processCommand("D");
		boolean gameResult = cmq.isGameOver();

		String message1 = "Command 'D' did not return expected value.";
		String message2 = "Game should be over, but it is not";
		String expected = "You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.\n\nYou drink the beverage and are ready to study!\nYou win!\n";
		
		assertEquals(message1, expected, commandResult);
		assertTrue(message2, gameResult);
	}

	// TODO: Put in more unit tests of your own making to improve coverage!

	//tests tests areDoorsPlacedCorrectly() when there is only a single room in the game and the room is configured correctly
	@Test
	public void testValidSingleRoom() {
		//setup room with no doors
		Room room = Mockito.mock(Room.class);
		Mockito.when(room.getNorthDoor()).thenReturn(null);
		Mockito.when(room.getSouthDoor()).thenReturn(null);

		//add room to an array list and make a new cmq object with that list as the rooms arraylist
		ArrayList<Room> roomsList = new ArrayList<Room>();
		roomsList.add(room);
		CoffeeMakerQuestImpl cmq2 = new CoffeeMakerQuestImpl(player, roomsList);

		//test areDoorsPlacedCorrectly()
		String message = "areDoorsPlacedCorrrectly does not return the correct value for a single room";
		assertTrue(message, cmq2.areDoorsPlacedCorrectly());
	}

	//tests areDoorsPlacedCorrectly() when there is only a single room in the game and the room is configured incorrectly
	@Test
	public void testInvalidSingleRoom() {
		//setup room with both doors
		Room room = Mockito.mock(Room.class);
		Mockito.when(room.getNorthDoor()).thenReturn("Tall");
		Mockito.when(room.getSouthDoor()).thenReturn("Short");

		//add room to an array list and make a new cmq object with that list as the rooms arraylist
		ArrayList<Room> roomsList = new ArrayList<Room>();
		roomsList.add(room);
		CoffeeMakerQuestImpl cmq2 = new CoffeeMakerQuestImpl(player, roomsList);

		//test areDoorsPlacedCorrectly()
		String message = "areDoorsPlacedCorrrectly does not return the correct value for a single room";
		assertFalse(message, cmq2.areDoorsPlacedCorrectly());
	}

	//tests areRoomsUnique() when all the rooms are unique
	@Test
	public void testUniqueRooms() {
		String message = "areRoomsUnique returns false when all the rooms are unique";
		assertTrue(message, cmq.areRoomsUnique());
	}

	//tests setCurrentRoom() when passed a null room
	@Test
	public void testNullRoomSetCurrentRoom() {
		Room room = null;
		String message = "setCurrentRoom() returns true on a null room";
		assertFalse(message, cmq.setCurrentRoom(room));
	}

	//tests the "N" command when a door does not exist to the north
	@Test
	public void testProcessCommandNNoDoorNorth() {
		Room room = rooms.get(rooms.size() - 1);
		cmq.setCurrentRoom(room);

		String message = "processCommand() did not output the error message when the command N is entered with no existing north door";
		String expected = "A door in that direction does not exist.\n";
		assertEquals(message, expected, cmq.processCommand("N"));
	}

	//this test tests the "S" command when there is a valid door to the south
	@Test
	public void testProcessCommandSValidDoorSouth() {
		Room room = rooms.get(1);
		cmq.setCurrentRoom(room);

		String message1 = "processCommand() did not output the error message when the command S is entered with an existing north door";
		String message2 = "the current room was not changed when the S command was used";
		assertEquals(message1, "", cmq.processCommand("S"));
		assertEquals(message2, rooms.get(0), cmq.getCurrentRoom());
	}

	//this test tests the "L" command when the room has coffee
	@Test
	public void testProcessCommandLCoffee() {
		
		String message = "Command 'l' did not return expected value.";
		String expected = "There might be something here...\nYou found some caffeinated coffee!\n";
		
		cmq.setCurrentRoom(rooms.get(2));
		String actual = cmq.processCommand("l");
		assertEquals(message, expected, actual);
		Mockito.verify(player).addItem(Item.COFFEE);
	}

	//this test tests the "L" command when the room has sugar
	@Test
	public void testProcessCommandLSugar() {
		
		String message = "Command 'l' did not return expected value.";
		String expected = "There might be something here...\nYou found some sweet sugar!\n";
		
		cmq.setCurrentRoom(rooms.get(5));
		String actual = cmq.processCommand("l");
		assertEquals(message, expected, actual);
		Mockito.verify(player).addItem(Item.SUGAR);
	}

	//this test tests the "L" command when the room has nothing
	@Test
	public void testProcessCommandLEmpty() {
		
		String message = "Command 'l' did not return expected value.";
		String expected = "You don't see anything out of the ordinary.\n";
		
		cmq.setCurrentRoom(rooms.get(1));
		String actual = cmq.processCommand("l");
		assertEquals(message, expected, actual);
	}

	//this test tests the "H" command
	@Test
	public void testProcessCommandH() {
		String message = "Command 'H' did not return the expected value";
		String expected = "N - Go north\nS - Go south\nL - Look and collect any items in the room\nI - Show inventory of items collected\nD - Drink coffee made from items in inventory\n";
		assertEquals(message, expected, cmq.processCommand("H"));
	}

	//this test tests process command with an invalid input
	@Test
	public void testProcessCommandInvalid() {
		String message = "Entering an invalid command did not return the expected value";
		String expected = "What?\n";

		assertEquals(message, expected, cmq.processCommand("12345"));
	}

	

	//tests the private method northAndSouthCorrect when the north room is configured incorrectly
	@Test
	public void testInvalidNorthDoor() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = CoffeeMakerQuestImpl.class.getDeclaredMethod("northAndSouthCorrect", Room.class, Room.class);
		method.setAccessible(true);

		Room north = Mockito.mock(Room.class);
		Mockito.when(north.getSouthDoor()).thenReturn("Slim");
		Mockito.when(north.getNorthDoor()).thenReturn("Purple");

		Room south = Mockito.mock(Room.class);
		Mockito.when(south.getNorthDoor()).thenReturn("Heavy");

		Boolean res = (Boolean)method.invoke(cmq, north, south);
		String message = "the private method northAndSouthCorrect returned true when it should return false";
		assertFalse(message, res.booleanValue());
		
	}

	//tests the private method northAndSouthCorrect when the south room is configured incorrectly
	@Test
	public void testInvalidSouthDoor() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = CoffeeMakerQuestImpl.class.getDeclaredMethod("northAndSouthCorrect", Room.class, Room.class);
		method.setAccessible(true);

		Room north = Mockito.mock(Room.class);
		Mockito.when(north.getSouthDoor()).thenReturn("Purple");

		Room south = Mockito.mock(Room.class);
		Mockito.when(south.getSouthDoor()).thenReturn("Orange");
		Mockito.when(south.getNorthDoor()).thenReturn("Heavy");

		Boolean res = (Boolean)method.invoke(cmq, north, south);
		String message = "the private method northAndSouthCorrect returned true when it should return false";
		assertFalse(message, res.booleanValue());
		
	}

}
