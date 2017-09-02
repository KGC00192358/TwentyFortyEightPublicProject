package gameLogic;

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
	/**
	 * Constants this just makes directions so much easier to remember than just
	 * random numbers
	 */
	private int SOUTH = 0;
	private int NORTH = 2;
	private int EAST = 1;
	private int WEST = 3;

	public BoardReader()
	{

	}

	/**
	 * This method guess what would happen if a certain move is made. it
	 * intentionally ignores the added two, since that would be impossible to
	 * predict
	 * 
	 * @param dir
	 *            the direction to make the guess move
	 * @return
	 */
	public int[][] scanExpected(GameBoard b, int dir)
	{
		int[][] exp = new int[b.getPlayArea().length][b.getPlayArea().length];
		for (int i = 0; i < b.getPlayArea().length; i++)
		{
			for (int j = 0; j < b.getPlayArea().length; j++)
			{
				exp[i][j] = b.getPlayArea()[i][j];
			}

		}
		switch (dir)
		{
		case 0:
			guessMoveNumbersSouth(exp);
			break;
		case 1:
			guessMoveNumbersEast(exp);
			break;
		case 2:
			guessMoveNumbersNorth(exp);
			break;
		case 3:
			guessMoveNumbersWest(exp);
			break;

		}
		return exp;
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

	private void guessMoveNumbersSouth(int[][] a)
	{
		for (int i = a.length - 2; i >= 0; i--)
		{
			for (int j = a.length - 1; j >= 0; j--)
			{
				if (a[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInColumn(a, i, j, SOUTH) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInColumn(a, i, j, SOUTH) >= 6)
					{
						a[(findFarthestFreeOrEqualBlockInColumn(a, i, j, SOUTH) / 6)][j] = a[i][j] * 2;
						a[i][j] = 0;

					} else if (findFarthestFreeOrEqualBlockInColumn(a, i, j, SOUTH) < 6)
					{
						a[findFarthestFreeOrEqualBlockInColumn(a, i, j, SOUTH)][j] = a[i][j];
						a[i][j] = 0;
					}

				}
			}
		}
	}

	/**
	 * This makes a guess at a northern move. it functionally works the same way
	 * as the actual moveNorth method, except it does not call addTwo() and it
	 * works on a given array (copy of a). this is just to allow the computer a
	 * way to guess what the board impact of a move would be
	 * 
	 * @param a
	 *            the array to be operated on
	 */
	private void guessMoveNumbersNorth(int[][] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInColumn(a, i, j, NORTH) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInColumn(a, i, j, NORTH) >= 6)
					{
						a[((findFarthestFreeOrEqualBlockInColumn(a, i, j, NORTH) / 6) - 1)][j] = a[i][j] * 2;
						a[i][j] = 0;

					} else if (findFarthestFreeOrEqualBlockInColumn(a, i, j, NORTH) < 6)
					{
						a[(findFarthestFreeOrEqualBlockInColumn(a, i, j, NORTH))][j] = a[i][j];
						a[i][j] = 0;
					}
				}
			}
		}
	}

	private void guessMoveNumbersEast(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 1; j < a[i].length; j++)
			{
				if (a[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInRow(a, i, j, EAST) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInRow(a, i, j, EAST) >= 6)
					{
						a[i][(findFarthestFreeOrEqualBlockInRow(a, i, j, EAST) / 6) - 1] = a[i][j] * 2;															
					}
				}
			}
		}
	}

	private void guessMoveNumbersWest(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = a[i].length - 2; j > -1; j--)
			{
				if (a[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInRow(a, i, j, WEST) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInRow(a, i, j, WEST) >= 6)
					{
						a[i][(findFarthestFreeOrEqualBlockInRow(a, i, j, WEST) / 6)] = a[i][j] * 2;
						a[i][j] = 0;

					} else if (findFarthestFreeOrEqualBlockInRow(a, i, j, WEST) < 6)
					{
						a[i][findFarthestFreeOrEqualBlockInRow(a, i, j, WEST)] = a[i][j];
						a[i][j] = 0;
					}
				}
			}
		}
	}

	/**
	 * Scans the column of a given block and finds the farthest open or equal
	 * block in the given direction
	 * 
	 * @param a
	 *            the row
	 * @param b
	 *            the Column
	 * @param dir
	 *            the direction of scan
	 * @return the index of the second array(column position) where we will move
	 *         the number
	 * 
	 */
	private int findFarthestFreeOrEqualBlockInColumn(int[][] v, int a, int b, int dir)
	{
		if (dir == 0)
		{
			for (int i = 3; i > 0; i--)
			{
				if (v[i][b] == 0)
				{
					return i;
				}
				if (v[a][b] == v[i][b])
				{
					return i * 6;
				}
			}
		} else if (dir == 2)
		{
			for (int i = 0; i < v.length - 1; i++)
			{
				if (v[i][b] == 0)
				{
					return i;
				}
				if (v[a][b] == v[i][b])
				{
					return (i + 1) * 6;
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param a
	 *            the row
	 * @param b
	 *            the column
	 * @param dir
	 *            direction of scan
	 * @return the index of free block by row position or -1
	 */
	private int findFarthestFreeOrEqualBlockInRow(int[][] v, int a, int b, int dir)
	{
		if (dir == 1)
		{
			for (int i = 0; i < v[a].length; i++)
			{
				if (v[a][i] == 0)
				{
					return i;
				}
				if (v[a][i] == v[a][b])
				{
					return (i + 1) * 6;
				}
			}
		}
		for (int i = v[a].length - 1; i >= 1; i--)
		{
			if (v[a][i] == 0)
			{
				return i;
			}
			if (v[a][i] == v[a][b])
			{
				return (i) * 6;
			}
		}
		return -1;
	}
	public int getCurrentBoardValue(int[][] a)
	{
		int boardValue = 0;
		int blanks = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[j].length; j++)
			{
				boardValue = +a[i][j];
				if (a[i][j] == 0)
				{
					blanks++;
				}
			}
		}
		boardValue= boardValue*blanks;
		return boardValue;		
	}
	
	public int getCurrentBoardValue(GameBoard b)
	{
		int[][] a = new int[b.getPlayArea().length][b.getPlayArea().length];
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[j].length; j++)
			{
				a[i][j] = b.getPlayArea()[i][j];
			}
		}
		int boardValue = 0;
		int blanks = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[j].length; j++)
			{
				boardValue = +a[i][j];
				if (a[i][j] == 0)
				{
					blanks++;
				}
			}
		}
		boardValue= boardValue*blanks;
		return boardValue;		
	}

}
