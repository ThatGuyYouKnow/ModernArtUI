package course.project.modernartui;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class ModernArtUIActivity extends Activity {
	
	static private final String TAG = "ModernArtUI";
	
	// ID for menu item
	private static final int MENU_MORE_INFO = Menu.FIRST;
	
	private static final String DIALOG_MORE_INFO = "moreInfo";
	
	private final int INITIAL_RED = 255;
	private final int INITIAL_GREEN = 255;
	private final int INITIAL_BLUE = 255;
	
	 private TextView textViewRed; 
	 private TextView textViewBlue;
	 private TextView textViewGreen;
	 private TextView textViewYellow;
	 
	 private SeekBar colorBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_modern_art_ui);
		
		textViewRed = (TextView) findViewById(R.id.textViewRed);
		textViewBlue = (TextView) findViewById(R.id.textViewBlue);
		textViewGreen = (TextView) findViewById(R.id.textViewGreen);
		textViewYellow = (TextView) findViewById(R.id.textViewYellow);
		colorBar = (SeekBar) findViewById(R.id.seekBar1);
		colorBar.setMax(255);
		setColors(INITIAL_RED, INITIAL_GREEN, INITIAL_BLUE);
		
		colorBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				int newRed = progress;
				int newGreen = progress;
				int newBlue = progress;
				reDrawColors(newRed, newGreen, newBlue);
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		super.onCreateOptionsMenu(menu);
		
		menu.add(Menu.NONE, MENU_MORE_INFO, Menu.NONE, R.string.menu_more_informaion);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}*/
		switch (item.getItemId()) {
			case MENU_MORE_INFO:
				//displayMoreInfoDialog();
				MoreInfoFragment dialog = new MoreInfoFragment();
				dialog.show(getFragmentManager(), DIALOG_MORE_INFO);
				
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void setColors(int red, int green, int blue) {
		//Log.i(TAG,"Setting colors...");
		
		//Log.i(TAG, "TextViewRed = " + textViewRed);
		
		//textViewRed.setBackgroundColor(0xfff00000);
		textViewRed.setBackgroundColor(Color.rgb(red, 0, 0));
		textViewYellow.setBackgroundColor(Color.rgb(red,green,0));
		textViewBlue.setBackgroundColor(Color.rgb(0, 0, blue));
		textViewGreen.setBackgroundColor(Color.rgb(0, green, 0));
		
	}
	
	public void reDrawColors(int red, int green, int blue) {
		//Log.i(TAG,"Setting colors...");
		
		//Log.i(TAG, "TextViewRed = " + textViewRed);
		
		//textViewRed.setBackgroundColor(0xfff00000);
		textViewRed.setBackgroundColor(Color.rgb(INITIAL_RED, green, 0));
		textViewYellow.setBackgroundColor(Color.rgb(INITIAL_RED,INITIAL_GREEN, blue));
		textViewBlue.setBackgroundColor(Color.rgb(red, 0, INITIAL_BLUE));
		textViewGreen.setBackgroundColor(Color.rgb(0, INITIAL_GREEN, blue));
	}
}
