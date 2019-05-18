package com.tutorkomputer.ujianonlinerevisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorkomputer.ujianonlinerevisi.data.model.CallResponse;
import com.tutorkomputer.ujianonlinerevisi.data.model.SignResponse;
import com.tutorkomputer.ujianonlinerevisi.rest.Api;
import com.tutorkomputer.ujianonlinerevisi.rest.Apiinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignActivity extends AppCompatActivity {

    EditText name,email,password;
    Button btn_sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn_sign=findViewById(R.id.btn_sign);

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sign();
            }
        });


    }


    private void Sign(){
        Apiinterface apiinterface = Api.getUrl().create(Apiinterface.class);
        Call<SignResponse> call =apiinterface.SignUser(name.getText().toString()
                                                        ,email.getText().toString()
                                                        ,password.getText().toString()
                                                        ,AuthActivity.ANDORID_ID);
        call.enqueue(new Callback<SignResponse>() {
            @Override
            public void onResponse(Call<SignResponse> call, Response<SignResponse> response) {
                   if(response.body().getStatus().equals("success")){
                       Toast.makeText(getApplicationContext(),"Anda Berhasil Mendaftar Silahkan Login",Toast.LENGTH_LONG).show();
                       Intent gotoauth= new Intent(SignActivity.this,AuthActivity.class);
                       startActivity(gotoauth);
                   }
            }

            @Override
            public void onFailure(Call<SignResponse> call, Throwable t) {

            }
        });

    }
}
