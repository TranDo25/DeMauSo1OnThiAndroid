package com.example.demauso1onthiandroid.model;

public class SinhVien_Lop {
    private int id;
    private int maSV;
    private int maLop;
    private int kyHoc;
    private int soTinChi;

    public SinhVien_Lop(int id, int maSV, int maLop, int kyHoc, int soTinChi) {
        this.id = id;
        this.maSV = maSV;
        this.maLop = maLop;
        this.kyHoc = kyHoc;
        this.soTinChi = soTinChi;
    }

    public SinhVien_Lop(int msv, int maLop, int kyHoc, int soTC) {
        this.maSV = maSV;
        this.maLop = maLop;
        this.kyHoc = kyHoc;
        this.soTinChi = soTinChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public int getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(int kyHoc) {
        this.kyHoc = kyHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
