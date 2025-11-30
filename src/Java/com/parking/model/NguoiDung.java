/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
public class NguoiDung {
    private String maNguoiDung;
    private String tenDangNhap;
    private String matKhau;

    public NguoiDung(String ma, String ten, String pass) {
        this.maNguoiDung = ma;
        this.tenDangNhap = ten;
        this.matKhau = pass;
    }

    public boolean dangNhap(String user, String pass) {
        return tenDangNhap.equals(user) && matKhau.equals(pass);
    }

    public void dangXuat() {
        // session clear
    }
    public String getMaNguoiDung() {
        return maNguoiDung;
    }
    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
    public String getTenDangNhap() {
        return tenDangNhap;
    }
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

