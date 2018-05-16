package com.tamim.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		EditText e= (EditText) findViewById(R.id.editText2);
		double d=getIntent().getDoubleExtra("aa", 0);
		e.setText(String.valueOf(d));
	}
	

}
