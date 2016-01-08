//*****************************************************************************
//	MainActivity.java							Matt Matuk
//	3/14/15										Lab 4 Chapter 4
//
//	Shows the ability to use a spinner and entered length to calculate the time it will take to
// 	reach the destination.
//
//	This class will allow teh user to select the boarding time and the enter the length of the
// 	trip and will determine the time and at what time the user will arrive at teh destination.
//*****************************************************************************
package net.androidbootcamp.amtrak;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private ArrayList<String> aryHour, aryMin;
	private int sHour, sMin, length, endHour, endMin;
	private Spinner spnHour, spnMin;
	private EditText editTextLength;
	private Button btnCalculate;
	public SharedPreferences sheredPref;
	public Editor editor;
	private int overMidnight; // 1 means yes;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intVar();
        createSpinnerText();
        addSpinnerText();

		// calculates the time to destination and stores it in the shared preferences. User must
		// enter a value less than 1500 minutes for length
        btnCalculate.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{
				length = Integer.parseInt(editTextLength.getText().toString());
				
				if (length > 1500)
				{
					Toast.makeText(MainActivity.this, "Please enter a length less than 1500 minutes.", Toast.LENGTH_SHORT).show();
				}
				else
				{
					sHour = spnHour.getSelectedItemPosition();
					sMin = spnMin.getSelectedItemPosition();

					Log.d("min", ""+sMin);
					Log.d("hour", ""+sHour);
					
					endHour = sHour;
					endMin += (sMin + length);
					
					if (endMin > 59)
					{
						endHour += (endMin / 60);
						endMin = (endMin % 60);
					}
					
					if (endHour > 23)
					{
						endHour = endHour - 24;
						overMidnight = 1;
					}
					else
					{
						overMidnight = 0;
					}
					
					Log.d("min", ""+endMin);
					Log.d("hour", ""+endHour);
					
					editor.putInt("sHour", sHour);
					editor.putInt("sMin", sMin);
					editor.putInt("endHour", endHour);
					editor.putInt("endMin", endMin);
					editor.putInt("overMidnight", overMidnight);
					editor.commit();
					
					startActivity(new Intent(MainActivity.this, TravelTime.class));
				}
			}
		});

    }

	/**
	 * sets all vars
	 */
    private void intVar()
    {
    	sHour = 0;
    	sMin =0;
    	length = 0;
    	endMin = 0;
    	endHour = 0;
    	overMidnight = 0;
    	spnHour = (Spinner)findViewById(R.id.spnHour);
    	spnMin = (Spinner)findViewById(R.id.spnMin);
    	aryHour = new ArrayList<String>();
    	aryMin = new ArrayList<String>();
    	editTextLength = (EditText)findViewById(R.id.editTextLength);
    	btnCalculate = (Button)findViewById(R.id.buttonCalculate);
    	sheredPref = PreferenceManager.getDefaultSharedPreferences(this);
    	editor = sheredPref.edit();
    }

	/**
	 * adds numbers to the arrays for teh hour and min
	 */
    private void createSpinnerText()
    {
    	for (int num = 0; num < 24; num++)
    	{
    		aryHour.add(""+num);
    	}
    	
    	for (int num = 0; num < 60; num++)
    	{
    		aryMin.add(""+num);
    	}

    	Log.d("test", aryHour.toString());

    }

	/**
	 * Adds the hour nad min arrays to the proper spinners
	 */
    private void addSpinnerText()
    {
    	spnHour.setAdapter(new ArrayAdapter<String>(this, 
    			android.R.layout.simple_spinner_item, aryHour));
       	spnMin.setAdapter(new ArrayAdapter<String>(this, 
       			android.R.layout.simple_spinner_item, aryMin));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
