package gameLogic;

import java.util.Random;

/**
 * 
 * @author Kevin Conyers
 * @version 0.0.1 This class allows me to easily read the current board state,
 *          as well as make a best guess as to what a board will look like after
 *          a given move.
 * 
 *          In the interest of simplifying my code, any method here that is
 *          intended to be called outside of this class thats a GameBoard
 *          object, while internal methods take an array[][]
 */
public class BoardReader
{
	public BoardReader()
	{

	}
	public int[][] addTwo(int[][] a)
	{
		boolean empty = true;
		while (empty)
		{
			Random r = new Random();
			int Low = 0;
			int High = 4;
			//int Result = r.nextInt(High-Low) + Low;
			int i = (int) r.nextInt(High-Low) + Low;
			int j = (int) r.nextInt(High-Low) + Low;
			if (a[i][j] < 2)
			{
				a[i][j] = 2;
				empty = false;
			}
		}

		return a;

	}
	/**
	 * This method guess what would happen if a certain move is made. it
	 * intentionally ignores the added two, since that would be impossible to
	 * predict
	 * 
	 * @param dir
	 *            the direction to make the guess move
	 * @return the value after the given move. or -1 if something is horribly screwy
	 * 
	 */
	public int scanExpectedValue(GameBoard b, int dir)
	{
		int[][] exp = b.copyBoard();
		switch (dir)
		{
		case 0:
			exp = guessMoveNumbersSouth(exp);
			addTwo(exp);
			return getCurrentBoardValue(exp);
		case 1:
			exp = guessMoveNumbersEast(exp);
			addTwo(exp);
			return getCurrentBoardValue(exp);
		case 2:
			exp = guessMoveNumbersNorth(exp);
			addTwo(exp);
			return getCurrentBoardValue(exp);
		case 3:
			exp = guessMoveNumbersWest(exp);
			addTwo(exp);
			return getCurrentBoardValue(exp);

		}
		return -1;
	}
	

	/**
	 * This makes a guess at a southern move. it functionally works the same way
	 * as the actual moveSouth method, except it does not call addTwo() and it
	 * works on a given array (copy of a). this is just to allow the computer a
	 * way to guess what the board impact of a move would be
	 * 
	 * @param a
	 *            the array to be operated on
	 */
	public int[][] guessMoveNumbersSouth(int[][] a)
	{
		for (int i = a.length - 2; i >= 0; i--)
		{
			for (int j = a.length - 1; j >= 0; j--)
			{
				if (a[i][j] > 0)
				{
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testColumn = i + 1; testColumn < a.length; testColumn++)
					{
						if (testColumn == 3)
						{
							if (a[testColumn][j] == a[i][j] && (lastFree > -1 || testColumn == i + 1))
							{
								a[testColumn][j] = 2 * a[i][j];
								a[i][j] = 0;
								moved = true;
							} else if (a[testColumn][j] == 0 && (lastFree > -1 || testColumn == i + 1))
							{
								a[testColumn][j] = a[i][j];
								a[i][j] = 0;
								moved = true;
							}
						} else if (a[testColumn][j] == 0 && (lastFree != -1 || testColumn == i + 1))
						{
							lastFree = testColumn;
						} else if (a[testColumn][j] == a[i][j] && (lastFree != -1 || testColumn == i + 1))
						{
							lastEqual = testColumn;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastEqual == -1)
						{
							a[lastFree][j] = a[i][j];
							a[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual > lastFree)
						{
							a[lastEqual][j] = 2 * a[i][j];
							a[i][j] = 0;
							moved = true;
						} else // no move {
							moved = true;
					}
				}
			}
		}
		return a;
	}

	/**
	 * Scans all numbers starting at the second row moves them into the farthest
	 * available block on the board in their column multiplies by 2 as necessary
	 * 
	 */
	public int[][] guessMoveNumbersNorth(int[][] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j] > 0)
				{
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testColumn = i - 1; testColumn > -1; testColumn--)
					{
						if (testColumn == 0)
						{
							if (a[testColumn][j] == a[i][j] && (lastFree > -1 || testColumn == i - 1))
							{
								a[testColumn][j] = 2 * a[i][j];
								a[i][j] = 0;
								moved = true;
							} else if (a[testColumn][j] == 0 && (lastFree > -1 || testColumn == i - 1))
							{
								a[testColumn][j] = a[i][j];
								a[i][j] = 0;
								moved = true;
							}
						} else if (a[testColumn][j] == 0 && (lastFree != -1 || testColumn == i - 1))
						{
							lastFree = testColumn;
						} else if (a[testColumn][j] == a[i][j] && (lastFree != -1 || testColumn == i - 1))
						{
							lastEqual = testColumn;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastEqual == -1)
						{
							a[lastFree][j] = a[i][j];
							a[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual < lastFree)
						{
							a[lastEqual][j] = 2 * a[i][j];
							a[i][j] = 0;
							moved = true;
						} else // no move {
							moved = true;
					}

				}
			}
		}
		return a;
	}

	/**
	 * scans all columns starting from the second moves them to farthest
	 * available block in that row multiply by 2 as necessary
	 * 
	 */
	public int[][] guessMoveNumbersWest(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 1; j < a[i].length; j++)
			{
				if (a[i][j] > 0)
				{
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testRow = j - 1; testRow > -1; testRow--)
					{
						if (testRow == 0)
						{
							if (a[i][testRow] == a[i][j] && (lastFree != -1 || testRow == j - 1))
							{
								a[i][testRow] = 2 * a[i][j];
								a[i][j] = 0;
								moved = true;
							} else if (a[i][testRow] == 0 && (lastFree != -1 || testRow == j - 1))
							{

								a[i][testRow] = a[i][j];
								a[i][j] = 0;
								moved = true;
							}
						} else if (a[i][testRow] == 0 && (lastFree != -1 || testRow == j - 1))
						{
							lastFree = testRow;
						} else if (a[i][testRow] == a[i][j] && (lastFree != -1 || testRow == j - 1))
						{
							lastEqual = testRow;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastEqual == -1)
						{
							a[i][lastFree] = a[i][j];
							a[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual < lastFree)
						{
							a[i][lastEqual] = 2 * a[i][j];
							a[i][j] = 0;
							moved = true;
						} else // no move {
							moved = true;
					}
				}
			}
		}
		return a;
	}

	/**
	 * scans all columns starting from the second to last moves them to farthest
	 * available block in that row multiply by 2 as necessary
	 * 
	 */
	public int[][] guessMoveNumbersEast(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = a[i].length - 2; j > -1; j--)
			{
				if (a[i][j] > 0)
				{
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testRow = j + 1; testRow < a.length; testRow++)
					{
						if (testRow == 3)
						{
							if (a[i][testRow] == a[i][j] && (lastFree != -1 || testRow == j + 1))
							{
								a[i][testRow] = 2 * a[i][j];
								a[i][j] = 0;
								moved = true;
							} else if (a[i][testRow] == 0 && (lastFree != -1 || testRow == j + 1))
							{

								a[i][testRow] = a[i][j];
								a[i][j] = 0;
								moved = true;
							}
						} else if (a[i][testRow] == 0 && (lastFree != -1 || testRow == j + 1))
						{
							lastFree = testRow;
						} else if (a[i][testRow] == a[i][j] && (lastFree != -1 || testRow == j + 1))
						{
							lastEqual = testRow;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastEqual == -1)
						{
							a[i][lastFree] = a[i][j];
							a[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual > lastFree)
						{
							a[i][lastEqual] = 2 * a[i][j];
							a[i][j] = 0;
							moved = true;
						} else
						{
							moved = true;
						}
					}
				}
			}
		}
		return a;
	}

	
	/**
	 * This returns a value that is related to the numbers on the board and the amount of free space.
	 * Since the total value of all the non-zero numbers increases by two every turn, I needed some other way to 
	 * calculate which board states were more valuable.
	 * I decided to multiple the total number value of a given board by the number of free spaces, which increases more if you free up space by combining numbers
	 * (if you align two numbers, that go into a single space, thereby negating the space taken up by the two so there is a net change of 0 free spaces.
	 * so for a board with a 2 and a 2 on the bottom row, its value is (2+2)*(16-2) = 56, then is you move the twos to the left you get a board of 4 on the 
	 * bottom and a two in any spot so the value is (4+2)*(16-2) = 84, however if you move the twos up[not combining] you have a new board value of (2+2+2)*(16-3) = 78)
	 * following this logic, we should be able to determine a "best move" by picking the one which results in a higher board value.
	 * Keep in mind, this does not account for boards like [4][2][0][2] because an up or down move would yield the highest board value (8+4+2+2)(16-4) = 192 
	 * 													   [0][0][0][0] however one move to the right gives the board a value of (4+4+4+2+2)(16-5) = 154
	 * 													   [4][2][0][0]	   but that board        [0][0][4][4] and is 4moves away from a value of ()	 			     										                                                 [0][0][0][0]
	 * 													   [0][0][0][0]    looks like this       [0][2][0][0] (16 + 2 + 2 + 2)(16-4) = 264 which is much larger
	 * @param a an array that is a copy of the board being operated on                           [0][0][4][2]
	 * @return the board value                                                                   [0][0][0][0]
	 */
	public int getCurrentBoardValue(int[][] a)
	{
		int boardValue = 0;
		int blanks = 0;
		int numberValue = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				numberValue = numberValue + a[i][j];
				if (a[i][j] == 0)
				{
					blanks++;
				}
			}
		}
		boardValue = numberValue*blanks;
		return boardValue;		
	}
	
	
	
	public int getCurrentBoardValue(GameBoard b)
	{
		int[][] a = new int[b.getPlayArea().length][b.getPlayArea().length];
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				a[i][j] = b.getPlayArea()[i][j];
			}
		}
		int boardValue = 0;
		int numberValue = 0;
		int blanks = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				numberValue = numberValue + a[i][j];
				if (a[i][j] == 0)
				{
					blanks++;
				}
			}
		}
		boardValue= numberValue*blanks;
		return boardValue;		
	}
	
}
