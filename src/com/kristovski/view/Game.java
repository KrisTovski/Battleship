package com.kristovski.view;

import com.kristovski.model.Board;
import com.kristovski.model.Ship;
import com.kristovski.service.BoardInitializer;
import com.kristovski.service.ShipInitializer;

import java.util.Random;

public class Game {

    private static final int BOARD_SIZE = 10;

    Board board = new Board(BOARD_SIZE);


    BoardInitializer boardInitializer = new BoardInitializer();
    ShipInitializer shipInitializer = new ShipInitializer();

    Random random = new Random();

    Ship battleship = new Ship(5, random.nextBoolean(), false);
    Ship destroyer1 = new Ship(4, random.nextBoolean(), false);
    Ship destroyer2 = new Ship(4, random.nextBoolean(), false);

    public void insertShipsToBoard() {
        shipInitializer.insertShip(board, battleship);
        shipInitializer.insertShip(board, destroyer1);
        shipInitializer.insertShip(board, destroyer2);
    }

    public void start() {
        boardInitializer.initializeBoardGame(board);
    }

    public void printCurrentSateOfTheBoard() {
        boardInitializer.printCurrentStateOfTheBoard(board);
    }

    public void printCurrentStateOfTheBoardWithShipsHidden(){
        boardInitializer.printCurrentStateOfTheBoardWithShipsHidden(board);
    }


}
