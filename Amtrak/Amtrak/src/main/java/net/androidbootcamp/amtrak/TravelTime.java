//*****************************************************************************
//	TravelTime.java							Matt Matuk
//	3/14/15
//
//	This class display the travel time that was calculated in the previous screen.
//*****************************************************************************
package net.androidbootcamp.amtrak;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelTime extends Activity
{

	private int sHour, sMin, endHour, endMin, overMidnight;
	private SharedPreferences sharedPref;
	private TextView txtViewStart, txtViewEnd, txtViewRedEyed;
	private ImageView imgView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travel_time);
		
		intVar();
		
		sHour = sharedPref.getInt("sHour", 0);
		sMin = sharedPref.getInt("sMin", 0);
		endHour = sharedPref.getInt("endHour", 0);
		endMin = sharedPref.getInt("endMin", 0);
		overMidnight = sharedPref.getInt("overMidnight", 0);
		
		txtViewStart.setText(((sHour < 10) ? "0"+sHour : sHour)
						+ ":"
						+ ((sMin < 10) ? "0"+sMin : sMin));
		txtViewEnd.setText(((endHour < 10) ? "0"+endHour : endHour)
				+ ":"
				+ ((endMin < 10) ? "0"+endMin : endMin));
		
		if (overMidnight ==1 )
		{
			txtViewRedEyed.setText("Red-Eyed Arrival");
			imgView.setBackgroundResource(R.drawable.red_eye);
		}
		else
		{
			imgView.setBackgroundResource(R.drawable.clock);
		}
		
	}

	/**
	 * Sets all vars
	 */
	private void intVar()
	{
		sHour =0;
		sMin = 0;
		endHour = 0;
		endMin = 0;
		sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		txtViewStart = (TextView)findViewById(R.id.textViewStartTime);
		txtViewEnd = (TextView)findViewById(R.id.textViewEndTime);
		txtViewRedEyed = (TextView)findViewById(R.id.textViewRed);
		imgView = (ImageView)findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.travel_time, menu);
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
