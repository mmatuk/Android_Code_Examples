//************************************************************************
//	Status.java 								Matt Matuk
// 	CSIT 268
//
//  Dsplays the status of the user using persistent data and the amount of miles the user entered.
//		-	>= 75000 gold
//		-	>= 5000 silver
//		-	>= 25000 bronze
//*************************************************************************
package net.androidbootcamp.clearjetrewards;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Status extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);
		
		TextView result = (TextView)findViewById(R.id.txtResult);
		ImageView image = (ImageView)findViewById(R.id.imgStatus);
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		String strFiler = sharedPref.getString("key1", "");
		int intMiles = sharedPref.getInt("key2", 0);
		
		if (intMiles >= 75000)
		{
			image.setImageResource(R.drawable.gold);
			result.setText(strFiler + " has reached Gold status");
		}
		else if (intMiles >= 50000)
		{
			image.setImageResource(R.drawable.silver);
			result.setText(strFiler + " has reached Silver status");
		}
		else if (intMiles >= 25000)
		{
			image.setImageResource(R.drawable.bronze);
			result.setText(strFiler + " has reached Bronze status");
		}
		else 
		{
			result.setText("You have not reached an award");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status, menu);
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
