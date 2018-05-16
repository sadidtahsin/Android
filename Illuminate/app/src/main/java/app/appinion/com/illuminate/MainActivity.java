package app.appinion.com.illuminate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  {

    EditText user_id,user_pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_id=(EditText) findViewById(R.id.user_id);
        user_pass=(EditText) findViewById(R.id.user_pass);



    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_btn:
                Intent intent= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
        }
    }



}


