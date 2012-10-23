package com.example.preferencesexample;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {
	
	public static final String PREF_COLOR = "pref_color";
	public static final String PREF_IMAGE = "pref_image";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Load preferences.
		addPreferencesFromResource(R.xml.preferences);
	}
	
}
