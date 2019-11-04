package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.LocalGame;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;

import java.util.ArrayList;

public class PalaceLocalGame extends LocalGame {

    protected PalaceGameState pgs;
    private ArrayList<Pair> selectedCards = new ArrayList<>();
    private int p1counter=0;
    private int p2counter=0;
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
        return playerIdx == pgs.getTurn();
    }

    //TODO: as of now, as soon as you tap a card it returns that player 0 won... need to fix this, that's why it is commented out
    //
    @Override
    protected String checkIfGameOver() {
        return null;
/*
        if(pgs.getTurn()== 1){
            for(Pair p : pgs.the_deck){
                if(p.get_location()== Location.PLAYER_TWO_HAND && p.get_location() == Location.PLAYER_TWO_UPPER_PALACE && p.get_location()== Location.PLAYER_TWO_LOWER_PALACE){
                    p2counter++;
                }
            }
        }
        if(pgs.getTurn()== 0){
            for(Pair p : pgs.the_deck){
                if(p.get_location()== Location.PLAYER_ONE_HAND && p.get_location() == Location.PLAYER_ONE_UPPER_PALACE && p.get_location()== Location.PLAYER_ONE_LOWER_PALACE){
                    p1counter++;
                }
            }
        }

        if(p1counter == 0){
            return playerNames[0] + " is the winner ";
        }
        else if(p2counter == 1){
            return playerNames[1] + " is the winner ";
        }else
        {

            return null;
        }*/
    }

    @Override
    protected boolean makeMove(GameAction action) {

        GamePlayer p = action.getPlayer();
        int playerNum = 0;

        //finds the playernum to the active player
        for (int i = 0; i < players.length; i++)
        {
            if (players[i] == p)
            {
                playerNum = i;
            }
        }
        //if it is not the player's turn return false
        if(pgs.getTurn() != playerNum)
        {
            return false;
        }
        //if action is a selectCardAction, perform this action
        //TODO: I think we need to change this call in some way so we can select multiple cards, and not only one, as we have it now.
        if(action instanceof PalaceSelectCardAction){

                if(canMove(playerNum)){
                    Pair pair = ((PalaceSelectCardAction)action).getUserSelectedCard();

                    if(pgs.getTurn()==0)
                    {

                        pgs.selectCards(0, pair);

                        return true;
                    }
                    else{
                        pgs.selectCards(1,pair);
                        return true;
                    }

                    }

                }
        //if action is a playCardAction, perform this move
        //TODO: I suppose this call needs to be changed aswell to handle multiple cards being played.
        else if(action instanceof PalacePlayCardAction){
            if(canMove(playerNum)){

                if(pgs.getTurn()==0){
                    pgs.playCards(0);
                    pgs.setTurn(1);
                    return true;
                }
                else{
                    pgs.playCards(1);
                    pgs.setTurn(0);
                    return true;
                }

            }
        }
        //if action is takeDiscardPile, perform this move
        else if(action instanceof PalaceTakeDiscardPileAction){
            if(canMove(playerNum)){
                if(pgs.getTurn()==0){
                    pgs.takeDiscardPile(0);
                    pgs.setTurn(1);
                    return true;
                }
                else{
                    pgs.takeDiscardPile(1);
                    pgs.setTurn(0);
                    return true;
                }
            }
        }

        //if action is of changepalaceaction, perform this action
        else if(action instanceof PalaceChangePalaceAction){
           int turn = pgs.getTurn();
           if(turn == 0){
               pgs.changePalace(0);
               return true;
           }else
           {
               pgs.changePalace(1);
               return true;
           }
        }

    return false;
    }//Makemove
}
