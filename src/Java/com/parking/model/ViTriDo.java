/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
public class ViTriDo {
    private String maViTri;
    private String trangThai; 
    private String loaiCho; 

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
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }
    public void setLoaiCho(String loaiCho) {
        this.loaiCho = loaiCho;
    }
}

