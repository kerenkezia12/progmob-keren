package com.example.myfirstapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class Matkul {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("kode")
    @Expose
    private String kode;

    @SerializedName("hari")
    @Expose
    private int hari;

    @SerializedName("sesi")
    @Expose
    private int sesi;

    @SerializedName("sks")
    @Expose
    private int sks;

    @SerializedName("nim_progmob")
    @Expose
    private String nim_progmob;

    public Matkul(String id, String nama, String kode, int hari, int sesi, int sks, String nim_progmob) {
        this.id = id;
        this.nama = nama;
        this.kode = kode;
        this.hari = hari;
        this.sesi = sesi;
        this.sks = sks;
        this.nim_progmob = nim_progmob;
    }

    public Matkul(String nama, String kode, int hari, int sesi, int sks, String nim_progmob) {
        this.nama = nama;
        this.kode = kode;
        this.hari = hari;
        this.sesi = sesi;
        this.sks = sks;
        this.nim_progmob = nim_progmob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getHari() {
        return hari;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }

    public int getSesi() {
        return sesi;
    }

    public void setSesi(int sesi) {
        this.sesi = sesi;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getNim_progmob() {
        return nim_progmob;
    }

    public void setNim_progmob(String nim_progmob) {
        this.nim_progmob = nim_progmob;
    }
}
