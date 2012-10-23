package com.example.preferencesexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout layout;
	private ImageView imageView;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        layout = (RelativeLayout) findViewById(R.id.mainLayout);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
	
	@Override
	protected void onStart() {
		super.onStart();
		
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        
        String colorPreference = sharedPref.getString(SettingsActivity.PREF_COLOR, "white");
        boolean onOffImage = sharedPref.getBoolean(SettingsActivity.PREF_IMAGE, false);
        
        changeBackgroundColor(colorPreference);
        toggleActivityImage(onOffImage);
	}
	
	private void toggleActivityImage(boolean onOff) {
		if(onOff) {
			imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
		}
		else {
			SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
	        String newColor = sharedPref.getString(SettingsActivity.PREF_COLOR, "white");
	        if(newColor.equalsIgnoreCase("black")) {
	    		imageView.setBackgroundColor(getResources().getColor(android.R.color.black));
	    	}
	    	else {
	    		imageView.setBackgroundColor(getResources().getColor(android.R.color.white));
	    	}
		}
	}
    
    private void changeBackgroundColor(String newColor) {
    	if(newColor.equalsIgnoreCase("black")) {
    		layout.setBackgroundColor(getResources().getColor(android.R.color.black));
    	}
    	else {
    		layout.setBackgroundColor(getResources().getColor(android.R.color.white));
    	}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.menu_settings:
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    }
    
}
