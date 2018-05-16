package android.example.com.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Firebase mRef;
    Boolean flag;
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);
        flag=true;
        mRef= new Firebase("https://better-environment-master.firebaseio.com/sensor/");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                Double s= dataSnapshot.getValue(Double.class);
                //Object o = dataSnapshot.getValue(Object.class);
//                Log.d("test",s);
                if(flag== true) {
                    dataModels = new ArrayList<>();
                    int i = 0;
                    for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {


                        Double co2 = (Double) messageSnapshot.child("CO2").getValue();
                        Double humidity = (Double) messageSnapshot.child("humidity").getValue();
                        Double feels = (Double) messageSnapshot.child("Feels Like").getValue();
                        Double temperature = (Double) messageSnapshot.child("temperature").getValue();
                        String time = (String) messageSnapshot.child("Time").getValue();
                        String date = (String) messageSnapshot.child("Date").getValue();
                        dataModels.add(new DataModel(co2, date, feels, time, humidity, temperature));


                    }

                    adapter = new CustomAdapter(dataModels, getApplicationContext());
                    listView.setAdapter(adapter);
                    flag=false;
                    startCounter();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(getApplicationContext(), "err", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void  startCounter(){
        new CountDownTimer(500000, 1000) {

            public void onTick(long millisUntilFinished) {
//                Toast.makeText(getApplicationContext(),"t",Toast.LENGTH_SHORT).show();
            }

            public void onFinish() {
                flag=true;

            }
        }.start();
    }
}
