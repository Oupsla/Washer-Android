package eu.delpi.washer;

import android.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.delpi.washer.Adapter.HistoryAdapter;
import eu.delpi.washer.Distant.ApiServiceItf;
import eu.delpi.washer.Model.Remote.UserRemote;
import eu.delpi.washer.Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG = "HistoryActivity";
    ApiServiceItf serviceApi;

    @BindView(R.id.recyclerview_history) RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userList = new ArrayList<User>();
        serviceApi = MainActivity.retrofit.create(ApiServiceItf.class);

        Call<List<UserRemote>> call = serviceApi.getUsers();
        call.enqueue(new Callback<List<UserRemote>>() {
            @Override
            public void onResponse(Call<List<UserRemote>> call, Response<List<UserRemote>> response){
                for (UserRemote userRemote: response.body()) {
                    userList.add(userRemote.toUser());
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UserRemote>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HistoryAdapter(getApplicationContext(), userList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
