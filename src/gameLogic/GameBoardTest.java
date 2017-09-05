package gameLogic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest
{
	private int NORTH = 2;
	private int SOUTH = 0;
	private int WEST = 3;
	private int EAST = 1;

	////////////////////
	/// NORMAL PARAMS///
	////////////////////

	@Test
	public void testGameBoardMoveNumbersSouthOnce()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersSouth();
		int topExpected = 2;
		int actual = b.getPlayArea()[3][0];
		assertEquals(topExpected, actual);

	}

	@Test
	public void testGameBoardMoveNumbersSouthTwice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersSouth();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersSouth();
		int botExpected = 4;
		int botActual = b.getPlayArea()[3][0];
		assertEquals(botExpected, botActual);

	}

	@Test
	public void testGameBoardMoveNumbersSouthThrice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersSouth();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersSouth();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersSouth();
		int botExpected = 4;
		int midExpected = 2;
		int botActual = b.getPlayArea()[3][0];
		int midActual = b.getPlayArea()[2][0];
		assertEquals(botExpected, botActual);
		assertEquals(midExpected, midActual);
	}

	@Test
	public void testGameBoardMoveNumbersNorthOnce()
	{
		GameBoard b = new GameBoard();
		b.setPlayArea(3, 0, 2);
		b.setPlayArea(0, 0, 0);
		b.moveNumbersNorth();
		b.setPlayArea(3, 0, 2);
		int topExpected = 2;
		int topActual = b.getPlayArea()[0][0];
		assertEquals(topExpected, topActual);

	}

	@Test
	public void testGameBoardMoveNumbersNorthTwice()
	{
		GameBoard b = new GameBoard();
		b.setPlayArea(3, 0, 2);
		b.setPlayArea(0, 0, 0);
		b.moveNumbersNorth();
		b.setPlayArea(3, 0, 2);
		b.moveNumbersNorth();
		b.setPlayArea(3, 0, 2);
		int botExpected = 2;
		int topExpected = 4;
		int botActual = b.getPlayArea()[3][0];
		int topActual = b.getPlayArea()[0][0];
		assertEquals(topExpected, topActual);
		assertEquals(botExpected, botActual);

	}

	@Test
	public void testGameBoardMoveNumbersNorthThrice()
	{
		GameBoard b = new GameBoard();
		b.setPlayArea(3, 0, 2);
		b.setPlayArea(0, 0, 0);
		b.moveNumbersNorth();
		b.setPlayArea(3, 0, 2);
		b.moveNumbersNorth();
		b.setPlayArea(3, 0, 2);
		b.moveNumbersNorth();
		b.setPlayArea(3, 0, 2);
		int topExpected = 4;
		int botExpected = 2;
		int midExpected = 2;
		int botActual = b.getPlayArea()[3][0];
		int topActual = b.getPlayArea()[0][0];
		int midActual = b.getPlayArea()[1][0];
		assertEquals(topExpected, topActual);
		assertEquals(botExpected, botActual);
		assertEquals(midExpected, midActual);
	}

	@Test
	public void testGameBoardMoveNumbersEastOnce()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 0, 2);
		int eastExpected = 2;
		int eastActual = b.getPlayArea()[0][3];
		assertEquals(eastExpected, eastActual);

	}

	@Test
	public void testGameBoardMoveNumberEastTwice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 0, 2);
		int eastExpected = 4;
		int westExpected = 2;
		int eastActual = b.getPlayArea()[0][3];
		int westActual = b.getPlayArea()[0][0];
		assertEquals(westExpected, westActual);
		assertEquals(eastExpected, eastActual);

	}

	@Test
	public void testGameBoardMoveNumbersEastThrice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 0, 2);
		int westExpected = 4;
		int eastExpected = 2;
		int midExpected = 2;
		int westActual = b.getPlayArea()[0][3];
		int eastActual = b.getPlayArea()[0][0];
		int midActual = b.getPlayArea()[0][2];
		assertEquals(westExpected, westActual);
		assertEquals(eastExpected, eastActual);
		assertEquals(midExpected, midActual);
	}

	@Test
	public void testGameBoardMoveNumbersWestOnce()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 3, 2);
		int topExpected = 2;
		int actual = b.getPlayArea()[0][3];
		int topActual = b.getPlayArea()[0][0];
		assertEquals(topExpected, actual);
		assertEquals(topExpected, topActual);

	}

	@Test
	public void testGameBoardMoveNumberWestTwice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 3, 2);
		int westExpected = 2;
		int eastExpected = 4;
		int westActual = b.getPlayArea()[0][3];
		int eastActual = b.getPlayArea()[0][0];
		assertEquals(westExpected, westActual);
		assertEquals(eastExpected, eastActual);

	}

	@Test
	public void testGameBoardMoveNumbersWestThrice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 3, 2);
		int westExpected = 2;
		int eastExpected = 4;
		int midExpected = 2;
		int westActual = b.getPlayArea()[0][3];
		int eastActual = b.getPlayArea()[0][0];
		int midActual = b.getPlayArea()[0][1];
		assertEquals(westExpected, westActual);
		assertEquals(eastExpected, eastActual);
		assertEquals(midExpected, midActual);

	}

	@Test
	public void testCheckForWinLose()
	{
		GameBoard b = new GameBoard();
		int expected = 0;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
		expected = 1;
		b.setPlayArea(1, 3, 2048);
		actual = b.checkForWinLose();
		assertEquals(expected, actual);
		expected = 1;
		b.setPlayArea(1, 3, 2048);
		actual = b.checkForWinLose();
		assertEquals(expected, actual);

	}

	public void testCheckForWinLose2()
	{
		GameBoard b = new GameBoard();
		b.setPlayArea(2, 2, (2048 / 2));
		b.setPlayArea(2, 3, (2048 / 2));
		b.moveNumbersSouth();
		int expected = 1;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	
	
	////////////////
	//WEIRD BOARDS//
	////////////////
	
	@Test
	public void testCheckWinLoseFullBoardWithNoMove(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		//b.printBoard();
		int expected = -1;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	@Test
	public void testWestMovementForBugOnWeirdBoard() {
		GameBoard b = new GameBoard();
		b. clearBoard();
		b.setPlayArea(0, 2, 4);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(2, 2, 4);
		b.setPlayArea(2, 3, 2);
		b.setPlayArea(1, 1, 2);
		b.moveNumbersWest();
		int topWestExpected = 8;
		int secondTopWestExpected = 2;
		int thirdTopWestExpected = 2;
		int thirdTopThirdWestExpected = 4;
		int topWestActual = b.getPlayArea()[0][3];
		int secondTopWestActual = b.getPlayArea()[1][3];;
		int thirdTopWestActual = b.getPlayArea()[2][3];;
		int thirdTopThirdWestActual = b.getPlayArea()[2][2];;
		assertEquals(topWestExpected, topWestActual);
		assertEquals(secondTopWestExpected, secondTopWestActual);
		assertEquals(thirdTopWestExpected, thirdTopWestActual);
		assertEquals(thirdTopThirdWestExpected, thirdTopThirdWestActual);
	}
	
	@Test
	public void testNorthMovementForBugsOnWeirdBoard() {
		GameBoard b = new GameBoard();
		b. clearBoard();
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(2, 0, 2);
		b.moveNumbersNorth();
		int topExpected = 4;
		int secondTopExpected = 2;
		int topActual = b.getPlayArea()[0][0];
		int secondTopActual = b.getPlayArea()[1][0];
		assertEquals(topExpected, topActual);
		assertEquals(secondTopExpected, secondTopActual);
	}
	
	@Test 
	public void testCheckWinLoseOnSelfSimiliarBoard()
	{
		GameBoard b = new GameBoard();
		for (int i = 0; i < b.getPlayArea().length; i++)
		{
			for (int j = 0; j < b.getPlayArea()[i].length; j++)
			{
				b.setPlayArea(i, j, 2);
			}
		}
		int expected = 0;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testColumnIsClear1(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		boolean expected  = false;
		boolean actual = b.columnIsClear(0, 0, 3, 0, SOUTH);
		assertEquals(expected, actual);
	
	}
	@Test
	public void testColumnIsClear2(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(2, 0, 4);
		b.setPlayArea(3, 0, 2);
		boolean expected  = false;
		boolean actual = b.columnIsClear(3, 0, 0, 0, NORTH);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRowIsClear1(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 2, 4);
		b.setPlayArea(0, 3, 2);
		boolean expected  = false;
		boolean actual = b.rowIsClear(0, 3, 0, 0, WEST);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRowIsClear2(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 2, 4);
		b.setPlayArea(0, 3, 2);
		boolean expected  = false;
		boolean actual = b.rowIsClear(0, 0, 0, 3, EAST);
		assertEquals(expected, actual);
	}
	@Test
	public void testMoveSouthFullBoardWithNoMove(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		System.out.println("before south");
		b.printBoard();
		b.moveNumbersSouth();
		System.out.println("after");
		b.printBoard();
		int expected = -1;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMoveNorthFullBoardWithNoMove(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		System.out.println("before North");
		b.printBoard();
		b.moveNumbersNorth();
		System.out.println("after");
		b.printBoard();
		int expected = -1;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMoveWestFullBoardWithNoMove(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		System.out.println("before West");
		b.printBoard();
		b.moveNumbersWest();
		System.out.println("after");
		b.printBoard();
		int expected = -1;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	@Test
	public void testMoveEastFullBoardWithNoMove(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		System.out.println("before East");
		b.printBoard();
		b.moveNumbersEast();
		System.out.println("after");
		b.printBoard();
		int expected = -1;
		int actual = b.checkForWinLose();
		assertEquals(expected, actual);
	}
	@Test
	public void testRowIsClearFullBoardWithNoMove(){
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 4);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 4);
		b.setPlayArea(1, 0, 4);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(1, 2, 4);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 0, 2);
		b.setPlayArea(2, 1, 4);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(2, 3, 4);
		b.setPlayArea(3, 0, 4);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 4);
		b.setPlayArea(3, 3, 2);
		boolean expected = false;
		boolean actual = b.rowIsClear(0, 3, 0, 1, WEST);
		assertEquals(expected, actual);
		
	}
	
}
