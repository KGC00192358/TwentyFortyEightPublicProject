
package gameLogic;

import java.util.Random;

/**
 * 
 * @author Kevin Conyers
 * @version 0.0.1
 *
 */
public class GameBoard {
    /**
     * Fields
     */
    private int[][] playArea = new int[4][4];

    /**
     * Constructor
     */
    public GameBoard() {
        makePlayArea();
        addTwo();
    }

    public int[][] getPlayArea() {
        return playArea;
    }

    public void setPlayArea(int i, int j, int val) {
        playArea[i][j] = val;
    }

    public void makePlayArea() {
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea.length; j++) {
                playArea[i][j] = 0;
            }
        }
    }

    /**
     * Adds a two to a place on the game board, if it fails to find a spot,
     * spits out negative 1. TODO: make this more efficient;
     */
    public int addTwo() {
        boolean empty = true;
        while (empty) {
            Random r = new Random();
            int Low = 0;
            int High = 4;
            // int Result = r.nextInt(High-Low) + Low;
            int a = (int) r.nextInt(High - Low) + Low;
            int b = (int) r.nextInt(High - Low) + Low;
            if (playArea[a][b] < 2) {
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
    public void moveNumbersSouth() {
        boolean[][] multiplied = { { false, false, false, false }, { false, false, false, false },
                { false, false, false, false }, { false, false, false, false } };
        for (int i = playArea.length - 2; i >= 0; i--) {
            for (int j = playArea.length - 1; j >= 0; j--) {
                if (playArea[i][j] > 0) {
                    boolean moved = false;
                    int lastFree = -1;
                    int lastEqual = -1;
                    boolean clear = true;
                    for (int testColumn = i + 1; testColumn < playArea.length; testColumn++) {
                        
                        if (playArea[testColumn][j] == 0 && (lastFree != -1 || testColumn == i + 1)) {
                            lastFree = testColumn;
                        }

                        if (playArea[testColumn][j] == playArea[i][j] && (lastFree != -1 || testColumn == i + 1)) {
                            lastEqual = testColumn;
                        }
                        if (playArea[testColumn][j] != 0 && testColumn < 3) {
                            clear = false;
                        }
                        if (testColumn == 3) {
                            if (playArea[testColumn][j] == playArea[i][j]
                                    && (lastFree == lastEqual - 1 || testColumn == i + 1)
                                    && !multiplied[testColumn][j]) {
                                playArea[testColumn][j] = 2 * playArea[i][j];
                                playArea[i][j] = 0;
                                multiplied[testColumn][j] = true;
                                moved = true;
                            } else if (playArea[testColumn][j] == 0 && (lastFree > -1 || testColumn == i + 1)) {
                                playArea[testColumn][j] = playArea[i][j];
                                playArea[i][j] = 0;
                                moved = true;
                            }
                        }
                    }
                    if (!moved) {
                        if ((lastFree != -1 && lastEqual > lastFree || lastEqual == i + 1)
                                && !multiplied[lastEqual][j]) {
                            playArea[lastEqual][j] = 2 * playArea[i][j];
                            playArea[i][j] = 0;
                            multiplied[lastEqual][j] = true;
                            moved = true;
                        } else if (lastFree != -1) {
                            playArea[lastFree][j] = playArea[i][j];
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
    public void moveNumbersNorth() {
        boolean[][] multiplied = { { false, false, false, false }, { false, false, false, false },
                { false, false, false, false }, { false, false, false, false } };
        for (int i = 1; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] > 0) {
                    boolean moved = false;
                    int lastFree = -1;
                    int lastEqual = -1;
                    boolean clear = true;
                    for (int testColumn = i - 1; testColumn > -1; testColumn--) {
                       
                        if (playArea[testColumn][j] == 0 && (lastFree != -1 || testColumn == i - 1)) {
                            lastFree = testColumn;
                        }
                        if (playArea[testColumn][j] == playArea[i][j] && (lastFree != -1 || testColumn == i - 1)) {
                            lastEqual = testColumn;
                        }
                        if (playArea[testColumn][j] != 0 && testColumn > 0) {
                            clear = false;
                        }
                        if (testColumn == 0) {
                            if (playArea[testColumn][j] == playArea[i][j]
                                    && (lastFree == lastEqual + 1 || testColumn == i - 1)
                                    && !multiplied[testColumn][j]) {
                                playArea[testColumn][j] = 2 * playArea[i][j];
                                playArea[i][j] = 0;
                                multiplied[testColumn][j] = true;
                                moved = true;
                            } else if (playArea[testColumn][j] == 0 && (lastFree > -1 || testColumn == i - 1)) {
                                playArea[testColumn][j] = playArea[i][j];
                                playArea[i][j] = 0;
                                moved = true;
                            }
                        }
                    }
                    if (!moved) {
                        if ((lastEqual > -1 && lastEqual < lastFree) && !multiplied[lastEqual][j]) {
                            playArea[lastEqual][j] = 2 * playArea[i][j];
                            playArea[i][j] = 0;
                            multiplied[lastEqual][j] = true;
                            moved = true;
                        } else if (lastFree != -1) {
                            playArea[lastFree][j] = playArea[i][j];
                            playArea[i][j] = 0;
                            moved = true;
                        } else {
                            moved = true;
                        }
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
    public void moveNumbersWest() {
        boolean[][] multiplied = { { false, false, false, false }, { false, false, false, false },
                { false, false, false, false }, { false, false, false, false } };
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 1; j < playArea[i].length; j++) {
                if (playArea[i][j] > 0) {
                    boolean moved = false;
                    int lastFree = -1;
                    int lastEqual = -1;
                    boolean clear = true;
                    for (int testRow = j - 1; testRow > -1; testRow--) {
  
                        if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j - 1)) {
                            lastFree = testRow;
                        }
                        if (playArea[i][testRow] == playArea[i][j] && ((lastFree != -1 && clear) || testRow == j - 1)) {
                            lastEqual = testRow;
                        }
                        if (playArea[i][testRow] != 0 && testRow > 0) {
                            clear = false;
                        }
                        if (testRow == 0) {
                            if (playArea[i][testRow] == playArea[i][j]
                                    && (lastFree == lastEqual + 1 || testRow == j + 1) && !multiplied[i][testRow]) {
                                playArea[i][0] = 2 * playArea[i][j];
                                playArea[i][j] = 0;
                                multiplied[i][testRow] = true;
                                moved = true;
                            } else if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j - 1)) {

                                playArea[i][testRow] = playArea[i][j];
                                playArea[i][j] = 0;
                                moved = true;
                            }
                        }
                    }
                    if (!moved) {
                        if (((lastEqual > -1 && lastEqual > lastFree) || (lastEqual > -1)) && !multiplied[i][lastEqual]) {
                            playArea[i][lastEqual] = 2 * playArea[i][j];
                            playArea[i][j] = 0;
                            multiplied[i][lastEqual] = true;
                            moved = true;
                        } else if (lastFree != -1) {
                            playArea[i][lastFree] = playArea[i][j];
                            playArea[i][j] = 0;
                            moved = true;
                        } else // no move
                        {
                            moved = true;
                        }
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
    public void moveNumbersEast() {
        boolean[][] multiplied = { { false, false, false, false }, { false, false, false, false },
                { false, false, false, false }, { false, false, false, false } };
        for (int i = 0; i < playArea.length; i++) {
            for (int j = playArea[i].length - 2; j > -1; j--) {
                if (playArea[i][j] > 0) {
                    boolean moved = false;
                    int lastFree = -1;
                    int lastEqual = -1;
                    boolean clear = true;
                    for (int testRow = j + 1; testRow < playArea.length; testRow++) {
                        if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j + 1)) {
                            lastFree = testRow;
                        }
                        if (playArea[i][testRow] == playArea[i][j] && ((lastFree != -1 && clear) || testRow == j + 1)) {
                            lastEqual = testRow;
                        }
                        if (playArea[i][testRow] != 0 && testRow < 3) {
                            clear = false;
                        }
                        if (testRow == 3) {
                            if (playArea[i][testRow] == playArea[i][j]
                                    && (lastFree == lastEqual + 1 || testRow == j + 1) && !multiplied[i][testRow]) {
                                playArea[i][testRow] = 2 * playArea[i][j];
                                playArea[i][j] = 0;
                                multiplied[i][3] = true;
                                moved = true;
                            } else if (playArea[i][testRow] == 0 && (lastFree != -1 || testRow == j + 1)) {

                                playArea[i][testRow] = playArea[i][j];
                                playArea[i][j] = 0;
                                moved = true;
                            }
                        }
                    }
                    if (!moved) {
                        if ((lastFree != -1 && lastEqual > lastFree || lastEqual == j + 1)
                                && !multiplied[i][lastEqual]) {
                            playArea[i][lastEqual] = 2 * playArea[i][j];
                            multiplied[i][lastEqual] = true;
                            playArea[i][j] = 0;
                            moved = true;
                        } else if (lastFree != -1) {
                            playArea[i][lastFree] = playArea[i][j];
                            playArea[i][j] = 0;
                            moved = true;
                        } else {
                            moved = true;
                        }
                    }
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                System.out.print("[" + playArea[i][j] + "]");
            }
            System.out.println();

        }
    }

    public String[] toStringArray() {
        String[] board = new String[4];
        for (int i = 0; i < playArea.length; i++) {
            String line = "";
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] / 10 < 1) {
                    line += ("[   " + Integer.toString(playArea[i][j]) + "   ]");
                } else if (playArea[i][j] / 10 < 10) {
                    line += ("[  " + Integer.toString(playArea[i][j]) + "   ]");
                } else if (playArea[i][j] / 10 < 100) {
                    line += ("[ " + Integer.toString(playArea[i][j]) + "   ]");
                } else if (playArea[i][j] / 10 < 1000) {
                    line += ("[ " + Integer.toString(playArea[i][j]) + "  ]");
                }
            }
            board[i] = line;
        }
        return board;
    }

    public void clearBoard() {
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                playArea[i][j] = 0;
                ;
            }
        }
    }

    public int[][] copyBoard() {
        int[][] copy = new int[4][4];
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                copy[i][j] = playArea[i][j];
            }
        }
        return copy;
    }

    public void restoreBoard(int[][] org) {
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                playArea[i][j] = org[i][j];
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
    public int checkForWinLose() {
        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] == 2048)
                    return 1;
            }
        }

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] == 0)
                    return 0;
            }
        }

        int[][] orginal = copyBoard(); // this looks disgusting, but it allows
                                       // me to keep the original order of
                                       // the playArea intact

        /*
         * again, this is disgusting but it seems like the easiest way to do
         * this without rewriting the entire board reader class. this moves the
         * playArea in a direction, checks if the resulting board has space, and
         * then resets it to the original position.
         * 
         */

        moveNumbersSouth();

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] == 0)
                    return 0;
            }
        }

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                playArea[i][j] = orginal[i][j];
            }
        }

        moveNumbersNorth();

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] == 0)
                    return 0;
            }
        }

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                playArea[i][j] = orginal[i][j];
            }
        }

        moveNumbersWest();

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] == 0)
                    return 0;
            }
        }

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                playArea[i][j] = orginal[i][j];
            }
        }

        moveNumbersEast();

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                if (playArea[i][j] == 0)
                    return 0;
            }
        }

        for (int i = 0; i < playArea.length; i++) {
            for (int j = 0; j < playArea[i].length; j++) {
                playArea[i][j] = orginal[i][j];
            }
        }

        return -1;
    }

}
