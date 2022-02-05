package com.kristovski.model;

public class Board {

    private char[][] board;

    public Board(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}
