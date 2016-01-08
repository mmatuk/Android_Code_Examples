//************************************************************************
//	MainActivity.java 								Matt Matuk
// 	CSIT 268
//
//  This app will display multiple photos of different animals in a grid view.
//
//	This class will display teh photos and when the user press on one, a toast message will
// 	display the selected animals infomation
//*************************************************************************
package net.androidbootcamp.endangeredspecies;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	Integer[] Animals = { R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla, 
			R.drawable.panda, R.drawable.panther, R.drawable.polar };
	ImageView pic;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gr = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        gr.setAdapter(new ImageAdapter(this));

		// display toast with selected animals info
        gr.setOnItemClickListener(new OnItemClickListener() 
        {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{
				Toast.makeText(
						getBaseContext(), 
						"Selected Species " + (arg2 +1), 
						Toast.LENGTH_SHORT).show();
				pic.setImageResource(Animals[arg2]);
			}
		});
    }

	/**
	 * Creates the grid view witht eh pictures
	 */
    public class ImageAdapter extends BaseAdapter
    {
    	private Context context;
    	
    	public ImageAdapter(Context c)
    	{
    		context = c;
    	}
		@Override
		public int getCount()
		{
			return Animals.length;
		}

		@Override
		public Object getItem(int arg0)
		{
			return null;
		}

		@Override
		public long getItemId(int arg0)
		{
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2)
		{
			pic = new ImageView(context);
			pic.setImageResource(Animals[arg0]);
			pic.setScaleType(ImageView.ScaleType.FIT_XY);
			pic.setLayoutParams(new GridView.LayoutParams(188,200));
			return pic;
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
}
