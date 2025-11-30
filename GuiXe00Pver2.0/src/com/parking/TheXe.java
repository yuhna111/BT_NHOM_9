package com.parking;

public class TheXe {
    private String maThe;
    private String trangThai; // "HOAT_DONG", "KHOA"
    private String loaiThe;
    private KhachHang chuSoHuu;

    public TheXe(String maThe, KhachHang chu) {
        this.maThe = maThe;
        this.chuSoHuu = chu;
        this.trangThai = "HOAT_DONG";
    }

    public void khoaThe() { this.trangThai = "KHOA"; }
    public void moKhoaThe() { this.trangThai = "HOAT_DONG"; }
    public boolean kiemTraTrangThaiHopLe() { return "HOAT_DONG".equalsIgnoreCase(trangThai); }

    // Getters
    public String getMaThe() { return maThe; }
    public String getTrangThai() { return trangThai; }
    public KhachHang getChuSoHuu() { return chuSoHuu; }
}