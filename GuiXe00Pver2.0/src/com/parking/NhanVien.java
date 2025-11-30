package com.parking;

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

    // Getters
    public String getMaNhanVien() { return maNhanVien; }
    public String getCaLamViec() { return caLamViec; }
}