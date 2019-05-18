package com.tutorkomputer.ujianonlinerevisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tutorkomputer.ujianonlinerevisi.data.model.CallResponse;
import com.tutorkomputer.ujianonlinerevisi.data.model.UserResponse;
import com.tutorkomputer.ujianonlinerevisi.rest.Api;
import com.tutorkomputer.ujianonlinerevisi.rest.Apiinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class BiodataActivity extends AppCompatActivity {

    EditText name,no_hp_ortu,kelas,email,id;
    Button btn_edit;
    ProgressBar progresbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        name=findViewById(R.id.name);
        kelas=findViewById(R.id.kelas);
        no_hp_ortu=findViewById(R.id.no_hp_ortu);
        email=findViewById(R.id.email);
        btn_edit=findViewById(R.id.btn_edit);
        id=findViewById(R.id.id);
        progresbar=findViewById(R.id.progresbar);
        getBiodata();
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_data();
                Toast.makeText(getApplicationContext(),"Berhasil Rdit Data",Toast.LENGTH_LONG).show();
                progresbar.setVisibility(View.GONE);
                Intent intent = new Intent(BiodataActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });


    }

    private void getBiodata(){
        progresbar.setVisibility(View.VISIBLE);
        Apiinterface apiinterface =Api.getUrl().create(Apiinterface.class);
        Call<UserResponse> call =apiinterface.getDetail(AuthActivity.ANDORID_ID);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
               UserResponse.Data data = response.body().getData();
               id.setText(String.valueOf(data.getId()));
               name.setText(data.getName());
               kelas.setText(data.getKelas());
               email.setText(data.getEmail());
               no_hp_ortu.setText(data.getNo_hp_ortu());
               progresbar.setVisibility(View.GONE);
         }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    private void Edit_data(){
        progresbar.setVisibility(View.VISIBLE);
        Apiinterface apiinterface =Api.getUrl().create(Apiinterface.class);
        Call<UserResponse> call = apiinterface.upDateuser(id.getText().toString(),name.getText().toString(),
                                                          email.getText().toString(),
                                                          no_hp_ortu.getText().toString(),
                                                          kelas.getText().toString());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }


}
