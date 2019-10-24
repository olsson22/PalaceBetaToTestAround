package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.LocalGame;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;

public class PalaceLocalGame extends LocalGame {

    protected PalaceGameState pgs;

    public PalaceLocalGame() {
        super();

        pgs = new PalaceGameState();
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PalaceGameState(pgs));
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }
}
