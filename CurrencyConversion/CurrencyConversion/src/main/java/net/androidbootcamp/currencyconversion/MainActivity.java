//*****************************************************************************
//	MainActivity.java							Matt Matuk 
//	3/14/15										App 4 Chapter 4 pg 171
//	Currency Convertion App
//	
//	Shows the ability to use a toast message, radio buttons, and Conditional
//	statements to change currency from one type to another.
//*****************************************************************************

package net.androidbootcamp.currencyconversion;

import java.text.DecimalFormat;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity 
{
	protected double conversionUSandEuro = 0.952650;
	protected double conversionUSandCanDol = 1.27840;
	protected double conversionUSandPeso= 15.4882;
	protected double conversionEuroandCanDol = 1.34194;
	protected double conversionEuroandPeso = 16.2580;
	protected double conversionCanDolandPeso = 12.1153;
	protected double amount, result; 
	protected String strResult;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtAmount = (EditText) findViewById(R.id.editTextAmount);
        final TextView txtResult = (TextView) findViewById(R.id.txtViewResult);
        final Spinner spinStart = (Spinner) findViewById(R.id.spinner1);
        final RadioGroup radGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        
        Button btnConvert = (Button) findViewById(R.id.btnConvert);
        
        btnConvert.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				amount = Double.parseDouble(txtAmount.getText().toString());
				String spinSelected = spinStart.getSelectedItem().toString();
				DecimalFormat cur = new DecimalFormat("###,###.##");

				if (spinSelected.equalsIgnoreCase("US Dollars"))
				{
					strResult = convertFromDollars(radGroup);
				}
				else if (spinSelected.equalsIgnoreCase("Euros"))
				{
					strResult = convertFromEuros(radGroup);
				}
				else if (spinSelected.equalsIgnoreCase("Pesos"))
				{
					strResult = convertfromPesos(radGroup);
				}
				else if (spinSelected.equalsIgnoreCase("Canadian Dollars"))
				{
					strResult = convertFromCanDollars(radGroup);
				}
				
				txtResult.setText((result != -1 ? cur.format(result) : "") + strResult);
			}
		});

    }

	/**
	 * Changes the currency from dollars to whichever curreny the user selected
	 * @param group
	 * @return
	 */
    private String convertFromDollars(RadioGroup group)
    {
    	if (amount < 100000)
    	{
	    	switch (group.getCheckedRadioButtonId())
	    	{
	    		case R.id.radBtnUSDollars :
	    		{
	    			result = amount;
	    			return " Dollars"; 
	    		}
	    		case R.id.radBtnCanDollars :
	    		{
	    			result = amount * conversionUSandCanDol;
	    			return " Canadian Dollars";
	    		}
	    		case R.id.radBtnEuro :
	    		{
	    			result = amount * conversionUSandEuro;
	    			return " Euros";
	    		}
	    		case R.id.radBtnPesos :
	    		{
	    			result = amount * conversionUSandPeso;
	    			return " Pesos";
	    		}
	    		default :
	    		{
	    			result = amount;
	    			return " Failed to convert";
	    		}
	    	}
    	}
    	else
    	{
    		Toast.makeText(MainActivity.this, 
    				"Please enter an amount less than $100,000.00", Toast.LENGTH_LONG).show();
    		result = -1;
    		return "";
    	}
    }

	/**
	 * Changes the currency from Canadians to whichever curreny the user selected
	 * @param group
	 * @return
	 */
    private String convertFromCanDollars(RadioGroup group)
    {
    	if (amount < 127837.11)
    	{
	    	switch (group.getCheckedRadioButtonId())
	    	{
	    		case R.id.radBtnUSDollars :
	    		{
	    			result = amount / conversionUSandCanDol;
	    			return " Dollars";
	    		}
	    		case R.id.radBtnCanDollars :
	    		{
	    			result = amount ;
	    			return " Canadian Dollars";
	    		}
	    		case R.id.radBtnEuro :
	    		{
	    			result = amount / conversionEuroandCanDol;
	    			return " Euros";
	    		}
	    		case R.id.radBtnPesos :
	    		{
	    			result = amount * conversionCanDolandPeso;
	    			return " Pesos";
	    		}
	    		default :
	    		{
	    			result = amount;
	    			return " Failed to convert";
	    		}
	    	}
    	}
    	else
    	{
    		Toast.makeText(MainActivity.this, 
    				"Please enter an amount less than 127,837.11 Canadian Dollars", 
    				Toast.LENGTH_LONG).show();
    		result =-1;
    		return "";
    	}
    }

	/**
	 * Changes the currency from Euros to whichever curreny the user selected
	 * @param group
	 * @return
	 */
    private String convertFromEuros(RadioGroup group)
    {
    	if (amount < 95265.00)
    	{
	    	switch (group.getCheckedRadioButtonId())
	    	{
	    		case R.id.radBtnUSDollars :
	    		{
	    			result = amount / conversionUSandEuro;
	    			return " Dollars";
	    		}
	    		case R.id.radBtnCanDollars :
	    		{
	    			result = amount * conversionEuroandCanDol;
	    			return " Canadian Dollars";
	    		}
	    		case R.id.radBtnEuro :
	    		{
	    			result = amount;
	    			return " Euros";
	    		}
	    		case R.id.radBtnPesos :
	    		{
	    			result = amount * conversionEuroandPeso;
	    			return " Pesos";
	    		}
	    		default :
	    		{
	    			result = amount;;
	    			return " Failed to convert";
	    		}
	    	}
    	}
    	else
    	{
    		Toast.makeText(MainActivity.this, 
    				"Please enter an amount less than 95,265.00 Euros", 
    				Toast.LENGTH_LONG).show();
    		result = -1;
    		return "";
    	}
    }

	/**
	 * Changes the currency from Pesos to whichever curreny the user selected
	 * @param group
	 * @return
	 */
    private String convertfromPesos(RadioGroup group)
    {
    	if (amount < 1548729.98)
    	{
	    	switch (group.getCheckedRadioButtonId())
	    	{
	    		case R.id.radBtnUSDollars :
	    		{
	    			result = amount / conversionUSandPeso;
	    			return " Dollars";
	    		}
	    		case R.id.radBtnCanDollars :
	    		{
	    			result = amount / conversionCanDolandPeso;
	    			return " Canadian Dollars";
	    		}
	    		case R.id.radBtnEuro :
	    		{
	    			result = amount / conversionEuroandPeso;
	    			return " Pesos";
	    		}
	    		case R.id.radBtnPesos :
	    		{
	    			result = amount;
	    			return " Pesos";
	    		}
	    		default :
	    		{
	    			result = amount;
	    			return " Failed to convert";
	    		}
	    	}
    	}
    	else
    	{
    		Toast.makeText(MainActivity.this, 
    				"Please enter an amount less than 1,548,729.98 Pesos", 
    				Toast.LENGTH_LONG).show();
    		result = -1;
    		return "";
    	}
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
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
