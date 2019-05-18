package com.tutorkomputer.ujianonlinerevisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    LinearLayout biodata,siswa,nilai,ujian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        biodata =findViewById(R.id.biodata);
        siswa =findViewById(R.id.siswa);
        nilai =findViewById(R.id.nilai);
        ujian =findViewById(R.id.ujian);
        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoBiodata = new Intent(HomeActivity.this,BiodataActivity.class);
                startActivity(gotoBiodata);
            }
        });
        siswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SiswaActivity.class);
                startActivity(intent);
            }
        });

        nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,NilaiActivity.class);
                startActivity(intent);

            }
        });
        ujian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
