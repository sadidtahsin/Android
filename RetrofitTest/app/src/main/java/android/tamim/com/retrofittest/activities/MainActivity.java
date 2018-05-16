package android.tamim.com.retrofittest.activities;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.tamim.com.retrofittest.R;
import android.tamim.com.retrofittest.adapters.RecycleAdapter;
import android.tamim.com.retrofittest.apis.ApiClient;
import android.tamim.com.retrofittest.interfaces.ApiInterface;
import android.tamim.com.retrofittest.models.Posts;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private static final int REQUEST_INTERNET = 200;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecycleAdapter adapter;
    List<Posts> posts;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"tr",Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android M Permission check
            Toast.makeText(getApplicationContext(),"tr",Toast.LENGTH_LONG).show();
            if (this.checkSelfPermission(android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("This app needs location access");
                builder.setMessage("Please grant location access so this app can detect beacons.");
                builder.setPositiveButton(android.R.string.ok, null);
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {

                    public void onDismiss(DialogInterface dialog) {
                        requestPermissions(new String[]{android.Manifest.permission.INTERNET}, 1);
                    }
                });
                builder.show();
            }
        }


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Posts>> call = apiInterface.getPosts();
        Toast.makeText(getApplicationContext(),call.toString()+" call",Toast.LENGTH_LONG).show();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                Toast.makeText(getApplicationContext(),"sa",Toast.LENGTH_SHORT).show();
                posts = response.body();
                adapter = new RecycleAdapter(posts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), " failed",Toast.LENGTH_SHORT).show();
            }
        });

    }



}
