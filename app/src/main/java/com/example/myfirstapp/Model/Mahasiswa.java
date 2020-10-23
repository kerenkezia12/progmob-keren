package com.example.myfirstapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class Mahasiswa {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nim")
    @Expose
    private String nim;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("foto")
    @Expose
    private String foto;

    @SerializedName("nim_progmob")
    @Expose
    private String nimProgmob;

    private String notelp;

    public Mahasiswa(String id, String nama, String nim, String alamat, String email, String foto, String nimProgmob, String notelp) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.email = email;
        this.foto = foto;
        this.nimProgmob = nimProgmob;
        this.notelp = notelp;
    }

    public Mahasiswa(String nama, String nim, String alamat, String email, String foto, String nimProgmob, String notelp) {
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
        this.email = email;
        this.foto = foto;
        this.nimProgmob = nimProgmob;
        this.notelp = notelp;
    }

    public Mahasiswa(String nama, String nim, String notelp) {
        this.nama = nama;
        this.nim = nim;
        this.notelp = notelp;
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

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNimProgmob() {
        return nimProgmob;
    }

    public void setNimProgmob(String nimProgmob) {
        this.nimProgmob = nimProgmob;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}
