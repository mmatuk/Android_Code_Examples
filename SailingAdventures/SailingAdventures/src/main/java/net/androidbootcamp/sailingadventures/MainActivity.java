//************************************************************************
//	MainActivity.java 								Matt Matuk
// 	CSIT 268
//
//  This app will show the ability to the date picker.
//
//  --Used on 10.1 Tablets
//
//  This class will allow the user to pick a date to determine when tio sail
//*************************************************************************
package net.androidbootcamp.sailingadventures;

import java.text.DateFormat;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private TextView reservation;
	Calendar c = Calendar.getInstance();
	DateFormat fmtDate = DateFormat.getDateInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        reservation = (TextView)findViewById(R.id.txtRes);
        Button btDate = (Button)findViewById(R.id.btnDate);

        // display the date picker
        btDate.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{
				new DatePickerDialog(MainActivity.this, d, 
						c.get(Calendar.YEAR), 
						c.get(Calendar.MONTH), 
						c.get(Calendar.DAY_OF_MONTH)).show();;
			}
		});

    }

    // date picker to pick a sailing day
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() 
	{
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth)
		{
			c.set(Calendar.YEAR, year);
			c.set(Calendar.MONTH, monthOfYear);
			c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			reservation.setText("Your reservation is set for " + fmtDate.format(c.getTime()));
		}
	};


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
