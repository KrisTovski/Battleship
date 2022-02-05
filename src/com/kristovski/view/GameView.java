package com.kristovski.view;

import com.kristovski.service.BoardInitializer;

public class GameView {

    BoardInitializer initializer = new BoardInitializer();

    public void start(){
        initializer.printBoardGame();
    }


}
