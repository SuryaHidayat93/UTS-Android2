package com.example.myapplication;

public class MyData {
    private String nama;
    private String kelas;
    private String progress;
    private String semester;
    private String date;

    public MyData(String nama, String kelas, String progress, String semester) {
        this.nama = nama;
        this.kelas = kelas;
        this.progress = progress;
        this.semester = semester;
        this.date = date;
    }

    // Buatlah getter dan setter sesuai kebutuhan
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
