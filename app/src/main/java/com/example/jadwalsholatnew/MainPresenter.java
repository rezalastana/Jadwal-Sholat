package com.example.jadwalsholatnew;

import android.os.AsyncTask;
import android.util.Log;

import com.example.jadwalsholatnew.entity.AppDatabase;
import com.example.jadwalsholatnew.entity.DataNgaji;

import java.util.List;

public class MainPresenter implements MainContract.presenter {
    private MainContract.view viewContract;

    public MainPresenter(MainContract.view viewContract) {
        this.viewContract = viewContract;
    }

    class InsertData extends AsyncTask<Void, Void, Long>{
        private AppDatabase database;
        private DataNgaji dataNgaji;

        public InsertData(AppDatabase database, DataNgaji dataNgaji){
            this.database = database;
            this.dataNgaji = dataNgaji;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataNgaji);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            viewContract.successAdd();
        }
    }
    @Override
    public void insertData(String nama, String juz, String surat, String ayat, AppDatabase database) {
        final DataNgaji dataNgaji = new DataNgaji();
        dataNgaji.setAyat(ayat);
        dataNgaji.setJuz(juz);
        dataNgaji.setSurat(surat);
        dataNgaji.setNama(nama);
        new InsertData(database, dataNgaji).execute();

    }

    @Override
    public void readData(AppDatabase database) {
        List<DataNgaji> list;
        list = database.dao().getData();
        viewContract.getData(list);
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private DataNgaji dataDiri;

        public EditData(AppDatabase database, DataNgaji dataNgaji) {
            this.database = database;
            this.dataDiri = dataNgaji;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataDiri);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            viewContract.successAdd();
        }
    }

    @Override
    public void editData(String nama, String juz, String surat, String ayat, int id, AppDatabase database) {
        final DataNgaji dataNgaji = new DataNgaji();
        dataNgaji.setAyat(ayat);
        dataNgaji.setJuz(juz);
        dataNgaji.setSurat(surat);
        dataNgaji.setNama(nama);
        dataNgaji.setId(id);
        new EditData(database, dataNgaji).execute();
    }


    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private DataNgaji dataNgaji;

        public DeleteData(AppDatabase database, DataNgaji dataNgaji) {
            this.database = database;
            this.dataNgaji = dataNgaji;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataNgaji);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewContract.successDelete();
        }

    }

    @Override
    public void deleteData(final DataNgaji dataNgaji, final AppDatabase database) {
        new DeleteData(database,dataNgaji).execute();
    }

}
