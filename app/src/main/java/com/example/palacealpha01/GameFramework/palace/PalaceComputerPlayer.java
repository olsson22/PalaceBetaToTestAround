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
		if(info instanceof PalaceGameState){
			info.setGame(game);
			PalaceGameState pgs = (PalaceGameState) info;

			if(pgs.getTurn()==this.playerNum){
				for(Pair p: pgs.getSelectedCards()) {

				if (pgs.getSelectedCards().contains(p)){
					PalacePlayCardAction playCardAction = new PalacePlayCardAction(this);
					game.sendAction(playCardAction);

					}
				}
			}

			if(pgs.getTurn()==this.playerNum){
				for(Pair pair: pgs.the_deck){
					if(pair.get_location()== Location.PLAYER_TWO_HAND){
						PalaceSelectCardAction selected = new PalaceSelectCardAction(this, pair);
						game.sendAction(selected);
						sleep(2);
						return;
					}

				}
			}

		}

		//TODO: add functions to make the computer player play cards and not only pick up the discard pile every time.

		//	game.sendAction(new PalaceTakeDiscardPileAction(this));
		//	sleep(2);




	}
}
