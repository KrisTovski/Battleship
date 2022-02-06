package com.kristovski.model;

public class Board {

    private final int size;
    private final char[][] board;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
    }

    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }
}
