package android.example.com.myapplication;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by TAMIM_ on 2/8/18.
 */
public class FireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
