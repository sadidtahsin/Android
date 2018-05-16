package com.tamim.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
    }
    private SharedPreferences prefs;
    private String prefName="Mypref";
    
    
    String s;
    double ans=0;
    
    public void number(View v) {
    	//Button b= (Button) v;
    	EditText et = (EditText) findViewById(R.id.editText1);
    	
    	
    	et.append("1");
    	
		
	}
    
    public void operationAdd(View v) {
    	EditText et = (EditText) findViewById(R.id.editText1);
    	s=et.getText().toString();
    	ans += Double.parseDouble(s);
    	et.setText("");
	}
    
    public void equalTo(View v)
    {
    	EditText et = (EditText) findViewById(R.id.editText1);
    	s=et.getText().toString();
    	ans += Double.parseDouble(s);
    	et.setText(String.valueOf(ans));
    }
    
    public void AAA(View v) {
    	Intent intent=new Intent("com.tamim.Activity2");
    	intent.putExtra("aa", ans);
    	startActivity(intent);
		
	}
    
    public void memoryAdd(View v) {
    	EditText et = (EditText) findViewById(R.id.editText1);
    	s=et.getText().toString();
    	ans = Double.parseDouble(s);
    	prefs= getSharedPreferences(prefName, MODE_PRIVATE);
    	SharedPreferences.Editor editor=prefs.edit();
    	editor.putString("Data", et.getText().toString());
    	editor.commit();
    	et.setText("");
    	
	}
    
    public void memoryEr(View v) {
		
	}
    
    public void memoryGet(View v) {
		
		prefs= getSharedPreferences(prefName, MODE_PRIVATE);
		String sa= prefs.getString("Data", "0");
		EditText et = (EditText) findViewById(R.id.editText1);
		et.setText(sa);
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
    
    
}
