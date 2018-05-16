package com.tamim.profilemanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class ProfileManagerService extends Service implements SensorEventListener   {

	SensorManager sensorManager;
	Sensor sensor,se;
	AudioManager audioManager;
	float prox;
	Boolean flag=true;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		se= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this,sensor, sensorManager.SENSOR_DELAY_NORMAL);
		sensorManager.registerListener(this,se, sensorManager.SENSOR_DELAY_NORMAL);

		audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
		
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();;
		return START_STICKY;
	}
	
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		sensorManager.unregisterListener(this);
		Toast.makeText(getApplicationContext(), "Service Stoped", Toast.LENGTH_SHORT).show();;
	}
	
	
	void offVribrate(){
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		//int x=myAudioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
		//Log.d("My", "ans"+x);
		
		//myAudioManager.adjustVolume(myAudioManager.ADJUST_RAISE, myAudioManager.FLAG_PLAY_SOUND);
    	audioManager.setStreamVolume(AudioManager.STREAM_RING,audioManager.getStreamMaxVolume(AudioManager.STREAM_RING), AudioManager.FLAG_PLAY_SOUND);
		Vibrator myVibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		myVibrator.cancel();
	}
	void silent(){
		audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    	Vibrator myVibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		myVibrator.cancel();
	
		
	}
	public void vibrate(){
		audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		audioManager.setStreamVolume(AudioManager.STREAM_RING, 0, 0);
	}
	
	
	

	@Override
	public void onSensorChanged(SensorEvent event) {
		Sensor ss=event.sensor;
		if(ss.getType()==Sensor.TYPE_PROXIMITY){
			prox=event.values[0];
		}
		
		if(ss.getType()==Sensor.TYPE_ACCELEROMETER){
			if(event.values[0]*100 < 150 && event.values[1]*100 <40 &&event.values[1]*100 >-70 && event.values[2]*100>900 )
			{
				
				
					vibrate();
					//screen();
					Log.d("TA", "IMA");
					//flag=false;
				
					
			}else if(event.values[0]*100 < 40 && event.values[0]*100 > -40 && event.values[1]*100 <100 && event.values[1]*100>-200 && event.values[2]*100<-950 && event.values[2]*100>-1050 &&prox==3){
				
				//if(flag==false){
					silent();
					//screen1();
					//flag=true;
				//}
			}else{
				offVribrate();
			}
		}
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

}


	