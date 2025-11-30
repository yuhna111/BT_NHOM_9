/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;
/**
 *
 * @author yuhna
 */
public class NhanVien extends NguoiDung {
    private String maNhanVien;
    private String caLamViec;

    public NhanVien(String ma, String ten, String pass, String maNV, String ca) {
        super(ma, ten, pass);
        this.maNhanVien = maNV;
        this.caLamViec = ca;
    }

    public GiaoDich taoGiaoDichMoi(String maGD, PhuongTien pt, TheXe the, BangGia bg) {
        return new GiaoDich(maGD, pt, the, bg, this);
    }

    public void xuLyKetThucGiaoDich(GiaoDich gd) {
        gd.ketThucGiaoDich();
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getCaLamViec() {
        return caLamViec;
    }
    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getChucVu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

