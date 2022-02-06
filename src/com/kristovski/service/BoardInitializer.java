package com.kristovski.service;

import com.kristovski.model.Board;

public class BoardInitializer {

    private static final char START_COLUMN_LETTER = 'A';
    private static final int START_ROW_NUMBER = 1;
    private static final char WATER = '~';


    public void printCurrentStateOfTheBoardWithShipsHidden(Board board){
        printColumnLetters(board);
        int startRowNumber = START_ROW_NUMBER;

        for (int i = 0; i < board.getSize(); i++) {

            startRowNumber = printRowNumber(board, startRowNumber, i);

            for (int j = 0; j < board.getSize(); j++) {
                char[][] matrix = board.getBoard();
                if (matrix[i][j] == 'S'){
                    System.out.print("~  ");
                } else
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();

        }
    }

    public void printCurrentStateOfTheBoard(Board board){
        printColumnLetters(board);
        int startRowNumber = START_ROW_NUMBER;

        for (int i = 0; i < board.getSize(); i++) {

            startRowNumber = printRowNumber(board, startRowNumber, i);

            for (int j = 0; j < board.getSize(); j++) {
                char[][] matrix = board.getBoard();
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();

        }
    }



    public void initializeBoardGame(Board board) {

        printColumnLetters(board);
        int startRowNumber = START_ROW_NUMBER;

        for (int i = 0; i < board.getSize(); i++) {

            startRowNumber = printRowNumber(board, startRowNumber, i);

            for (int j = 0; j < board.getSize(); j++) {
                char[][] matrix = board.getBoard();
                matrix[i][j] = WATER;

                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

    }

    private int printRowNumber(Board board, int startRowNumber, int i) {
        if (i < board.getSize() - 1) {
            System.out.print(startRowNumber + "  ");
        } else {
            System.out.print(startRowNumber + " ");
        }
        startRowNumber++;
        return startRowNumber;
    }

    private void printColumnLetters(Board board) {

        char startColumnLetter = START_COLUMN_LETTER;

        System.out.print("   ");

        for (int i = 0; i < board.getSize() ; i++) {
            System.out.print(startColumnLetter + "  ");
            startColumnLetter++;
        }
        System.out.println();
    }

}
