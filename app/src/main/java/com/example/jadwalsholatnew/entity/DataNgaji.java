package com.example.jadwalsholatnew.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.Entity;

@Entity(tableName = "user_db")
public class DataNgaji {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "juz")
    private String juz;

    @ColumnInfo(name = "surat")
    private String surat;

    @ColumnInfo(name = "ayat")
    private String ayat;

    @NonNull

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJuz() {
        return juz;
    }

    public void setJuz(String juz) {
        this.juz = juz;
    }

    public String getSurat() {
        return surat;
    }

    public void setSurat(String surat) {
        this.surat = surat;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }
}
