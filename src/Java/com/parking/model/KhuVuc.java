/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
import java.util.ArrayList;
import java.util.List;

public class KhuVuc {
    private String maKhuVuc;
    private String tenKhuVuc;
    private List<ViTriDo> viTriDos = new ArrayList<>();

    public KhuVuc(String maKhuVuc, String tenKhuVuc) {
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
    }

    public void addViTri(ViTriDo v) {
        viTriDos.add(v);
    }

    public ViTriDo timViTriTrong(String loaiXe) {
        for (ViTriDo v : viTriDos) {
            if (v.isTrong() && (v.getLoaiCho() == null || v.getLoaiCho().equalsIgnoreCase(loaiXe)))
                return v;
        }
        return null;
    }
    public String getMaKhuVuc() {
        return maKhuVuc;
    }
    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }
    public String getTenKhuVuc() {
        return tenKhuVuc;
    }
    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }
    public List<ViTriDo> getViTriDos() {
        return viTriDos;
    }
    public void setViTriDos(List<ViTriDo> viTriDos) {
        this.viTriDos = viTriDos;
    }
}
