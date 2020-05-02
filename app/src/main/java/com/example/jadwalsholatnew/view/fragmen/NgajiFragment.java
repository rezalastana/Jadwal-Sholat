package com.example.jadwalsholatnew.view.fragmen;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jadwalsholatnew.MainContract;
import com.example.jadwalsholatnew.MainPresenter;
import com.example.jadwalsholatnew.R;
import com.example.jadwalsholatnew.adapter.NgajiAdapter;
import com.example.jadwalsholatnew.entity.AppDatabase;
import com.example.jadwalsholatnew.entity.DataNgaji;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NgajiFragment extends Fragment implements MainContract.view {

    private AppDatabase appDatabase;
    private MainPresenter presenter;
    private NgajiAdapter adapter;

    private Button btnOK;
    private RecyclerView recyclerView;
    private EditText tvNama, tvJuz, tvSurat, tvAyat;
    private boolean edit = false;
    private int id = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ngaji, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appDatabase = appDatabase.iniDb(getContext());

        btnOK = view.findViewById(R.id.btn_submit);
        btnOK.setOnClickListener(this);
        tvNama = view.findViewById(R.id.et_nama);
        tvJuz = view.findViewById(R.id.et_juz);
        tvSurat = view.findViewById(R.id.et_surat);
        tvAyat = view.findViewById(R.id.et_ayat);
        recyclerView = view.findViewById(R.id.fragmentngaji_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter = new MainPresenter(this);

        presenter.readData(appDatabase);
    }

    @Override
    public void successAdd() {
        Toast.makeText(getContext(),"Berhasil", Toast.LENGTH_SHORT).show();
        presenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(getContext(),"Berhasil menghapus data", Toast.LENGTH_SHORT).show();
        presenter.readData(appDatabase);

    }

    @Override
    public void resetForm() {
        tvNama.setText("");
        tvJuz.setText("");
        tvSurat.setText("");
        tvAyat.setText("");
        btnOK.setText("submit");
    }

    @Override
    public void getData(List<DataNgaji> list) {
        adapter = new NgajiAdapter(getContext(),list,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void editData(DataNgaji item) {
        tvNama.setText(item.getNama());
        tvJuz.setText(item.getJuz());
        tvSurat.setText(item.getSurat());
        tvAyat.setText(item.getAyat());
        id = item.getId();
        edit = true;
        btnOK.setText("Update!");
    }

    @Override
    public void deleteData(DataNgaji item) {
        AlertDialog.Builder builder;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Anda yakin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    resetForm();
                    presenter.deleteData(item, appDatabase);
                })
                .setPositiveButton(android.R.string.no, (dialog, which) -> {
                  dialog.cancel();
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    @Override
    public void onClick(View view) {
        if(view == btnOK){
            if(tvNama.getText().toString().equals("") || tvJuz.getText().toString().equals("") || tvSurat.getText().toString().equals("") || tvAyat.getText().toString().equals("") ) {
                Toast.makeText(getContext(),"Harap isi semua data", Toast.LENGTH_SHORT).show();
            } else {
                if(!edit) presenter.insertData(tvNama.getText().toString(), tvJuz.getText().toString(), tvSurat.getText().toString(), tvAyat.getText().toString() , appDatabase);
                else{
                    // Jika mode edit, panggil fungsi edit DB
                    presenter.editData(tvNama.getText().toString(), tvJuz.getText().toString(), tvSurat.getText().toString(), tvAyat.getText().toString(), id, appDatabase);
                    edit = false;
                }
                resetForm();
            }
        }
    }
}
