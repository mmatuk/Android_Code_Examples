//************************************************************************
//	MainActivity.java 								Matt Matuk
// 	CSIT 268
//
//  This app will show the ability to create animations.
//
//  The app will allow the user to use either a frame or tween animation
//  Tween will rotate 5 times.
//*************************************************************************
package net.androidbootcamp.waveanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity 
{
	AnimationDrawable surfAnimation;
	ImageView imgFrame;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgFrame = (ImageView) findViewById(R.id.imgSurf);
        imgFrame.setBackgroundResource(R.drawable.animation);
        
        surfAnimation = (AnimationDrawable) imgFrame.getBackground();
        
        Button btnFrame = (Button) findViewById(R.id.btnStart);
        Button btnTween = (Button) findViewById(R.id.btnStop);

        // user selected teh frame animation
        btnFrame.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v)
			{			
				surfAnimation.start();
			}
		});

        // user selected teh tween animation
        btnTween.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v)
			{
				surfAnimation.stop();
				rotate();
				//startActivity(new Intent(MainActivity.this, Tween.class));
			}
		});
    }

    /**
     * Rotates the picture when teh user clicks the tween animaiton
     */
    public void rotate()
    {
		imgFrame.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));
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
