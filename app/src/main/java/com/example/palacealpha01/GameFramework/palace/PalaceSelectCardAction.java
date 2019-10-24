package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;

public class PalaceSelectCardAction extends GameAction {


    private Pair userSelectedCard;


    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PalaceSelectCardAction(GamePlayer player, Pair userSelectedCard) {
        super(player);
        this.userSelectedCard = userSelectedCard;


    }


    public Pair getUserSelectedCard(){
        return userSelectedCard;
    }





}
