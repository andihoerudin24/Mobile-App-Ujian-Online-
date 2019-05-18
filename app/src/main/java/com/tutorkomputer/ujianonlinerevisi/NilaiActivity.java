package com.tutorkomputer.ujianonlinerevisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tutorkomputer.ujianonlinerevisi.data.model.NilaiResponse;
import com.tutorkomputer.ujianonlinerevisi.rest.Api;
import com.tutorkomputer.ujianonlinerevisi.rest.Apiinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NilaiActivity extends AppCompatActivity {
    TextView name,nilai,email,kelas,benar,kosong,nik_siswa,jenis_kelamin,salah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);
        name=findViewById(R.id.name);
        nilai=findViewById(R.id.nilai);
        email=findViewById(R.id.email);
        kelas=findViewById(R.id.kelas);
        benar=findViewById(R.id.benar);
        kosong=findViewById(R.id.kosong);
        salah=findViewById(R.id.salah);
        nik_siswa=findViewById(R.id.nik_siswa);
        jenis_kelamin=findViewById(R.id.jenis_kelamin);
        getNilai();
    }



    private void getNilai(){
        Apiinterface apiinterface =Api.getUrl().create(Apiinterface.class);
        Call<NilaiResponse> call =apiinterface.getNilai(AuthActivity.ANDORID_ID);
        call.enqueue(new Callback<NilaiResponse>() {
            @Override
            public void onResponse(Call<NilaiResponse> call, Response<NilaiResponse> response) {
                NilaiResponse nilaiResponse = response.body();
                List<NilaiResponse.Data> nilais =nilaiResponse.getData();
                Log.e("_lognilai",String.valueOf(nilais.size()));
                for (int i=0; i<nilais.size(); i++){
                    //int score = nilais.get(i).getScore();
                    int kelass = nilais.get(i).getKelas();
                    int benarr = nilais.get(i).getBenar();
                    int salahh = nilais.get(i).getSalah();
                    int kosongg = nilais.get(i).getKosong();

                    Log.e("_namanilai",nilais.get(i).getName());
                    name.setText(nilais.get(i).getName());
                    nilai.setText(nilais.get(i).getScore());
                    email.setText(nilais.get(i).getEmail());
                    kelas.setText(String.valueOf(kelass));
                    benar.setText(String.valueOf(benarr));
                    salah.setText(String.valueOf(salahh));
                    kosong.setText(String.valueOf(kosongg));
                    jenis_kelamin.setText(nilais.get(i).getJenis_kelamin());
                    nik_siswa.setText(nilais.get(i).getNik());
                }
             }
            @Override
            public void onFailure(Call<NilaiResponse> call, Throwable t) {
                Log.e("_Error",t.toString());
            }
        });

    }
}
