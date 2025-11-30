/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;
/**
 *
 * @author yuhna
 */
public class QuanTriVien extends NguoiDung {
    private String viTri;

    public QuanTriVien(String ma, String ten, String pass, String viTri) {
        super(ma, ten, pass);
        this.viTri = viTri;
    }
    public void capNhatBangGia(BangGia bg, double giaMoi) {
    }
    public void xemBaoCaoDoanhThu() {
    }
    public void quanLyNguoiDung(NguoiDung nd) {
    }
    public String getViTri() {
        return viTri;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}
