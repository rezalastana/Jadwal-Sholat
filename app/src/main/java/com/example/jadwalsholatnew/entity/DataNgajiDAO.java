package com.example.jadwalsholatnew.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataNgajiDAO {
    @Insert
    Long insertData(DataNgaji dataNgaji);

    @Query("select * from user_db")
    List<DataNgaji> getData();

    @Update
    int updateData(DataNgaji item);

    @Delete
    int deleteData(DataNgaji item);
}
