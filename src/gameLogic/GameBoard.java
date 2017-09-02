
package gameLogic;

/**
 * 
 * @author Kevin Conyers
 * @version 0.0.1
 *
 */
public class GameBoard
{
	/**
	 * Fields
	 */
	private int[][] playArea = new int[4][4];
	/**
	 * Constants(easy direction)
	 */
	private int NORTH = 2;
	private int SOUTH = 0;
	private int WEST = 3;
	private int EAST = 1;

	/**
	 * Constructor
	 */
	public GameBoard()
	{
		makePlayArea();
		addTwo();
	}

	public int[][] getPlayArea()
	{
		return playArea;
	}

	public void setPlayArea(int i, int j, int val)
	{
		playArea[i][j] = val;
	}

	public void makePlayArea()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea.length; j++)
			{
				playArea[i][j] = 0;
			}
		}
	}

	/**
	 * Adds a two to a place on the game board, if it fails to find a spot,
	 * spits out negative 1. TODO: make this actually random, this is too
	 * formulaic for the intent of this project.
	 */
	public int addTwo()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea.length; j++)
			{
				if (playArea[i][j] == 0)
				{
					playArea[i][j] = 2;
					return 1;
				}

			}
		}
		return -1;

	}

	/**
	 * Scans all numbers starting at the second to last row moves them into the
	 * farthest available block on the board in their column multiplies by 2 as
	 * necessary
	 */
	public void moveNumbersSouth()
	{
		for (int i = playArea.length - 2; i >= 0; i--)
		{
			for (int j = playArea.length - 1; j >= 0; j--)
			{
				if (playArea[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInColumn(i, j, SOUTH) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInColumn(i, j, SOUTH) >= 6)
					{
						playArea[(findFarthestFreeOrEqualBlockInColumn(i, j, SOUTH) / 6)][j] = playArea[i][j] * 2;
						playArea[i][j] = 0;

					} else if (findFarthestFreeOrEqualBlockInColumn(i, j, SOUTH) < 6)
					{
						playArea[findFarthestFreeOrEqualBlockInColumn(i, j, SOUTH)][j] = playArea[i][j];
						playArea[i][j] = 0;
					}

				}
			}
		}
	}

	/**
	 * Scans all numbers starting at the second row moves them into the farthest
	 * available block on the board in their column multiplies by 2 as necessary
	 * 
	 */
	public void moveNumbersNorth()
	{
		for (int i = 1; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInColumn(i, j, NORTH) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInColumn(i, j, NORTH) >= 6)
					{
						playArea[(findFarthestFreeOrEqualBlockInColumn(i, j, NORTH) / 6) - 1][j] = playArea[i][j] * 2;
						playArea[i][j] = 0;

					} else if (findFarthestFreeOrEqualBlockInColumn(i, j, NORTH) < 6)
					{
						playArea[findFarthestFreeOrEqualBlockInColumn(i, j, NORTH)][j] = playArea[i][j];
						playArea[i][j] = 0;
					}
				}
			}
		}
	}

	/**
	 * scans all columns starting from the second moves them to farthest
	 * available block in that row multiply by 2 as necessary
	 * 
	 */
	public void moveNumbersEast()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 1; j < playArea[i].length; j++)
			{
				if (playArea[i][j] > 0)
				{
					if (findFarthestFreeOrEqualBlockInRow(i, j, EAST) == -1)
					{
						break;
					}
					if (findFarthestFreeOrEqualBlockInRow(i, j, EAST) >= 6)
					{
						playArea[i][(findFarthestFreeOrEqualBlockInRow(i, j, EAST) / 6) - 1] = playArea[i][j] * 2;
						playArea[i][j] = 0;

					} else if (findFarthestFreeOrEqualBlockInRow(i, j, EAST) < 6)
					{
						playArea[i][findFarthestFreeOrEqualBlockInRow(i, j, EAST)] = playArea[i][j];
						playArea[i][j] = 0;
					}
				}
			}
		}
	}

	/**
	 * scans all columns starting from the second to last moves them to farthest
	 * available block in that row multiply by 2 as necessary
	 * 
	 */
	public void moveNumbersWest()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = playArea[i].length - 2; j > -1; j--)
			{
				if (playArea[i][j] > 0)
				{
					int freeval = findFarthestFreeOrEqualBlockInRow(i, j, WEST);
					if (freeval == -1)
					{
						break;
					}
					if (freeval >= 6)
					{
						playArea[i][(freeval / 6)] = playArea[i][j] * 2;
						playArea[i][j] = 0;

					} else if (freeval < 6)
					{
						playArea[i][freeval] = playArea[i][j];
						playArea[i][j] = 0;
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
	public int findFarthestFreeOrEqualBlockInColumn(int a, int b, int dir)
	{
		if (dir == SOUTH)
		{
			for (int i = 3; i > 0; i--)
			{
				if (playArea[i][b] == 0)
				{
					return i;
				}
				if (i != b && playArea[a][b] == playArea[i][b])
				{
					return i * 6;
				}
			}
		}
		for (int i = 0; i < playArea.length - 1; i++)
		{
			if (playArea[i][b] == 0)
			{
				return i;
			}
			if ( i != b && playArea[a][b] == playArea[i][b])
			{
				return (i + 1) * 6;
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
	 *            the direction of scan
	 * @return the index of the free block by column position, or negative 1 if
	 *         no move is possible
	 */
	public int findFarthestFreeOrEqualBlockInRow(int a, int b, int dir)
	{
		if (dir == EAST)
		{
			for (int i = 0; i < playArea[a].length; i++)
			{
				if (playArea[a][i] == 0)
				{
					return i;
				}
				if (i != b && playArea[a][i] == playArea[a][b])
				{
					return (i + 1) * 6;
				}
			}
		}
		for (int i = playArea[a].length - 1; i > 0; i--)
		{
			if (playArea[a][i] == 0)
			{
				return i;
			}
			if ( i != b && playArea[a][i] == playArea[a][b] )
			{
				return (i) * 6;
			}
		}
		return -1;
	}

	public void printBoard()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				System.out.print("[" + playArea[i][j] + "]");
			}
			System.out.println();

		}
	}

	public void clearBoard()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				playArea[i][j] = 0;
				;
			}
		}
	}

	/**
	 * Checks for win/lose conditions
	 * 
	 * @return 1, 0, or -1 depending on if there is a block == 2048(1 win), no
	 *         block with 2048 but still space(0), or no space and no 2048(-1
	 *         lose).
	 */
	public int checkForWinLose()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] == 2048)
					return 1;
			}
		}
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] == 0)
					return 0;
			}
		}
		return -1;
	}
}
