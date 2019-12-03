package com.example.palacealpha01.GameFramework.palace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.palacealpha01.GameFramework.GameMainActivity;//
import com.example.palacealpha01.GameFramework.GamePlayer;
import com.example.palacealpha01.GameFramework.LocalGame;//
import com.example.palacealpha01.GameFramework.ProxyGame;
import com.example.palacealpha01.GameFramework.gameConfiguration.GameConfig;//
import com.example.palacealpha01.GameFramework.gameConfiguration.GamePlayerType;
//import com.example.palacealpha01.R;

import java.util.ArrayList;

/**
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 */
public class PalaceMainActivity extends GameMainActivity implements View.OnClickListener
{

	private static final String TAG = "PalaceMainActivity";
	public static final int PORT_NUMBER = 5213;

	/**
	 * Palace is for two players. The default is human vs. computer
	 */
	@Override
	public GameConfig createDefaultConfig()
	{
		ArrayList<GamePlayerType> playerTypes = new ArrayList<>();
		playerTypes.add(new GamePlayerType("Local Human Player")
		{
			public GamePlayer createPlayer(String name)
			{
				return new PalaceHumanPlayer(name, R.layout.palace_activity_main);
			}
		});

		playerTypes.add(new GamePlayerType("Computer Player (dumb)")
		{
			public GamePlayer createPlayer(String name)
			{
				return new PalaceComputerPlayer(name);
			}
		});
		// Create a game configuration class for Tic-tac-toe
		GameConfig defaultConfig = new GameConfig(playerTypes, 2, 2, "Palace", PORT_NUMBER);

		defaultConfig.addPlayer("Human", 0);
		defaultConfig.addPlayer("computer", 1);
		defaultConfig.setRemoteData("Remote Player", "", 1);

		return defaultConfig;
	}//createDefaultConfig

	/**
	 * LocalGame method:
	 * creates the localGame.
	 * @return
	 */
	@Override
	public LocalGame createLocalGame()
	{
		return new PalaceLocalGame();
	}//createLocalGame
}//class PalaceMainActivity