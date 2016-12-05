package eu.delpi.washer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.delpi.washer.Distant.ApiServiceItf;
import eu.delpi.washer.Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    protected final static String TAG = "MainAcivity";
    public static Retrofit retrofit;

    @BindView(R.id.tv_nextwasher_name)TextView tvWasherName;
    @BindView(R.id.fab_history)FloatingActionButton fabHistory;
    @BindView(R.id.toolbar)Toolbar toolbar;

    ApiServiceItf serviceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://washerapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        serviceApi = retrofit.create(ApiServiceItf.class);

        Call<String> call = serviceApi.getNext();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tvWasherName.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @OnClick(R.id.fab_history)
    protected void onClickHistoryFab(){
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_done)
    protected void onClickDone(){

        User u = new User();
        u.setName(tvWasherName.getText().toString());

        Call<String> call = serviceApi.postWash(u, false);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tvWasherName.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @OnClick(R.id.button_afk)
    protected void onClickAfk(){

        User u = new User();
        u.setName(tvWasherName.getText().toString());

        Call<String> call = serviceApi.postWash(u, true);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tvWasherName.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


}
