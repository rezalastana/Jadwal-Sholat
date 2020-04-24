package com.example.jadwalsholatnew.view.fragmen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalsholatnew.R;
import com.example.jadwalsholatnew.adapter.JadwalSholatAdapter;
import com.example.jadwalsholatnew.model.jadwal.DataItem;
import com.example.jadwalsholatnew.view.viewmodel.JadwalViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment extends Fragment {

    private JadwalSholatAdapter jadwalSholatAdapter;
    private RecyclerView rvJadwalSholat;
    private JadwalViewModel jadwalViewModel;

    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jadwalSholatAdapter = new JadwalSholatAdapter(getContext());
        jadwalSholatAdapter.notifyDataSetChanged();

        rvJadwalSholat = view.findViewById(R.id.fragmentjadwal_rv);
        rvJadwalSholat.setLayoutManager(new GridLayoutManager(getContext(),2));

        jadwalViewModel = new ViewModelProvider(this).get(JadwalViewModel.class);
        jadwalViewModel.setJadwalSholat();
        jadwalViewModel.getJadwaSholat().observe(this,getJadwalSholat);


        rvJadwalSholat.setAdapter(jadwalSholatAdapter);
    }

    private Observer<ArrayList<DataItem>> getJadwalSholat = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null){
                jadwalSholatAdapter.setData(dataItems);
            }
        }
    };
}
