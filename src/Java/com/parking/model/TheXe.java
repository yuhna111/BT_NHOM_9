/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

import com.parking.model.KhachHang;

/**
 *
 * @author yuhna
 */
public class TheXe {
    private String maThe;
    private String trangThai; 
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

    public String getMaThe() {
        return maThe;
    }
    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public String getLoaiThe() {
        return loaiThe;
    }
    public void setLoaiThe(String loaiThe) {
        this.loaiThe = loaiThe;
    }
    public KhachHang getChuSoHuu() {
        return chuSoHuu;
    }
    public void setChuSoHuu(KhachHang chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }
}
