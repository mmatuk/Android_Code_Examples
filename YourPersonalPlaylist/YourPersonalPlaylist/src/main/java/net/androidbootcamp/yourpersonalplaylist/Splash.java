//**************************************************************************************************
//	Splash.java 								Matt Matuk
// 	CSIT 268								    Project 6-6
//	Creates the splash screen for the app that will last for 6 seconds
//
//***************************************************************************************
package net.androidbootcamp.yourpersonalplaylist;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Splash extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        TimerTask task = new TimerTask()
        {
			@Override
			public void run()
			{
				finish();
				startActivity(new Intent(Splash.this, MainActivity.class));
			}
        };
        Timer opening = new Timer();
        opening.schedule(task, 6000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) 
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
