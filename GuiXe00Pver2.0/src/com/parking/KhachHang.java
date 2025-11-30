package com.parking;

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

    // Getters
    public String getMaKhachHang() { return maKhachHang; }
    public String getTenKhachHang() { return tenKhachHang; }
    public List<TheXe> getDanhSachThe() { return danhSachThe; }
}