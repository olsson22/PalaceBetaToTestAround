package com.example.palacealpha01.GameFramework.palace;

import com.example.palacealpha01.GameFramework.GameComputerPlayer;
import com.example.palacealpha01.GameFramework.infoMessage.GameInfo;
import com.example.palacealpha01.GameFramework.infoMessage.NotYourTurnInfo;

public class PalaceComputerPlayer extends GameComputerPlayer
{


	public PalaceComputerPlayer(String name)
	{
		super(name);
	}

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

	}
}
