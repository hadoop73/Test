package com.api.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.api.R;

public class Tab4Activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.example_activity);
		
		TextView tv = (TextView) findViewById(R.id.example_tv);
		tv.setText("This is Example 4 Activity");
	}
}
