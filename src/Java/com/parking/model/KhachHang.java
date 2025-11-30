/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
import java.util.ArrayList;
import java.util.List;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private List<TheXe> danhSachThe = new ArrayList<>();

    public KhachHang(String ma, String ten) {
        this.maKhachHang = ma;
        this.tenKhachHang = ten;
    }
    public TheXe dangKiTheXe(String maThe) {
        TheXe t = new TheXe(maThe, this);
        danhSachThe.add(t);
        return t;
    }
    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public String getTenKhachHang() {
        return tenKhachHang;
    }
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    public List<TheXe> getDanhSachThe() {
        return danhSachThe;
    }
    public void setDanhSachThe(List<TheXe> danhSachThe) {
        this.danhSachThe = danhSachThe;
    }
}
