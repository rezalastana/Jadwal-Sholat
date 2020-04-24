package com.example.jadwalsholatnew.service;

import com.example.jadwalsholatnew.model.jadwal.JadwalSholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JadwalRepository {
    @GET("v1/calendarByAddress?address=yogyakarta&method=2&month=05&year=2020")
    Call<JadwalSholatResponse> getJadwalSholat();

}
