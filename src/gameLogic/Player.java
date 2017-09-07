package gameLogic;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Player
{

	public static void main(String[] args)
	{
		ArrayList<String> lines = new ArrayList<String>();
		Path file = Paths.get("output.txt");
		GameBoard b = new GameBoard();
		BoardReader br = new BoardReader();
		while (b.checkForWinLose() == 0)
		{
			String[] board = b.toStringArray();
			for(String line: board){
				lines.add(line);	
			}
			 lines.add((Integer.toString(br.getCurrentBoardValue(b))));
			int dir = -1;
			int prevBoardValue = br.getCurrentBoardValue(b);
			for (int i = 0; i < 4; i++)
			{
				if (br.scanExpectedValue(b, i) > prevBoardValue)
				{
					dir = i;
					prevBoardValue = br.scanExpectedValue(b, i);
				}
			}
			switch (dir)
			{
			case 0:
				b.moveNumbersSouth();
				lines.add("DOWN");
				lines.add("\n");
				b.addTwo();
				break;
			case 1:
				b.moveNumbersEast();
				lines.add("right");
				lines.add("\n");
				b.addTwo();
				break;
			case 2:
				b.moveNumbersNorth();
				lines.add("up");
				lines.add("\n");
				b.addTwo();
				break;
			case 3:
				b.moveNumbersWest();
				lines.add("Left");
				lines.add("\n");
				b.addTwo();
				break;
			default:
				b.moveNumbersSouth();
				lines.add("Default to DOWN");
				lines.add("\n");
				b.addTwo();

			}
		}
		lines.add("\n");
		String[] board = b.toStringArray();
		for(String line: board){
			lines.add(line);	
		}
		if (b.checkForWinLose() == -1) {
			lines.add("lose");
		} else {
			lines.add("win");
		}
		try
		{
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
