package com.kristovski;

import com.kristovski.view.Game;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.start();
        game.insertShipsToBoard();
        game.printCurrentSateOfTheBoard();
        game.printCurrentStateOfTheBoardWithShipsHidden();

    }
}
