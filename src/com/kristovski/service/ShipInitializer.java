package com.kristovski.service;

import com.kristovski.model.Board;
import com.kristovski.model.Ship;

import java.util.Random;

public class ShipInitializer {

    private static final char SHIP = 'S';

    public void insertShip(Board board, Ship ship) {

        Random random = new Random();

        int xPosition = random.nextInt(board.getSize());
        int yPosition = random.nextInt(board.getSize());

        if (ship.isHorizontal()) {
            if (isFitToBoard(board, ship, xPosition) && isFree(board, ship, xPosition, yPosition)) {
                for (int i = 0; i < ship.getSize(); i++) {
                    char[][] matrix = board.getBoard();
                    matrix[yPosition][xPosition + i] = SHIP;
                }
            } else insertShip(board, ship);
        } else {
            if (isFitToBoard(board, ship, yPosition) && isFree(board, ship, xPosition, yPosition)) {
                for (int i = 0; i < ship.getSize(); i++) {
                    char[][] matrix = board.getBoard();
                    matrix[yPosition + i][xPosition] = SHIP;
                }
            } else insertShip(board, ship);
        }
    }


    private boolean isFree(Board board, Ship ship, int xPosition, int yPosition) {
        boolean free = true;
        if (ship.isHorizontal()) {
            for (int i = 0; i < ship.getSize(); i++) {
                char[][] matrix = board.getBoard();
                char matrix1 = matrix[yPosition][xPosition + i];
                if (matrix1 == SHIP) {
                    free = false;
                }
            }
        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                char[][] matrix = board.getBoard();
                char matrix1 = matrix[yPosition + i][xPosition];
                if (matrix1 == SHIP) {
                    free = false;
                }
            }
        }
        return free;
    }

    private boolean isFitToBoard(Board board, Ship ship, int position) {
        return position <= (board.getSize() - ship.getSize());
    }


}
