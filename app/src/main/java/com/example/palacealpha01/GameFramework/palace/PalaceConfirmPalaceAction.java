package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;

/**
 * An Action in which the user confirms their selection of cards for their palace
 *
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 * @version November 2019
 */
public class PalaceConfirmPalaceAction extends GameAction
{
	/**
	 * constructor for GameAction
	 *
	 * @param player the player who created the action
	 */
	public PalaceConfirmPalaceAction(GamePlayer player)
	{
		super(player);
	}//PalaceConfirmPalaceAction
}//class PalaceConfirmPalaceAction
