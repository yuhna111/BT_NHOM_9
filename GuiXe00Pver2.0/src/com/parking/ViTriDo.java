package com.parking;

public class ViTriDo {
    private String maViTri;
    private String trangThai; // "TRONG", "DA_DAT", ...
    private String loaiCho; // "OTO", "XEMAY" ...

    public ViTriDo(String maViTri, String loaiCho) {
        this.maViTri = maViTri;
        this.loaiCho = loaiCho;
        this.trangThai = "TRONG";
    }

    public void datTrangThai(String s) {
        this.trangThai = s;
    }

    public boolean isTrong() {
        return "TRONG".equalsIgnoreCase(trangThai);
    }

    public String getLoaiCho() {
        return this.loaiCho;
    }
    public String getMaViTri() {
        return this.maViTri;
    }
    public String getTrangThai() {
        return trangThai;
    }
}