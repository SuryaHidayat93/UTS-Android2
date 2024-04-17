package com.example.myapplication;

public class MyData2 {
    private String surah;
    private String tanggal;
    private String status;

    public MyData2(String surah, String tanggal, String status) {
        this.surah = surah;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getSurah() {
        return surah;
    }

    public void setSurah(String surah) {
        this.surah = surah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
