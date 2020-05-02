package com.example.jadwalsholatnew.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholatnew.MainContract;
import com.example.jadwalsholatnew.R;
import com.example.jadwalsholatnew.entity.DataNgaji;

import java.util.List;

public class NgajiAdapter extends RecyclerView.Adapter<NgajiAdapter.viewHolder> {
    Context context;
    List<DataNgaji> list;
    MainContract.view view;

    public NgajiAdapter(Context context, List<DataNgaji> list, MainContract.view view) {
        this.view = view;
        this.context = context;
        this.list = list;
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvJuz, tvSurat, tvAyat, id;
        CardView cardView;

        public viewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_value);
            tvJuz = itemView.findViewById(R.id.tv_juz_value);
            tvSurat = itemView.findViewById(R.id.tv_surat_value);
            tvAyat = itemView.findViewById(R.id.tv_ayat_value);
            id = itemView.findViewById(R.id.tv_id_value);
            cardView = itemView.findViewById(R.id.cv_item_ngaji);
        }
    }

    @NonNull
    @Override
    public NgajiAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ngaji, parent, false);
        return new viewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final NgajiAdapter.viewHolder holder, int position) {
        final DataNgaji item = list.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvJuz.setText(item.getJuz());
        holder.tvSurat.setText(item.getSurat());
        holder.tvAyat.setText(item.getAyat());
        holder.id.setText(String.valueOf(item.getId()));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
