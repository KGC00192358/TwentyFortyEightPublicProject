package gameLogic;

import java.io.*;

public class Player
{

	public static void main(String[] args)
	{
		try
		{
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(
					"C:\\Users\\wolfg\\OneDrive\\n beclipseWorkpaceJava\\TwentyFortyEight\\output.txt"))));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GameBoard b = new GameBoard();
		BoardReader br = new BoardReader();
		while (b.checkForWinLose() == 0)
		{
			b.printBoard();
			System.out.println(br.getCurrentBoardValue(b));
			int dir = -1;
			int prevBoardValue = br.getCurrentBoardValue(b);
			for (int i = 0; i < 4; i++)
			{
				if (br.scanExpectedValue(b, i) >= prevBoardValue)
				{
					dir = i;
					prevBoardValue = br.scanExpectedValue(b, i);
				}
			}
			switch (dir)
			{
			case 0:
				b.moveNumbersSouth();
				System.out.println("DOWN");
				System.out.println();
				b.addTwo();
				break;
			case 1:
				b.moveNumbersEast();
				System.out.println("RIGHT");
				System.out.println();
				b.addTwo();
				break;
			case 2:
				b.moveNumbersNorth();
				System.out.println("UP");
				System.out.println();
				b.addTwo();
				break;
			case 3:
				b.moveNumbersWest();
				System.out.println("LEFT");
				System.out.println();
				b.addTwo();
				break;
			default:
				b.moveNumbersSouth();
				System.out.println("Default to DOWN");
				System.out.println();
				b.addTwo();

			}
		}
		System.out.println();
		b.printBoard();
		if (b.checkForWinLose() == -1) {
			System.out.println("lose");
		} else {
			System.out.println("win");
		}

	}

}
