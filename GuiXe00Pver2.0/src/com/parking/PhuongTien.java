package com.parking;

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

    // Getters
    public String getBienSo() { return bienSo; }
    public String getMauSac() { return mauSac; }
    public String getHangXe() { return hangXe; }
    public TheXe getTheLienKet() { return theLienKet; }
}