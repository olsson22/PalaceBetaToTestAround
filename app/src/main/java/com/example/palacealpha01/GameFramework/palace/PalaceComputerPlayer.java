package com.example.palacealpha01.GameFramework.palace;

import android.util.Log;

import com.example.palacealpha01.GameFramework.GameComputerPlayer;
import com.example.palacealpha01.GameFramework.infoMessage.GameInfo;
import com.example.palacealpha01.GameFramework.infoMessage.NotYourTurnInfo;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is the Computer Player class for Palace
 *
 * The Computer Player is implemented here
 *
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 * @version November 2019
 */

public class PalaceComputerPlayer extends GameComputerPlayer
{

	/**
	 * The PalaceComputerPlayer is extened from the GameComputerPlayer Class
	 * @param name
	 */
	public PalaceComputerPlayer(String name)
	{
		super(name);
	}//PalaceComputerPlayer

	/**
	 *
	 * @param info
	 */
	@Override
	protected void receiveInfo(GameInfo info)
	{
		if (info instanceof NotYourTurnInfo)
		{
			return;
		}

		//TODO: add functions to make the computer player play cards and not only pick up the discard pile every time.
		game.sendAction(new PalaceTakeDiscardPileAction(this));
		sleep(2);


		//game.sendAction(new PalaceSkipTurn(this));

	}//receiveInfo
}
