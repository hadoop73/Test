package com.api.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.api.R;

public class Tab5Activity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.example_activity);

		TextView tv = (TextView) findViewById(R.id.example_tv);
		tv.setText("This is Example 5 Activity");
	}
}
