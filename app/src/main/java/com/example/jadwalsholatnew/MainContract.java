package com.example.jadwalsholatnew;

import android.view.View;

import com.example.jadwalsholatnew.entity.AppDatabase;
import com.example.jadwalsholatnew.entity.DataNgaji;

import java.util.List;

public interface MainContract {

    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataNgaji> list);
        void editData(DataNgaji item);
        void deleteData(DataNgaji item);
    }

    interface presenter {
        void insertData(String nama, String juz, String surat, String ayat, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String juz, String surat, String ayat,int id, AppDatabase database );
        void deleteData(String dataNgaji, AppDatabase database);
    }
}
