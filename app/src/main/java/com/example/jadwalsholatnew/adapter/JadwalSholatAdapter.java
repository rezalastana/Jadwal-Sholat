package com.example.jadwalsholatnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholatnew.R;
import com.example.jadwalsholatnew.model.jadwal.DataItem;

import java.util.ArrayList;

public class JadwalSholatAdapter extends RecyclerView.Adapter<JadwalSholatAdapter.viewHolder> {

    private ArrayList<DataItem> timings = new ArrayList<>();
    private Context context;


    public JadwalSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        timings.clear();
        timings.addAll(items);
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public JadwalSholatAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSholatAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return timings.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView tv_fajr_value,tv_dhuhr_value, tv_asr_value, tv_maghrib_value, tv_isha_value, tv_imsak_value;
        CardView cv_item;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            cv_item = itemView.findViewById(R.id.itemlist_cv);
            tv_fajr_value = itemView.findViewById(R.id.tv_fajr_value);
            tv_dhuhr_value = itemView.findViewById(R.id.tv_dhuhr_value);
            tv_asr_value = itemView.findViewById(R.id.tv_asr_value);
            tv_maghrib_value = itemView.findViewById(R.id.tv_maghrib_value);
            tv_isha_value = itemView.findViewById(R.id.tv_isha_value);
            tv_imsak_value = itemView.findViewById(R.id.tv_imsak_value);

        }
    }
}
