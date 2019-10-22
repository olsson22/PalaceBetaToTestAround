package com.example.palacealpha01.GameFramework.palace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.palacealpha01.GameFramework.GameMainActivity;
import com.example.palacealpha01.GameFramework.gameConfiguration.GameConfig;
import com.example.palacealpha01.R;

/**
 * @author Andres Giesemann, Fredrik Olsson, Meredith Marcinko, Maximilian Puglielli
 */
public class PalaceMainActivity extends GameMainActivity implements View.OnClickListener
{

    private static final String TAG = "TTTMainActivity";
    public static final int PORT_NUMBER = 5213;

    /**
     * a tic-tac-toe game is for two players. The default is human vs. computer
     */
    @Override
    public GameConfig createDefaultConfig() {

    }

    /*private CardSurfaceView tableView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableView = findViewById(R.id.TableSurfaceView);

        PalaceGameState pgs = new PalaceGameState(getResources());
        tableView.setPgs(pgs);
        tableView.setOnTouchListener(tableView);

        Button tester = findViewById(R.id.TestButton);
        tester.setOnClickListener(this);


    }//onCreate


    /**
     * This method listens to a ClickEvent and then
     * calls all the Use case methods in the PalaceGameState class
     *
     * @param view
     *
    @Override
    public void onClick(View view)
    {
        tableView.invalidate();

    }//onClick*/
}//class PalaceMainActivity