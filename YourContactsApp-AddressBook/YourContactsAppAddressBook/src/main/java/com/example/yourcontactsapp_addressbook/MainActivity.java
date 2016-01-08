//**************************************************************************************************
//	MainActivity.java 								Matt Matuk
// 	CSIT 268					        			Project
//
//  This app provides contact information in an address book. Create two screens for contacts for
//  the app. The user will be able to select a contact and then the app will display the contacts
//  information.
//
//      1.  The opening screen will display two different contacts with the last name starting
//          with the letter J. Each contact will have a separate Button control below the name.
//
//      2.  The second screen displays the name, address, phone number and picture of the
//          contact selected.
//**************************************************************************************************
package com.example.yourcontactsapp_addressbook;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnJackson = (Button) findViewById(R.id.btnJackson);
        Button btnJohnson = (Button) findViewById(R.id.btnJohnson);

        // Button action to go to the Jackson contact screen
        btnJackson.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, Jackson.class));
			}
		});

        // Button to go to the Johnson screen
        btnJohnson.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, Johnson.class));

			}
		});

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
