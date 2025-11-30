/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
import java.util.HashMap;
import java.util.Map;

public class BangGia {

    public static void capNhatGiaTheoLoai(String loai, double gia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String maMucGia;
    private String loaiPhuongTien; 
    private double giaTienCoBan; 

    private static final Map<String, Double> defaultRates = new HashMap<>();
    static {
        defaultRates.put("XEMAY", 2000.0);
        defaultRates.put("OTO", 10000.0);
    }

    public BangGia(String maMucGia, String loaiPhuongTien, double giaTienCoBan) {
        this.maMucGia = maMucGia;
        this.loaiPhuongTien = loaiPhuongTien;
        this.giaTienCoBan = giaTienCoBan;
    }

    public static double layGiaTheoLoai(String loai, long minutes) {
        double rate = defaultRates.getOrDefault(loai.toUpperCase(), 5000.0);
        double hours = Math.ceil(minutes / 60.0);
        return rate * hours;
    }
    public String getMaMucGia() {
        return maMucGia;
    }
    public void setMaMucGia(String maMucGia) {
        this.maMucGia = maMucGia;
    }
    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }
    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }
    public double getGiaTienCoBan() {
        return giaTienCoBan;
    }
    public void setGiaTienCoBan(double giaTienCoBan) {
        this.giaTienCoBan = giaTienCoBan;
    }
}

