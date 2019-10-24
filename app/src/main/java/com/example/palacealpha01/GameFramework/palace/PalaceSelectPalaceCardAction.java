package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;

public class PalaceSelectPalaceCardAction extends GameAction {


    private Pair userSelectedCard;


    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PalaceSelectPalaceCardAction(GamePlayer player, Pair userSelectedCard) {
        super(player);
        this.userSelectedCard = userSelectedCard;
    }
}
