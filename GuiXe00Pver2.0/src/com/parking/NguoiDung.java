package com.parking;

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

    public void dangXuat() {}

    // Getters
    public String getMaNguoiDung() { return maNguoiDung; }
    public String getTenDangNhap() { return tenDangNhap; }
    public String getMatKhau() { return matKhau; }
}