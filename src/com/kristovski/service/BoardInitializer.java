package com.kristovski.service;

import com.kristovski.model.Board;

public class BoardInitializer {


    private static final int BOARD_SIZE = 10;
    private static final char START_COL_DESC = 'A';
    private static final int START_ROW_DESC = 1;
    private static final char WATER = '~';

    Board board = new Board(new char[BOARD_SIZE][BOARD_SIZE]);

    public void printBoardGame() {

        char column = START_COL_DESC;
        int row = START_ROW_DESC;
        printColumnLetters(column);
        for (int i = 0; i < board.getBoard().length; i++) {
            row = printRowNumbers(row, i);

            for (int j = 0; j < board.getBoard().length; j++) {
                char[][] matrix = this.board.getBoard();
                matrix[i][j] = WATER;

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private int printRowNumbers(int row, int i) {
        if (i < board.getBoard().length - 1) {
            System.out.print(row + "  ");
        } else {
            System.out.print(row + " ");
        }
        row++;
        return row;
    }

    private void printColumnLetters(char column) {
        System.out.print("   ");

        for (int i = 0; i < 10; i++) {
            System.out.print(column + " ");
            column++;
        }
        System.out.println();
    }

}
