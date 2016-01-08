//**************************************************************************************************
//	MainActivity.java 								Matt Matuk
// 	CSIT 268										Project 6-6
//	Get creative! Play your favorite three songs on your own personal playlist app.
//
//		1.	Create an app that opens with your own picture and a title for six seconds.
//		2.	The second screen shows three buttons displaying different song titles and an image of
// 			the artist or group.
//		3.	Each song can play and pause on the user’s selection.
//		4.	The app uses a double linked circle list to allow the user to select different songs
// 			to play
//
//***************************************************************************************
package net.androidbootcamp.yourpersonalplaylist;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
{
	private Song current;
	private DoubleOrderList<Song> songs;
	private TextView txtSongName;
	private Button btnPlayPause, btnNext, btnPrevious;
	private ImageView picture;
	private MediaPlayer song;
	private int songPlaying;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		start();
		CreateSongs();
		current = songs.first();
		setScreenDisplay();

		// determines whether to start or stop the selected song
		btnPlayPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v)
			{
				if (btnPlayPause.getText().equals(getString(R.string.txtPause)))
				{
					btnPlayPause.setText(R.string.txtPlay);
					song.pause();
				}
				else
				{
					btnPlayPause.setText(R.string.txtPause);
					setMediaPlayer();
					song.start();
					songPlaying = current.getSong();
				}
			}
		});

		// changes to the next song
		btnNext.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v)
			{
				current = songs.find(current).getNext().getElement();
				setScreenDisplay();
				
				if (song.isPlaying() && (songPlaying == current.getSong()))
				{
					btnPlayPause.setText(R.string.txtPause);
				}
				else
				{
					btnPlayPause.setText(R.string.txtPlay);
				}
			}
		});

		// changes to the previous song
		btnPrevious.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v)
			{
				current = songs.find(current).getPrevious().getElement();
				setScreenDisplay();
				
				if (song.isPlaying() && (songPlaying == current.getSong()))
				{
					btnPlayPause.setText(R.string.txtPause);
				}
				else
				{
					btnPlayPause.setText(R.string.txtPlay);
				}
			}
		});

	}

	/**
	 * Sets the current selected song to the song in the media player
	 */
	private void setMediaPlayer()
	{
		song.release();
		song = MediaPlayer.create(this, current.getSong());
	}

	/**
	 * Sets all the vars for the app
	 */
	private void start()
	{
		txtSongName = (TextView) findViewById(R.id.txtViewSongName);
		btnPlayPause =  (Button) findViewById(R.id.btnPlayPause);
		btnNext =  (Button) findViewById(R.id.btnNext);
		btnPrevious =  (Button) findViewById(R.id.btnPrevious);
		picture =  (ImageView) findViewById(R.id.ImgViewPicture);
		song = new MediaPlayer();
		songPlaying = 0;
	}

	/**
	 * Creates all the songs that will be available in the app to select
	 */
	private void CreateSongs()
	{
		songs = new DoubleOrderList<Song>();
		
		try
		{
			songs.add(new Song(getString(R.string.txtQueen), R.string.txtQueen, R.drawable.queen, R.string.queen, R.raw.queen));
			songs.add(new Song(getString(R.string.txtZeppelin), R.string.txtZeppelin, R.drawable.zeppelin, R.string.zepplin, R.raw.zepplin));
			songs.add(new Song(getString(R.string.txtClearwater), R.string.txtClearwater, R.drawable.clearwater, R.string.clearwater, R.raw.clearwater));
			songs.add(new Song(getString(R.string.txtWho), R.string.txtWho, R.drawable.who, R.string.who, R.raw.who));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Displays the current selected song
	 */
	private void setScreenDisplay()
	{
		txtSongName.setText(current.getName());
		picture.setImageResource(current.getPicture());
		picture.setContentDescription(getString(current.getPicDes()));
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
