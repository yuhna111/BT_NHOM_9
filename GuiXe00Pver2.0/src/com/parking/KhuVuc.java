package com.parking;

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

    // Getters
    public String getMaKhuVuc() { return maKhuVuc; }
    public String getTenKhuVuc() { return tenKhuVuc; }
    public List<ViTriDo> getViTriDos() { return viTriDos; }
}