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
		int[][] org = b.copyBoard();
		int[][] exp = b.copyBoard();
		switch (dir)
		{
		case 0:
			b.moveNumbersSouth();
			b.addTwo();
			exp = b.copyBoard();
			b.restoreBoard(org);
			return getCurrentBoardValue(exp);
		case 1:
			b.moveNumbersEast();
			b.addTwo();
			exp = b.copyBoard();
			b.restoreBoard(org);
			return getCurrentBoardValue(exp);
		case 2:
			b.moveNumbersNorth();
			b.addTwo();
			exp = b.copyBoard();
			b.restoreBoard(org);
			return getCurrentBoardValue(exp);
		case 3:
			b.moveNumbersWest();
			b.addTwo();
			exp = b.copyBoard();
			b.restoreBoard(org);
			return getCurrentBoardValue(exp);

		}
		return -1;
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
