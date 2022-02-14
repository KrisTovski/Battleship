package com.kristovski;

import com.kristovski.model.Board;
import com.kristovski.model.Point;
import com.kristovski.model.Ship;

import java.util.*;

import static com.kristovski.utils.Constants.*;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board(BOARD_SIZE);

    Ship battleship = new Ship(5, null, new Random().nextBoolean(), false);
    Ship destroyer1 = new Ship(4, null, new Random().nextBoolean(), false);
    Ship destroyer2 = new Ship(4, null, new Random().nextBoolean(), false);

    public List<Ship> shipList = new ArrayList<>();

    public void start() {
        initializeBoardGame();
        addShipToList();
        insertShip();
        printCurrentStateOfTheBoard();
        printCurrentStateOfTheBoardWithShipsHidden();
        play();
    }

    public void addShipToList() {
        shipList.add(battleship);
        shipList.add(destroyer1);
        shipList.add(destroyer2);

    }

    public void initializeBoardGame() {
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

    //Helper method to show ships on the board
    public void printCurrentStateOfTheBoardWithShipsHidden() {
        printColumnLetters(board);
        int startRowNumber = START_ROW_NUMBER;

        for (int i = 0; i < board.getSize(); i++) {

            startRowNumber = printRowNumber(board, startRowNumber, i);

            for (int j = 0; j < board.getSize(); j++) {
                char[][] matrix = board.getBoard();
                if (matrix[i][j] == SHIP) {
                    System.out.print(WATER + "  ");
                } else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();

        }
    }

    public void printCurrentStateOfTheBoard() {
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

        for (int i = 0; i < board.getSize(); i++) {
            System.out.print(startColumnLetter + "  ");
            startColumnLetter++;
        }
        System.out.println();
    }


    public void play() {

        do {
            System.out.println("Choose coordinates, e.g. A1, C4, G8, etc: ");
            String coordinates = scanner.nextLine();
            int x = getXFromLetterCoordinate(coordinates);
            int y = getYFromNumberCoordinate(coordinates);

            System.out.println(x + " " + y);

            char[][] matrix = board.getBoard();

            if (matrix[y][x] == SHIP) {
                board.getBoard()[y][x] = HIT;
                System.out.println("Hit");

            } else if (matrix[y][x] == WATER) {
                board.getBoard()[y][x] = MISSED;
                System.out.println("missed");
            }

            checkIfShipSunk();
            printCurrentStateOfTheBoard();

        } while (!isAllShipSunk());
        if(isAllShipSunk()){
            System.out.println("CONGRATULATIONS, YOU WIN!");
        }

    }

    private boolean isAllShipSunk() {
        int counter = shipList.size();
        for (Ship ship : shipList) {
            if(ship.isDestroyed()){
            counter--;
            }
        }
        return counter == 0;
    }

    private void checkIfShipSunk() {
        for (Ship ship : shipList) {
            Point startPoint = ship.getStartPoint();

            if (ship.isHorizontal()) {
                int lives = 0;
                for (int i = 0; i < ship.getSize(); i++) {
                    if (board.getBoard()[startPoint.getY()][startPoint.getX() + i] == SHIP) {
                        lives++;
                    }
                }
                if (lives == 0 && !ship.isDestroyed()) {
                    ship.setDestroyed(true);
                    System.out.println("SUNK");
                }
            }
            if (!ship.isHorizontal()) {
                int lives = 0;
                for (int i = 0; i < ship.getSize(); i++) {
                    if (board.getBoard()[startPoint.getY() + i][startPoint.getX()] == SHIP) {
                        lives++;
                    }
                }
                if (lives == 0 && !ship.isDestroyed()) {
                   ship.setDestroyed(true);
                    System.out.println("SUNK");

                }
            }
        }
    }

    private int getYFromNumberCoordinate(String coordinates) {
        int y;
        if (coordinates.length() <= 2) {
            y = coordinates.charAt(1) - '1';
        } else {
            String substring = coordinates.substring(1, 3);
            y = Integer.parseInt(substring) - 1;
        }
        return y;
    }

    private int getXFromLetterCoordinate(String coordinates) {
        return coordinates.toLowerCase().charAt(0) - 'a';
    }


    private void setShipRandomCoordinates(Ship ship) {

        Random random = new Random();
        Point point = new Point(random.nextInt(board.getSize()), random.nextInt(board.getSize()));
        ship.setStartPoint(point);

    }

    public void insertShip() {

        while (!isAllShipsHaveStartPoints()) {
            for (Ship ship : shipList) {
                if (ship.getStartPoint() == null) {
                    setShipRandomCoordinates(ship);

                    Point startPoint = ship.getStartPoint();

                    addShipToBoard(ship, startPoint);
                }
            }
        }
    }

    private void addShipToBoard(Ship ship, Point startPoint) {
        if (ship.isHorizontal()) {
            if (startPoint.getX() <= (board.getSize() - ship.getSize()) && isSpaceFree(ship, startPoint)) {
                for (int i = 0; i < ship.getSize(); i++) {
                    char[][] matrix = board.getBoard();
                    matrix[startPoint.getY()][startPoint.getX() + i] = SHIP;
                }
            } else {
                ship.setStartPoint(null);
            }

        } else {
            if (startPoint.getY() <= (board.getSize() - ship.getSize()) && isSpaceFree(ship, startPoint)) {

                for (int i = 0; i < ship.getSize(); i++) {
                    char[][] matrix = board.getBoard();
                    matrix[startPoint.getY() + i][startPoint.getX()] = SHIP;
                }
            } else {
                ship.setStartPoint(null);
            }
        }
    }

    private boolean isAllShipsHaveStartPoints() {
        for (Ship ship : shipList) {
            if (ship.getStartPoint() == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isSpaceFree(Ship ship, Point startPoint) {
        boolean free = true;
        if (ship.isHorizontal()) {
            for (int i = 0; i < ship.getSize(); i++) {
                char[][] matrix = board.getBoard();
                if (matrix[startPoint.getY()][startPoint.getX() + i] == SHIP) {
                    free = false;
                }
            }
            return free;

        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                char[][] matrix = board.getBoard();
                if (matrix[startPoint.getY() + i][startPoint.getX()] == SHIP) {
                    free = false;
                }
            }
            return free;
        }


    }
}