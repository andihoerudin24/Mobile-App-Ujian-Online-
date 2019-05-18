package com.tutorkomputer.ujianonlinerevisi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorkomputer.ujianonlinerevisi.DetailSiswaActivity;
import com.tutorkomputer.ujianonlinerevisi.R;
import com.tutorkomputer.ujianonlinerevisi.data.model.Siswa;

import java.util.List;

public class SiswaAdapter  extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {
    private List<Siswa.Data> siswa;
    Context context;

    public SiswaAdapter(Context context, List<Siswa.Data> data){
        this.context= context;
        this.siswa  = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_siswa,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
       // viewHolder.nama.setText(siswa.get(i).getNama());
        int id      = siswa.get(i).getId();
      //  int benar   = siswa.get(i).getBenar();
//        int salah   = siswa.get(i).getSalah();
//        int kosong  = siswa.get(i).getKosong();


       // viewHolder.benar.setText(String.valueOf(benar));
        viewHolder.id.setText(String.valueOf(id));
//        viewHolder.salah.setText(String.valueOf(salah));
//        viewHolder.kosong.setText(String.valueOf(kosong));
        viewHolder.hasil.setText(siswa.get(i).getNilai());

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailSiswaActivity.class);
                intent.putExtra("ID",siswa.get(i).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return siswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView benar,hasil,id;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           // nama =itemView.findViewById(R.id.nama);
          //  benar =itemView.findViewById(R.id.benar);
//            salah =itemView.findViewById(R.id.salah);
//            kosong =itemView.findViewById(R.id.kosong);
            hasil =itemView.findViewById(R.id.hasil);
            id =itemView.findViewById(R.id.id);
            image =itemView.findViewById(R.id.image);



        }
    }
}
