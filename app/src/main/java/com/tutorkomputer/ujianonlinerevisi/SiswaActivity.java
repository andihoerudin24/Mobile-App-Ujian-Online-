package com.tutorkomputer.ujianonlinerevisi;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tutorkomputer.ujianonlinerevisi.adapter.SiswaAdapter;
import com.tutorkomputer.ujianonlinerevisi.data.model.Siswa;
import com.tutorkomputer.ujianonlinerevisi.rest.Api;
import com.tutorkomputer.ujianonlinerevisi.rest.Apiinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiswaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);

        recyclerView=findViewById(R.id.recyclerView);
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setAdapter(null);
                getHasil();
            }
        });
        getHasil();
    }



    private void getHasil(){
        swipeRefreshLayout.setRefreshing(true);
        Apiinterface apiinterface= Api.getUrl().create(Apiinterface.class);
        Call<Siswa> call         =apiinterface.gethasil();
        call.enqueue(new Callback<Siswa>() {
            @Override
            public void onResponse(Call<Siswa> call, Response<Siswa> response) {
                Siswa siswa =response.body();
                List<Siswa.Data> siswas = siswa.getHasil();
                Log.e("_hasil",String.valueOf(siswas.size()));
                recyclerView.setAdapter(new SiswaAdapter(SiswaActivity.this,siswas));

                for (int i=0; i<siswas.size(); i++){
                    Log.e("_nama",siswas.get(i).getNama());
                }

                swipeRefreshLayout.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<Siswa> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
