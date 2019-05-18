package com.tutorkomputer.ujianonlinerevisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailSiswaActivity extends AppCompatActivity {

   Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_siswa);

        bundle = getIntent().getExtras();
        Log.e("_lognama",String.valueOf(bundle.getInt("ID")));
    }
}
