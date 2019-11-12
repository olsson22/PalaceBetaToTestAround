package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;
/**
 * An Action in which the user selects the card that they want to play
 *
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 * @version November 2019
 */
public class PalaceSelectCardAction extends GameAction
{
	private Pair userSelectedCard;

	/**
	 * constructor for GameAction
	 *
	 * @param player the player who created the action
	 */
	public PalaceSelectCardAction(GamePlayer player, Pair userSelectedCard)
	{
		super(player);
		this.userSelectedCard = userSelectedCard;

	}//PalaceSelectCardAction


	public Pair getUserSelectedCard()
	{
		return userSelectedCard;
	}//getUserSelectedCard

}
