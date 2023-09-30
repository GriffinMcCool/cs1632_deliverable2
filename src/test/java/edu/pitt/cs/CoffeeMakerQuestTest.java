package edu.pitt.cs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
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
		cmq = new CoffeeMakerQuestImpl(player, rooms);
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
        String res = cmq.getInstructionsString();
        String message = "The method getInstructionsString() did not return the correct value";
        assertEquals(message , " INSTRUCTIONS (N,S,L,I,D,H) > ", res);
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
		String s = cmq.processCommand("I");
		String msg = "Command 'I' did not return expected value.";
		String exp = "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n";
		assertEquals(msg, exp, s);
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
		String s = cmq.processCommand("l");
		String msg = "Command 'l' did not return expected value.";
		String exp = "There might be something here...\nYou found some creamy cream!\n";
		assertEquals(msg, exp, s);
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
		String s = cmq.processCommand("n");
		Room r = cmq.getCurrentRoom();
		String msg1 = "Command 'n' did not return expected value";
		String msg2 = "Current room is incorrect (expected 4)";
		assertEquals(msg1, "", s);
		assertEquals(msg2, rooms.get(4), r);
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
		String s = cmq.processCommand("s");
		Room r = cmq.getCurrentRoom();
		String msg1 = "Command 's' did not return expected value";
		String msg2 = "Current room is incorrect (expected 0)";
		String exp = "A door in that direction does not exist.\n";
		assertEquals(msg1, exp, s);
		assertEquals(msg2, rooms.get(0), r);
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
		Mockito.when(player.getInventoryString()).thenReturn("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n\n");
		String s = cmq.processCommand("D");
		boolean b = cmq.isGameOver();
		String msg1 = "Command 'D' did not return expected value";
		String msg2 = "Game should be over, but it is not";
		String exp = "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n\nYou drink thin air and can only dream of coffee. You cannot study.\nYou lose!\n";
		assertEquals(msg1, exp, s);
		assertTrue(msg2, b);

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
		Mockito.when(player.getInventoryString()).thenReturn("You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.\n\n");
		String s = cmq.processCommand("D");
		boolean b = cmq.isGameOver();
		String msg1 = "Command 'D' did not return expected value.";
		String msg2 = "Game should be over, but it is not";
		String exp = "You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.\n\nYou drink the beverage and are ready to study!\nYou win!\n";
		assertEquals(msg1, exp, s);
		assertTrue(msg2, b);
	}

	// TODO: Put in more unit tests of your own making to improve coverage!

}
