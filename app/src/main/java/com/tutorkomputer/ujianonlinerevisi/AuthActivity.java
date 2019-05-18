package com.tutorkomputer.ujianonlinerevisi;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorkomputer.ujianonlinerevisi.data.model.CallResponse;
import com.tutorkomputer.ujianonlinerevisi.rest.Api;
import com.tutorkomputer.ujianonlinerevisi.rest.Apiinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    public static String ANDORID_ID;

    TextView signup;
    EditText input_email,input_password;
    Button btn_login;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        input_email=findViewById(R.id.input_email);
        input_password=findViewById(R.id.input_password);
        progressBar=findViewById(R.id.progressBar);

        //MENDAPATKAN ANDROID ID
        ANDORID_ID = Settings.Secure.getString(this.getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID);
        //Log.e("andorid_id",ANDORID_ID);

        signup    =findViewById(R.id.signup);
        btn_login = findViewById(R.id.btn_login_auth);

        //daftar
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"BERPINDAH AKTIFITI",Toast.LENGTH_LONG).show();
                Intent sign = new Intent(AuthActivity.this,SignActivity.class);
                startActivity(sign);
            }
        });

        //login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"BERPINDAH AKTIFITI",Toast.LENGTH_LONG).show();
                //Intent main = new Intent(AuthActivity.this,HomeActivity.class);
                //startActivity(main);
                Auth();

            }
        });
    }

    private void Auth(){
        progressBar.setVisibility(View.VISIBLE);
        Apiinterface apiinterface = Api.getUrl().create(Apiinterface.class);
        Call<CallResponse> call =apiinterface.postAuth(input_email.getText().toString(),input_password.getText().toString());
        call.enqueue(new Callback<CallResponse>() {
            @Override
            public void onResponse(Call<CallResponse> call, Response<CallResponse> response) {
//                        Log.e("_logUser", response.toString());
//                        Log.e("_logResponse", response.body().getStatus());
                if (response.body().getStatus().equals("success")){
                    Intent main = new Intent(AuthActivity.this,HomeActivity.class);
                    startActivity(main);
                }else{
                    Toast.makeText(getApplicationContext(),"username dan password Yang Anda Masukan Salah",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<CallResponse> call, Throwable t) {

                Log.e("_error",t.toString());
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
