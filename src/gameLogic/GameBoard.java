
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
	private final int NORTH = 2;
	private final int SOUTH = 0;
	private final int WEST = 3;
	private final int EAST = 1;

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
	 * spits out negative 1. TODO: make this more efficient;
	 */
	public int addTwo()
	{
		boolean empty = true;
		while (empty)
		{
			int a = (int) Math.random() * 3;
			int b = (int) Math.random() * 3;
			if (playArea[a][b] < 2)
			{
				playArea[a][b] = 2;
				empty = false;
				return 1;
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
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testColumn = i + 1; testColumn < playArea.length; testColumn++)
					{
						if (testColumn == 3)
						{
							if (playArea[testColumn][j] == playArea[i][j] && (lastFree > -1 || testColumn == i + 1))
							{
								playArea[testColumn][j] = 2 * playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							} else if (playArea[testColumn][j] == 0 && (lastFree > -1 || testColumn == i + 1))
							{
								playArea[testColumn][j] = playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							}
						} else if (playArea[testColumn][j] == 0 && (lastFree != -1 || testColumn == i + 1))
						{
							lastFree = testColumn;
						} else if (playArea[testColumn][j] == playArea[i][j] && (lastFree != -1 || testColumn == i + 1))
						{
							lastEqual = testColumn;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastFree > lastEqual)
						{
							playArea[lastFree][j] = playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual > lastFree)
						{
							playArea[lastEqual][j] = 2 * playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else // no move {
							moved = true;
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
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testColumn = i - 1; testColumn > -1; testColumn--)
					{
						if (testColumn == 0)
						{
							if (playArea[testColumn][j] == playArea[i][j] && (lastFree > -1 || testColumn == i - 1))
							{
								playArea[testColumn][j] = 2 * playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							} else if (playArea[testColumn][j] == 0 && (lastFree > -1 || testColumn == i - 1))
							{
								playArea[testColumn][j] = playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							}
						} else if (playArea[testColumn][j] == 0 && (lastFree != -1 || testColumn == i - 1))
						{
							lastFree = testColumn;
						} else if (playArea[testColumn][j] == playArea[i][j] && (lastFree != -1 || testColumn == i - 1))
						{
							lastEqual = testColumn;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastFree > lastEqual)
						{
							playArea[lastFree][j] = playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual > lastFree)
						{
							playArea[lastFree][j] = 2 * playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else // no move {
							moved = true;
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
	public void moveNumbersWest()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 1; j < playArea[i].length; j++)
			{
				if (playArea[i][j] > 0)
				{
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testRow = j - 1; testRow > -1; testRow--)
					{
						if (testRow == 0)
						{
							if (playArea[i][testRow] == playArea[i][j] && (lastFree != -1 || testRow == j - 1))
							{
								playArea[i][testRow] = 2 * playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							} else if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j - 1))
							{

								playArea[i][testRow] = playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							}
						} else if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j - 1))
						{
							lastFree = testRow;
						} else if (playArea[i][testRow] == playArea[i][j] && (lastFree != -1 || testRow == j - 1))
						{
							lastEqual = testRow;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastFree > lastEqual)
						{
							playArea[i][lastFree] = playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual > lastFree)
						{
							playArea[i][lastFree] = 2 * playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else // no move {
							moved = true;
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
	public void moveNumbersEast()
	{
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = playArea[i].length - 2; j > -1; j--)
			{
				if (playArea[i][j] > 0)
				{
					boolean moved = false;
					int lastFree = -1;
					int lastEqual = -1;
					for (int testRow = j + 1; testRow < playArea.length; testRow++)
					{
						if (testRow == 3)
						{
							if (playArea[i][testRow] == playArea[i][j] && (lastFree != -1 || testRow == j + 1))
							{
								playArea[i][testRow] = 2 * playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							} else if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j + 1))
							{

								playArea[i][testRow] = playArea[i][j];
								playArea[i][j] = 0;
								moved = true;
							}
						} else if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j + 1))
						{
							lastFree = testRow;
						} else if (playArea[i][testRow] == playArea[i][j] && (lastFree != -1 || testRow == j + 1))
						{
							lastEqual = testRow;
						}
					}
					if (!moved)
					{
						if (lastFree != -1 && lastFree > lastEqual)
						{
							playArea[i][lastFree] = playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else if (lastFree != -1 && lastEqual > lastFree)
						{
							playArea[i][lastEqual] = 2 * playArea[i][j];
							playArea[i][j] = 0;
							moved = true;
						} else
						{
							moved = true;
						}
					}
				}
			}
		}
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
	 *         block with 2048 but still space(0), there is no space, but a
	 *         single move in some direction will clear up at least one space,
	 *         or no space no 2048, and no single move will clear a space(-1
	 *         lose).
	 * 
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

		int[][] orginal = new int[4][4]; // this looks disgusting, but it allows
											// me to keep the original order of
											// the playArea intact
		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				orginal[i][j] = playArea[i][j];
			}
		}

		/*
		 * again, this is disgusting but it seems like the easiest way to do
		 * this without rewriting the entire board reader class. this moves the
		 * playArea in a direction, checks if the resulting board has space, and
		 * then resets it to the original position.
		 * 
		 */

		moveNumbersSouth();

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] == 0)
					return 0;
			}
		}

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				playArea[i][j] = orginal[i][j];
			}
		}

		moveNumbersNorth();

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] == 0)
					return 0;
			}
		}

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				playArea[i][j] = orginal[i][j];
			}
		}

		moveNumbersWest();

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] == 0)
					return 0;
			}
		}

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				playArea[i][j] = orginal[i][j];
			}
		}

		moveNumbersEast();

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				if (playArea[i][j] == 0)
					return 0;
			}
		}

		for (int i = 0; i < playArea.length; i++)
		{
			for (int j = 0; j < playArea[i].length; j++)
			{
				playArea[i][j] = orginal[i][j];
			}
		}

		return -1;
	}
}
