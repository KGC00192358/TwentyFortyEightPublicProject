package gameLogic;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Player {
    private ArrayList<String> lines = new ArrayList<String>();
    private GameBoard b = new GameBoard();
    private BoardReader br = new BoardReader();

    public Player() {

    }

    public void play() {
        Path file = Paths.get("output.txt");
        boolean won = false;
        int pass = 1;
        while (!won && pass < 10001) {
            b.clearBoard();
            b.addTwo();
            lines.add("Game no: " + pass);
            int moves = 0;
            while (b.checkForWinLose() == 0) {
                String[] board = b.toStringArray();
                for (String line : board) {
                    lines.add(line);
                }
                lines.add("Game no: " + pass);
                lines.add("Moves: " + moves);
                moves++;
                lines.add(("Current Board Value: " + Integer.toString(br.getCurrentBoardValue(b))));
                int dir = pickMove();
                switch (dir) {
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
                case 5:
                    b.moveNumbersSouth();
                    lines.add("Default to DOWN");
                    lines.add("\n");
                    b.addTwo();
                    break;
                case 6:
                    b.moveNumbersSouth();
                    lines.add("Down at random");
                    lines.add("\n");
                    b.addTwo();
                    break;
                case 12:
                    b.moveNumbersEast();
                    lines.add("Right at random");
                    lines.add("\n");
                    b.addTwo();
                    break;
                case 18:
                    b.moveNumbersNorth();
                    lines.add("Up at random");
                    lines.add("\n");
                    b.addTwo();
                    break;
                case 24:
                    b.moveNumbersWest();
                    lines.add("Left at random");
                    lines.add("\n");
                    b.addTwo();
                    break;

                }
            }
            lines.add("\n");
            String[] board = b.toStringArray();
            for (String line : board) {
                lines.add(line);
            }
            if (b.checkForWinLose() == -1) {
                lines.add("lose");
            } else {
                lines.add("win");
                won = true;
            }
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pass++;
        }
    }

    private int pickMove() {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            switch (i) {
            case 0:
                // lines.add(("Board Value For Down: " +
                // Integer.toString(br.scanExpectedValue(b, i))));
                break;
            case 1:
                // lines.add(("Board Value For Right: " +
                // Integer.toString(br.scanExpectedValue(b, i))));
                break;
            case 2:
                // lines.add(("Board Value For Up: " +
                // Integer.toString(br.scanExpectedValue(b, i))));
                break;
            case 3:
                // lines.add(("Board Value For Left: " +
                // Integer.toString(br.scanExpectedValue(b, i))));
                break;
            }
            vals.add(br.scanExpectedValue(b, i));

        }
        if (countSameMaxValues(vals) > 1) {
            ArrayList<Integer> highMoves = findHighMoves(vals, new CompareIntAscending());
            Random r = new Random();
            int high = highMoves.size();
            int index = r.nextInt(high);
            int move = (highMoves.get(index) + 1) * 6;
            System.out.println("Index: " + index);
            System.out.println("Move: " + move);
            return move;
        }
        Comparator<Integer> c = new CompareIntAscending();
        return max(vals, c);
    }

    private int countSameMaxValues(ArrayList<Integer> a) {
        int sameMaxCount = 0;
        Iterator<Integer> itr = a.iterator();
        Comparator<Integer> c = new CompareIntAscending();
        int maxVal = Collections.max(a, c);
        int test;
        while (itr.hasNext()) {
            test = itr.next();
            if (test == maxVal) {
                sameMaxCount++;
            }
        }
        return sameMaxCount;
    }

    public <T> int max(Collection<T> coll, Comparator<T> comp) {
        try {
            coll.getClass();
            comp.getClass();
        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            throw new IllegalArgumentException();
        }
        if (coll.size() < 1) {
            throw new NoSuchElementException();
        }
        Iterator<T> itr = coll.iterator();
        T max = itr.next();
        T test;
        int i = 0;
        int pass = 0;
        while (itr.hasNext()) {
            test = itr.next();
            pass++;
            if (comp.compare(test, max) > 0) {
                max = test;
                i = pass;
            }
        }

        return i;
    }

    public <T> ArrayList<Integer> findHighMoves(Collection<T> coll, Comparator<T> c) {
        ArrayList<Integer> moves = new ArrayList<Integer>();
        T target = Collections.max(coll, c);
        int i = 0;
        for (T element : coll) {
            if (element == target) {
                moves.add(i);
            }
            i++;
        }

        return moves;
    }
/**
 * This is a method for finding the best possible path(read list of moves) to combo an element with another one of the same kind.
 * It is a modified version of the A* algorithm.
 * @param b the gameboard we are currently using();
 * @param comboTarget the number we want to combine
 * @return an arraylist containing the list of moves used to combine these two numbers.
 */
    public ArrayList<Integer> aStarSearchForMove(GameBoard b, int comboTarget) {
        ArrayList<Integer> moveList = new ArrayList<Integer>();

        return moveList;
    }
}
