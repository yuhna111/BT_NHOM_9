package com.parking;

import java.util.HashMap;
import java.util.Map;

public class BangGia {
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

    // ✅ THÊM PHƯƠNG THỨC CẬP NHẬT GIÁ
    public static void capNhatGiaTheoLoai(String loai, double giaMoi) {
        if (loai == null || giaMoi <= 0) return;
        defaultRates.put(loai.toUpperCase(), giaMoi);
    }

    public static double layGiaTheoLoai(String loai, double minutes) {
        double rate = defaultRates.getOrDefault(loai.toUpperCase(), 5000.0);
        double hours = Math.ceil(minutes / 60.0);
        return rate * hours;
    }

    // Getters
    public String getMaMucGia() { return maMucGia; }
    public String getLoaiPhuongTien() { return loaiPhuongTien; }
    public double getGiaTienCoBan() { return giaTienCoBan; }
}