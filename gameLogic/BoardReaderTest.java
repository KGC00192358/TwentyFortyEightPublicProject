package gameLogic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardReaderTest
{
	private int NORTH = 2;
	private int SOUTH = 0;
	private int WEST = 3;
	private int EAST = 1;
	GameBoard b = new GameBoard();
	BoardReader r = new BoardReader();

	@Test
	public void testScanExpectedSouthMovement1()
	{
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(0, 1, 2);
		b.setPlayArea(0, 2, 2);
		b.setPlayArea(0, 3, 2);
		int[][] expected = new int[4][4];
		expected[3][0] = 2;
		expected[3][1] = 2;
		expected[3][2] = 2;
		expected[3][3] = 2;
		int[][] actual = r.scanExpected(b, SOUTH);
		assertEquals(expected[3][0], actual[3][0]);
		assertEquals(expected[3][1], actual[3][1]);
		assertEquals(expected[3][2], actual[3][2]);
		assertEquals(expected[3][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedSouthMovement2()
	{
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		int[][] expected = new int[4][4];
		expected[3][0] = 2;
		expected[3][1] = 2;
		expected[3][2] = 2;
		expected[3][3] = 2;
		int[][] actual = r.scanExpected(b, SOUTH);
		assertEquals(expected[3][0], actual[3][0]);
		assertEquals(expected[3][1], actual[3][1]);
		assertEquals(expected[3][2], actual[3][2]);
		assertEquals(expected[3][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedSouthMovement3()
	{
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		b.setPlayArea(3, 2, 2);
		int[][] expected = new int[4][4];
		expected[3][0] = 2;
		expected[3][1] = 2;
		expected[3][2] = 4;
		expected[3][3] = 2;
		int[][] actual = r.scanExpected(b, SOUTH);
		assertEquals(expected[3][0], actual[3][0]);
		assertEquals(expected[3][1], actual[3][1]);
		assertEquals(expected[3][2], actual[3][2]);
		assertEquals(expected[3][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedNorthMovement1()
	{
		b.setPlayArea(0, 0, 0);
		b.setPlayArea(3, 0, 2);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 2);
		b.setPlayArea(3, 3, 2);
		int[][] expected = new int[4][4];
		expected[0][0] = 2;
		expected[0][1] = 2;
		expected[0][2] = 2;
		expected[0][3] = 2;
		int[][] actual = r.scanExpected(b, NORTH);
		assertEquals(expected[0][0], actual[3][0]);
		assertEquals(expected[0][1], actual[3][1]);
		assertEquals(expected[0][2], actual[3][2]);
		assertEquals(expected[0][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedNorthMovement2()
	{
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		int[][] expected = new int[4][4];
		expected[0][0] = 2;
		expected[0][1] = 2;
		expected[0][2] = 2;
		expected[0][3] = 2;
		int[][] actual = r.scanExpected(b, NORTH);
		assertEquals(expected[0][0], actual[3][0]);
		assertEquals(expected[0][1], actual[3][1]);
		assertEquals(expected[0][2], actual[3][2]);
		assertEquals(expected[0][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedNorthMovement3()
	{
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		b.setPlayArea(3, 2, 2);
		int[][] expected = new int[4][4];
		expected[0][0] = 2;
		expected[0][1] = 2;
		expected[0][2] = 4;
		expected[0][3] = 2;
		int[][] actual = r.scanExpected(b, NORTH);
		assertEquals(expected[0][0], actual[3][0]);
		assertEquals(expected[0][1], actual[3][1]);
		assertEquals(expected[0][2], actual[3][2]);
		assertEquals(expected[0][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedEastMovement1()
	{
		b.clearBoard();
		b.setPlayArea(0, 3, 2);
		b.setPlayArea(1, 3, 2);
		b.setPlayArea(2, 3, 2);
		b.setPlayArea(3, 3, 2);
		int[][] expected = new int[4][4];
		expected[0][0] = 2;
		expected[1][0] = 2;
		expected[2][0] = 2;
		expected[3][0] = 2;
		int[][] actual = r.scanExpected(b, EAST);
		assertEquals(expected[0][0], actual[0][0]);
		assertEquals(expected[1][0], actual[1][0]);
		assertEquals(expected[2][0], actual[2][0]);
		assertEquals(expected[3][0], actual[3][0]);
	}

	@Test
	public void testScanExpectedEastMovement2()
	{
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		int[][] expected = new int[4][4];
		expected[0][0] = 2;
		expected[1][0] = 2;
		expected[2][0] = 2;
		expected[3][0] = 2;
		int[][] actual = r.scanExpected(b, EAST);
		assertEquals(expected[0][0], actual[0][0]);
		assertEquals(expected[1][0], actual[1][0]);
		assertEquals(expected[2][0], actual[2][0]);
		assertEquals(expected[3][0], actual[3][0]);
	}

	@Test
	public void testScanExpectedEastMovement3()
	{
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		b.setPlayArea(3, 2, 2);
		int[][] expected = new int[4][4];
		expected[0][0] = 2;
		expected[1][0] = 2;
		expected[2][0] = 2;
		expected[3][0] = 4;
		int[][] actual = r.scanExpected(b, EAST);
		// b.printBoard();
		assertEquals(expected[0][0], actual[0][0]);
		assertEquals(expected[1][0], actual[1][0]);
		assertEquals(expected[2][0], actual[2][0]);
		assertEquals(expected[3][0], actual[3][0]);
	}

	@Test
	public void testScanExpectedWestMovement1()
	{
		b.clearBoard();
		b.setPlayArea(0, 0, 0);
		b.setPlayArea(3, 0, 2);
		b.setPlayArea(3, 1, 2);
		b.setPlayArea(3, 2, 2);
		b.setPlayArea(3, 3, 2);
		System.out.println("Current Board");
		b.printBoard();
		System.out.println("After Move West");
		int[][] expected = new int[4][4];
		expected[3][0] = 0;
		expected[3][1] = 0;
		expected[0][2] = 4;
		expected[0][3] = 4;
		int[][] actual = r.scanExpected(b, WEST);
		printArray(actual);
		assertEquals(expected[0][0], actual[3][0]);
		assertEquals(expected[0][1], actual[3][1]);
		assertEquals(expected[0][2], actual[3][2]);
		assertEquals(expected[0][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedWestMovement2()
	{
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		System.out.println("Current Board");
		b.printBoard();
		System.out.println("After Move West");
		int[][] expected = new int[4][4];
		expected[0][3] = 2;
		expected[1][3] = 2;
		expected[2][3] = 2;
		expected[3][3] = 2;
		int[][] actual = r.scanExpected(b, WEST);
		printArray(actual);
		assertEquals(expected[0][3], actual[0][3]);
		assertEquals(expected[1][3], actual[1][3]);
		assertEquals(expected[2][3], actual[2][3]);
		assertEquals(expected[3][3], actual[3][3]);
	}

	@Test
	public void testScanExpectedWestMovement3()
	{
		b.clearBoard();
		b.setPlayArea(0, 0, 2);
		b.setPlayArea(1, 1, 2);
		b.setPlayArea(2, 2, 2);
		b.setPlayArea(3, 3, 2);
		b.setPlayArea(3, 2, 2);
		System.out.println("Current Board");
		b.printBoard();
		System.out.println("After Move West");
		int[][] expected = new int[4][4];
		expected[0][3] = 2;
		expected[1][3] = 2;
		expected[2][3] = 2;
		expected[3][3] = 4;
		int[][] actual = r.scanExpected(b, WEST);
		printArray(actual);
		assertEquals(expected[1][3], actual[0][3]);
		assertEquals(expected[1][3], actual[1][3]);
		assertEquals(expected[2][3], actual[2][3]);
		assertEquals(expected[3][3], actual[3][3]);
	}

	public void printArray(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				System.out.print("[" + a[i][j] + "]");
			}
			System.out.println();
		}
	}
}
