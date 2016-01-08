//*****************************************************************************
//	MainActivity.java							Matt Matuk 
//	3/14/15										Lab 4 Chapter 4
//	
//	Shows the ability to use a toast message, radio buttons, and Conditional
//	statements to change weight from pounds to either Kilograms or the other 
//	way around.
//*****************************************************************************

package net.androidbootcamp.medicalcalculator;

import java.text.DecimalFormat;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity 
{
	protected double conversionRate = 2.2; //Conversion rate for weight
	protected double weightEntered;
	protected double convertedWeight;

	/**
	 * When the app is started, the editText, textView, and radioButtons
	 * are created and made final so they can be used anywhere.
	 * When the convert button is pressed, the weight entered is converted
	 * into either pounds or kilograms depending on what the user entered.
	 * 
	 * @param Bundle
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = (RadioButton) findViewById(R.id.radLbToKilo);
        final RadioButton KiloToLb = (RadioButton) findViewById(R.id.radKiloToLb);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        
        Button btnConvert = (Button) findViewById(R.id.btnConvert);

        // converts the entered weight to teh selected weight
        btnConvert.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				weightEntered = Double.parseDouble(weight.getText().toString());
				DecimalFormat tenth = new DecimalFormat("#.#");
				
				if (lbToKilo.isChecked())
				{
					if (weightEntered <= 500) // User must enter less than this weight
					{
						convertedWeight = weightEntered / conversionRate;
						result.setText(tenth.format(convertedWeight) + " Kilograms");
					}
					else
					{
						Toast.makeText(MainActivity.this, 
								"Pounds entered must be less than 500:", Toast.LENGTH_LONG).show();
					}
				}
				if (KiloToLb.isChecked())
				{
					if (weightEntered <= 225) // user must enter less than this weight
					{
						convertedWeight = weightEntered * conversionRate;
						result.setText(tenth.format(convertedWeight) + " Pounds");
					}
					else
					{
						Toast.makeText(MainActivity.this, 
								"Kilos entered must be less than 225:", Toast.LENGTH_LONG).show();
					}
				}
			}
		});
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment 
    {

        public PlaceholderFragment() 
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) 
        {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
