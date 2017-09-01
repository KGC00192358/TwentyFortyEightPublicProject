package gameLogic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest
{

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
	public void testGameBoardMoveNumbersWestOnce()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 0, 2);
		int westExpected = 2;
		int westActual = b.getPlayArea()[0][3];
		assertEquals(westExpected, westActual);

	}

	@Test
	public void testGameBoardMoveNumberWestTwice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 0, 2);
		b.moveNumbersWest();
		b.setPlayArea(0, 0, 2);
		int westExpected = 4;
		int eastExpected = 2;
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
	public void testGameBoardMoveNumbersEastOnce()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 3, 2);
		int topExpected = 2;
		int actual = b.getPlayArea()[0][3];
		int topActual = b.getPlayArea()[0][0];
		assertEquals(topExpected, actual);
		assertEquals(topExpected, topActual);

	}

	@Test
	public void testGameBoardMoveNumberEastTwice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 3, 2);
		int westExpected = 2;
		int eastExpected = 4;
		int westActual = b.getPlayArea()[0][3];
		int eastActual = b.getPlayArea()[0][0];
		assertEquals(westExpected, westActual);
		assertEquals(eastExpected, eastActual);

	}

	@Test
	public void testGameBoardMoveNumbersEastThrice()
	{
		GameBoard b = new GameBoard();
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersEast();
		b.setPlayArea(0, 3, 2);
		b.moveNumbersEast();
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
		for (int i = 0; i < b.getPlayArea().length; i++)
		{
			for (int j = 0; j < b.getPlayArea()[i].length; j++)
			{
				b.setPlayArea(i, j, 2);
			}
		}
		expected = -1;
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

}
