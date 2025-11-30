package com.parking;

public class QuanTriVien extends NguoiDung {
    private String viTri;

    public QuanTriVien(String ma, String ten, String pass, String viTri) {
        super(ma, ten, pass);
        this.viTri = viTri;
    }

    public void capNhatBangGia(BangGia bg, double giaMoi) {}

    public void xemBaoCaoDoanhThu() {}

    public void quanLyNguoiDung(NguoiDung nd) {}
}