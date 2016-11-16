package com.dws_solutions.retrofittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.dws_solutions.retrofittest.adapters.DataAdapter;
import com.dws_solutions.retrofittest.entity.Company;
import com.dws_solutions.retrofittest.entity.ResponseCompany;
import com.dws_solutions.retrofittest.network.NetworkUtils;
import com.dws_solutions.retrofittest.network.ServiceGenerator;
import com.dws_solutions.retrofittest.network.TestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ArrayList<Company> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text_view);

        // Check Network
        if (NetworkUtils.isNetworkAvailable(this)){
            textView.setText("Network Available");
            // Toast.makeText(this, "Network available", Toast.LENGTH_SHORT).show();
        } else {
            textView.setText("Network NOT Available");
            // Toast.makeText(this, "Network NOT available", Toast.LENGTH_SHORT).show();
        }

        initViews();

    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getCompanies();
    }

    private void getCompanies(){
        TestClient testClient = ServiceGenerator.createService(TestClient.class, AppConfig.API_USER, AppConfig.API_KEY);

        Call<ResponseCompany> call = testClient.getCompanies();

        call.enqueue(new Callback<ResponseCompany>() {
            @Override
            public void onResponse(Call<ResponseCompany> call, Response<ResponseCompany> response) {

                if (response.code() == 200) {
                    Log.v(TAG, response.body().getCompanies().toString() );

                    ResponseCompany companies = response.body();
                    data = new ArrayList<>( companies.getCompanies());
                    adapter = new DataAdapter(data);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseCompany> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Network problem: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                Log.e("Main", "Network problem: " + t.getLocalizedMessage());
            }
        });

    }

}