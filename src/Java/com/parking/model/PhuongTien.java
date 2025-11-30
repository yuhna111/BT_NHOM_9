/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
public abstract class PhuongTien {
    protected String bienSo;
    protected String mauSac;
    protected String hangXe;
    protected TheXe theLienKet;

    public PhuongTien(String bienSo, String mauSac, String hangXe) {
        this.bienSo = bienSo;
        this.mauSac = mauSac;
        this.hangXe = hangXe;
    }
    public void lienKetThe(TheXe t) { this.theLienKet = t; }

    public abstract double tinhKhauHao(long minutes);

    public String getBienSo() {
        return bienSo;
    }
    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
    public String getMauSac() {
        return mauSac;
    }
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public String getHangXe() {
        return hangXe;
    }
    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }
    public TheXe getTheLienKet() {
        return theLienKet;
    }
    public void setTheLienKet(TheXe theLienKet) {
        this.theLienKet = theLienKet;
    }

    public Object getLoaiPhuongTien() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

