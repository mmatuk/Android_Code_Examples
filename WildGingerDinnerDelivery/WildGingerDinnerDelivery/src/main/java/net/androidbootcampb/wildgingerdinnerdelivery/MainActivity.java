//************************************************************************
//	MainActivity.java 								Matt Matuk
// 	CSIT 268
//
//  This app will show the ability to use a date picker to pick a time to place an order.
//
// 	--Used on 10.1 tablets
//
//  This class will display the Ginger Delivery Service that will give the user the ability to
// 	pick a date and then confirm the date picked for teh delivery of the food.
//*************************************************************************
package net.androidbootcampb.wildgingerdinnerdelivery;

import java.text.DateFormat;
import java.util.Calendar;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private Button btnPickTime, btnConfim;
	private Calendar c;
	private TextView txtViewConfrim, txtVuewTime;
	private DateFormat fmtTime;
	private boolean timeSet;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intVar();

		// displays the date picker for the user to pick a time
        btnPickTime.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0)
			{
				timeSet = false;
				txtViewConfrim.setVisibility(View.INVISIBLE);
				new TimePickerDialog(MainActivity.this, 
						T, 
						c.get(Calendar.HOUR), 
						c.get(Calendar.MINUTE), 
						false).show();
			}
		});

		// confirms the tiem picked. Time can only be between 5 - 11 pm
        btnConfim.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{			
				if (timeSet)
				{
					if (c.get(Calendar.AM_PM) == Calendar.PM 
							&& (c.get(Calendar.HOUR) >= 5 && c.get(Calendar.HOUR) <= 11))
					{
						if (c.get(Calendar.HOUR) == 11 && c.get(Calendar.MINUTE) > 0)
						{
							Toast.makeText(MainActivity.this, "Please enter a time between 5 pm and 11 pm", Toast.LENGTH_SHORT).show();
						}
						else
						{
							txtViewConfrim.setVisibility(View.VISIBLE);
						}
					}
					else
					{
						Toast.makeText(MainActivity.this, "Please enter a time between 5 pm and 11 pm", Toast.LENGTH_SHORT).show();
					}
				}
				
			}
		});
        
        
    }
    
	TimePickerDialog.OnTimeSetListener T = new TimePickerDialog.OnTimeSetListener() 
	{
		/**
		 * Sets teh time the user picked and displays it on screen
		 *
		 * @param view
		 * @param hourOfDay
		 * @param minute
		 */
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute)
		{
			c.set(Calendar.HOUR_OF_DAY, hourOfDay);
			c.set(Calendar.MINUTE, minute);
			txtVuewTime.setText("Your Delivery Time is: " + fmtTime.format(c.getTime()));
			timeSet = true;
		}
	};

    private void intVar()
    {
    	btnConfim = (Button)findViewById(R.id.btnContrim);
    	btnPickTime = (Button)findViewById(R.id.button1);
    	txtViewConfrim = (TextView)findViewById(R.id.textViewConfrim);
    	txtVuewTime = (TextView)findViewById(R.id.textViewTime);
    	c = Calendar.getInstance();
    	fmtTime = DateFormat.getTimeInstance(DateFormat.SHORT);
    	timeSet = false;
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
