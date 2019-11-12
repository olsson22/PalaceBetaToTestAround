package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.actionMessage.GameAction;
/**
 * An Action that implements the skipTurn function
 *
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 * @version November 2019
 */
public class PalaceSkipTurn extends GameAction
{
	/**
	 * Constructor for GameAction
	 *
	 * @param p the player who created the action
	 */
	public PalaceSkipTurn(GamePlayer p)
	{
		super(p);
	}//PalaceSkipTurn
}//class PalaceSkipTurn
